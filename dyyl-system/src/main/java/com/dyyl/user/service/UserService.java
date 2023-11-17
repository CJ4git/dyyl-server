package com.dyyl.user.service;

import com.dyyl.dto.LoginUser;
import com.dyyl.dto.sys.Response;
import com.dyyl.user.dto.User;
import com.dyyl.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    public Response<?> login(User user) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authentication);
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        return Response.success("",JwtUtil.createToken(loginUser));
    }
}
