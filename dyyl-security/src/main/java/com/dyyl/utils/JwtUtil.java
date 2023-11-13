package com.dyyl.utils;

import cn.hutool.core.util.IdUtil;
import com.dyyl.dto.LoginUser;

public class JwtUtil {

    public static String TOKEN_PREFIX = "Bearer";
    public static String SECRET = "dyyl-cd";

    public String createToken(LoginUser user) {
        String uuid = IdUtil.fastSimpleUUID();

    }
}
