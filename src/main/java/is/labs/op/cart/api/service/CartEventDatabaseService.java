package is.labs.op.cart.api.service;

import is.labs.op.cart.api.aggregate.CartAggregate;
import is.labs.op.cart.api.events.CartConfirmEvent;
import is.labs.op.cart.api.events.CartCreateEvent;
import is.labs.op.cart.api.events.CartDeleteEvent;
import is.labs.op.cart.api.events.CartUpdateEvent;
import is.labs.op.cart.api.model.CartEventEntity;
import is.labs.op.cart.api.repository.CartEventRepository;
import org.springframework.stereotype.Service;
import ru.quipy.core.AggregateRegistry;
import ru.quipy.streams.AggregateSubscriptionsManager;
import ru.quipy.streams.annotation.AggregateSubscriber;
import ru.quipy.streams.annotation.SubscribeEvent;

import javax.annotation.PostConstruct;

@Service
@AggregateSubscriber(aggregateClass = CartAggregate.class, subscriberName = "cart-event-to-database")
public class CartEventDatabaseService {

    private final CartEventRepository cartEventRepository;
    private final AggregateSubscriptionsManager subscriptionsManager;
    private final CartEventDatabaseService instance;
//    private final AggregateRegistry aggregateRegistry;

    public CartEventDatabaseService(CartEventRepository cartEventRepository, AggregateSubscriptionsManager subscriptionsManager/*, AggregateRegistry aggregateRegistry*/) {

        this.cartEventRepository = cartEventRepository;
        this.subscriptionsManager = subscriptionsManager;
//        this.aggregateRegistry = aggregateRegistry;
        instance=this;
    }

    @PostConstruct
    private void subscribe() {
//        aggregateRegistry.register(CartAggregate.class,);
        subscriptionsManager.subscribe(instance);
    }

    @SubscribeEvent
    void cartCreatedSubscriber(CartCreateEvent cartEvent) {

        CartEventEntity cartEventEntity = new CartEventEntity();
        cartEventEntity.setCartId(cartEvent.getCartId());
        cartEventEntity.setEventType(cartEvent.getName());
        cartEventEntity.setId(cartEvent.getId());
        cartEventEntity.setData(cartEvent.toJson().toString());

        cartEventRepository.save(cartEventEntity);
    }

    @SubscribeEvent
    void cartConfirmedSubscriber(CartConfirmEvent cartEvent) {

        CartEventEntity cartEventEntity = new CartEventEntity();
        cartEventEntity.setCartId(cartEvent.getCartId());
        cartEventEntity.setEventType(cartEvent.getName());
        cartEventEntity.setId(cartEvent.getId());
        cartEventEntity.setData(cartEvent.toJson().toString());

        cartEventRepository.save(cartEventEntity);

    }

    @SubscribeEvent
    void cartDeletedSubscriber(CartDeleteEvent cartEvent) {
        CartEventEntity cartEventEntity = new CartEventEntity();
        cartEventEntity.setCartId(cartEvent.getCartId());
        cartEventEntity.setEventType(cartEvent.getName());
        cartEventEntity.setId(cartEvent.getId());
        cartEventEntity.setData(cartEvent.toJson().toString());

        cartEventRepository.save(cartEventEntity);
    }

    @SubscribeEvent
    void cartUpdateEvent(CartUpdateEvent cartEvent) {
        CartEventEntity cartEventEntity = new CartEventEntity();
        cartEventEntity.setCartId(cartEvent.getCartId());
        cartEventEntity.setEventType(cartEvent.getName());
        cartEventEntity.setId(cartEvent.getId());
        cartEventEntity.setData(cartEvent.toJson().toString());

        cartEventRepository.save(cartEventEntity);
    }

}
