package com.dyyl;

import com.dyyl.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DyylSystemApplicationTests {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    void contextLoads() {
    }

    @Test
    public void testUserPwd() {
    }

    @Test
    void redisSet() {
//        redisTemplate.opsForValue().set("redisTest","hello redis");
        List<String> list = new ArrayList<>();
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");
        list.add("wangwu");
//        redisTemplate.opsForList().leftPush("listTest",list);
        redisUtil.leftPush("listUtil",list);
    }

    @Test
    void redisGet() {
//        System.out.println(redisTemplate.opsForValue().get("redisTest"));
//        System.out.println(redisTemplate.opsForList().range("listTest",0,-1));
        System.out.println(redisUtil.range("listUtil", 0, -1));
    }
}
