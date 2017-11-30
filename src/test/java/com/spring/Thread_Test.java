package com.spring;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by mac on 2017/9/26.
 */
public class Thread_Test {
    public static void main(String[] args) {
//        Callable<Integer>callable=new MyCallable();
//        FutureTask<Integer>futureTask=new FutureTask<Integer>(callable);
        MyRunnable myRunnable=new MyRunnable();
        Thread thread=new Thread(myRunnable);

        for (int i=0;i<1500;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
            if(i==30){
//                Thread thread1=new Thread(futureTask);
//                thread1.start();
                thread.start();
            }
            if(i==800){
                thread.stop();
            }
        }
        System.out.println("for循环结束");
//        try {
//            int sum=futureTask.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

    }
}


class MyCallable implements Callable<Integer> {
    private int i = 0;

    // 与run()方法不同的是，call()方法具有返回值
    @Override
    public Integer call() {
        int sum = 0;
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            sum += i;
        }
        return sum;
    }



}

class MyCallable1 implements Callable<Integer>{
    private static ReentrantLock lock=new ReentrantLock();
    private Integer i=0;
    @Override
    public Integer call() throws Exception {
        int sum=0;
        for(;i<200;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
            sum+=i;
        }
        return sum;
    }

}
class MyRunnable implements Runnable{
private boolean stop=false;
    @Override
    public void run() {
        for (int i=1;i<300;i++){
            System.out.println(Thread.currentThread().getName()+" ss "+i);
        }
    }
    public void stopThread(){
            this.stop=true;
    }
}