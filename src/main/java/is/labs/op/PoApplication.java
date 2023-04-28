package is.labs.op;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import ru.quipy.streams.AggregateSubscriptionsManager;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@EnableMongoRepositories
public class PoApplication {
    public static void main(String[] args) {
        SpringApplication.run(PoApplication.class,args);
    }
}
