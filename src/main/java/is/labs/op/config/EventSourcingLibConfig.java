package is.labs.op.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.quipy.core.AggregateRegistry;
import ru.quipy.core.BasicAggregateRegistry;
import ru.quipy.core.EventSourcingProperties;
import ru.quipy.core.SeekingForSuitableClassesAggregateRegistry;
import ru.quipy.database.EventStoreDbOperations;
import ru.quipy.streams.AggregateEventStreamManager;

@Configuration
public class EventSourcingLibConfig {

    /*@Bean
    EventStoreDbOperations eventStoreDbOperations(){

    }*/

    @Bean
    @ConfigurationProperties(prefix = "event.sourcing")
    EventSourcingProperties configProperties(){
        return new EventSourcingProperties();
    };

    @Bean
    AggregateRegistry aggregateRegistry(EventSourcingProperties eventSourcingProperties){
        return new SeekingForSuitableClassesAggregateRegistry(new BasicAggregateRegistry(),eventSourcingProperties);
    }

    /*@Bean(destroyMethod = "destroy")
    AggregateEventStreamManager eventStreamManager(EventSourcingProperties eventSourcingProperties, AggregateRegistry aggregateRegistry, ){
        return new AggregateEventStreamManager(aggregateRegistry, )
    }*/


}
