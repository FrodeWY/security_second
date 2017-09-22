package com.spring.repository;

import com.spring.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mac on 2017/9/22.
 */
public interface SysUserRepository extends JpaRepository<SysUser,Long> {
    SysUser findByUsername(String username);
}
