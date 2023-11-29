package com.dyyl.service;

import com.dyyl.dto.LoginUser;
import com.dyyl.dto.user.SysUser;
import com.dyyl.mapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userDao;

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("=====loadUserByUsername===========");
        SysUser user = userDao.selectOne(null);
        LoginUser loginUser = new LoginUser();
        loginUser.setUser(user);
        if(user == null) {
            throw new UsernameNotFoundException("用户名或密码错误！");
        }
        return loginUser;
    }
}
