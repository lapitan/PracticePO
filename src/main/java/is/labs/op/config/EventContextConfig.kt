package `is`.labs.op.config;

import `is`.labs.op.cart.api.aggregate.CartAggregate
import `is`.labs.op.cart.api.aggregate.CartAggregateState
import `is`.labs.op.item.api.aggregate.ItemAggregate
import `is`.labs.op.item.api.aggregate.ItemAggregateState
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.quipy.core.EventSourcingService;
import ru.quipy.core.EventSourcingServiceFactory;

import java.util.UUID;

@Configuration
open class EventContextConfig {

    @Autowired
    private lateinit var eventSourcingServiceFactory: EventSourcingServiceFactory

    @Bean()
    open fun cartEventStoreService(): EventSourcingService<UUID, CartAggregate, CartAggregateState> =
        eventSourcingServiceFactory.create()

    @Bean
    open fun itemEventStoreService(): EventSourcingService<UUID, ItemAggregate, ItemAggregateState> =
        eventSourcingServiceFactory.create()
}
