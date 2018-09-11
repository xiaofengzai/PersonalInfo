import com.enshub.personal.model.User;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {
    @Test
    public  void builderTest(){
        User user=User.builder().nickname("afeng").username("waziee").password("123").build();
        System.out.println(user.getNickname());
    }
}
