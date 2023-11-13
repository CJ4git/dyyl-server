package com.dyyl.user.controller;

import com.dyyl.dto.sys.Response;
import com.dyyl.user.dto.User;
import com.dyyl.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getCaptcha")
    public Response<?> getCaptcha() {
        return null;
    }

    @PostMapping("/login")
    public Response<?> login(@RequestBody User user) {
        return userService.login(user);
    }
}
