/*
package is.labs.op.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.quipy.core.*;
import ru.quipy.database.EventStore;
import ru.quipy.mapper.EventMapper;
import ru.quipy.mapper.JsonEventMapper;
import ru.quipy.streams.AggregateEventStreamManager;
import ru.quipy.streams.AggregateSubscriptionsManager;

@Configuration
public class EventSourcingLibConfig {

    @Bean
    @ConditionalOnMissingBean
    ObjectMapper jsonObjectMapper() {
        return new ObjectMapper();
    }

    @Bean
    @ConditionalOnMissingBean
    EventMapper eventMapper(ObjectMapper jsonObjectMapper) {
        return new JsonEventMapper(jsonObjectMapper);
    }

    */
/*@Bean
    EventStoreDbOperations eventStoreDbOperations(){

    }*//*


    @Bean
    @ConfigurationProperties(prefix = "event.sourcing")
    EventSourcingProperties configProperties() {
        return new EventSourcingProperties();
    }

    ;

    @Bean
    @ConditionalOnMissingBean
    AggregateRegistry aggregateRegistry(EventSourcingProperties eventSourcingProperties) {

        return new SeekingForSuitableClassesAggregateRegistry(new BasicAggregateRegistry(), eventSourcingProperties);
    }

    @Bean(destroyMethod = "destroy")
    @ConditionalOnBean(EventStore.class)
    @ConditionalOnMissingBean
    AggregateEventStreamManager eventStreamManager(EventSourcingProperties eventSourcingProperties,
                                                   AggregateRegistry aggregateRegistry,
                                                   EventStore eventStore) {
        return new AggregateEventStreamManager(aggregateRegistry,
                eventStore,
                eventSourcingProperties);
    }

    @Bean(destroyMethod = "destroy")
    @ConditionalOnBean(EventStore.class)
    @ConditionalOnMissingBean
    AggregateSubscriptionsManager subscriptionsManager(AggregateEventStreamManager eventStreamManager,
                                                       AggregateRegistry aggregateRegistry,
                                                       JsonEventMapper eventMapper) {
        return new AggregateSubscriptionsManager(eventStreamManager,
                aggregateRegistry,
                eventMapper);
    }

    @Bean
    @ConditionalOnBean(EventStore.class)
    @ConditionalOnMissingBean
    EventSourcingServiceFactory eventSourcingServiceFactory(EventSourcingProperties eventSourcingProperties,
                                                            AggregateRegistry aggregateRegistry,
                                                            JsonEventMapper eventMapper,
                                                            EventStore eventStore) {
        return new EventSourcingServiceFactory(aggregateRegistry,
                eventMapper,
                eventStore,
                eventSourcingProperties);
    }


}
*/
