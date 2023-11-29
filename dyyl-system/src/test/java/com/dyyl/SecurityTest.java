package com.dyyl;

import com.dyyl.dto.user.SysUser;
import com.dyyl.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cj
 * @Description
 * @Date 2023/11/29
 */
@SpringBootTest
public class SecurityTest {

    @Resource
    UserMapper userDao;

    @Test
    void userGetTest() {
        List<SysUser> userList = userDao.selectList(null);
        userList.forEach(System.out::println);
    }
}
