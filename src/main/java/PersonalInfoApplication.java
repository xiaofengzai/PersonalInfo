import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
@ComponentScan("com.enshub.personal")
public class PersonalInfoApplication {
    public static void main(String [] args) {
        SpringApplication.run(PersonalInfoApplication.class, args);

    }
}
