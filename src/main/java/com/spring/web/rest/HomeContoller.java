package com.spring.web.rest;

import com.spring.domain.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by mac on 2017/9/22.
 */
@Controller
public class HomeContoller {
    @RequestMapping("/")
    public String index(Model model){
        Msg msg=new Msg("测试标题","测试内容","额外信息，只对管理员显示");
        model.addAttribute(msg);
        return "home";
    }
    @RequestMapping(value = "/admin" ,method = RequestMethod.POST)
    public String admin(){

        return "admin";
    }
}
