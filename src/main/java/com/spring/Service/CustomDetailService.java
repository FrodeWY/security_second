package com.spring.Service;

import com.spring.domain.SysUser;
import com.spring.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by mac on 2017/9/22.
 */
@Service
public class CustomDetailService implements UserDetailsService{
    @Autowired
    SysUserRepository sysUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser=sysUserRepository.findByUsername(username);
        if(sysUser==null){
            throw  new UsernameNotFoundException("用户名不存在");
        }
        return  sysUser;
    }
}
