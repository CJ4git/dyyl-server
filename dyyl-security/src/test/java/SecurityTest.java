import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author cj
 * @Description
 * @Date 2023/11/17
 */
@SpringBootTest
public class SecurityTest {

    @Test
    public void testUserPwd() {
        System.out.println("new BCryptPasswordEncoder().encode(\"123456\") = " + new BCryptPasswordEncoder().encode("123456"));
    }
}
