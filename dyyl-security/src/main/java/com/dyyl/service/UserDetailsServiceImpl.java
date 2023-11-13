package com.dyyl.service;

import com.dyyl.dao.UserDao;
import com.dyyl.dto.LoginUser;
import com.dyyl.dto.user.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("=====loadUserByUsername===========");
        SysUser user = userDao.getSysUserByName(username);
        if(user == null) {
            throw new UsernameNotFoundException("用户名或密码错误！");
        }
        return new LoginUser(user);
    }
}
