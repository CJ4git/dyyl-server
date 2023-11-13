package com.dyyl.user.service;

import com.dyyl.dto.LoginUser;
import com.dyyl.dto.sys.Response;
import com.dyyl.user.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {

    /**
     * 暂时使用 map 充当缓存
     */
    public static ConcurrentHashMap<String,LoginUser> userInfo = new ConcurrentHashMap<>();

    @Autowired
    private AuthenticationManager authenticationManager;

    public Response<?> login(User user) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authentication);
        if(authenticate == null) {
            throw new RuntimeException("用户名密码错误");
        }
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userId = loginUser.getUser().getId();
        return Response.success();
    }
}
