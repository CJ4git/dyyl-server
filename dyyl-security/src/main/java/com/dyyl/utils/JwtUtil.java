package com.dyyl.utils;

import cn.hutool.core.util.IdUtil;
import com.dyyl.dto.LoginUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JwtUtil {

    public static String TOKEN_HEADER_NAME = "Authorization";
    public static String TOKEN_PREFIX = "Bearer";
    public static String SECRET = "DYYLJWTSECRET2023";
    public static String ClAIMS_KEY = "login_user_key";

    private static final ConcurrentHashMap<String,Object> USERINFO = new ConcurrentHashMap<>();

    /**
     * 根据用户信息创建token
     * @param user 登录用户
     * @return token
     */
    public static String createToken(LoginUser user) {
        String uuid = IdUtil.fastSimpleUUID();
        String claimsValue = ClAIMS_KEY + ":" + uuid;
        Map<String, Object> claims = new HashMap<>();
        claims.put(ClAIMS_KEY, claimsValue);

        //TODO 临时缓存
        USERINFO.put(claimsValue, user);

        return createToken(claims);
    }

    /**
     * 根据claims创建token
     * @param claims
     * @return
     */
    private static String createToken(Map<String,Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, SECRET).compact();
    }

    /**
     * 根据token获取用户信息
     * @param token
     * @return
     */
    public static LoginUser getLoginUserByToken(String token) {
        LoginUser loginUser = null;
        if(StringUtils.isNotBlank(token)) {
            Claims claims = parseToken(token);
            String loginUserKey = claims.get(ClAIMS_KEY).toString();
            loginUser = (LoginUser) USERINFO.get(loginUserKey);
        }
        return loginUser;
    }

    /**
     * 获取token中的数据
     * @param token
     * @return
     */
    private static Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }
}
