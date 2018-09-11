import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.enshub.personal")
public class PersonalInfoApplication {
    public static void main(String [] args) {
        SpringApplication.run(PersonalInfoApplication.class, args);

    }
}
