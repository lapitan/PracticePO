package is.labs.op;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class PoApplication {
    public static void main(String[] args) {
        SpringApplication.run(PoApplication.class,args);
    }
}
