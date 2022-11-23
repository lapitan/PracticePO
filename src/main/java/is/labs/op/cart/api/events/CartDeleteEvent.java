package is.labs.op.cart.api.events;

import is.labs.op.cart.api.aggregate.CartAggregate;
import org.jetbrains.annotations.NotNull;
import ru.quipy.core.annotations.DomainEvent;
import ru.quipy.domain.Event;

import java.util.UUID;

@DomainEvent(name = "CART_DELETE_EVENT")
public class CartDeleteEvent extends Event<CartAggregate> {

    public CartDeleteEvent(int version) {
        super(UUID.randomUUID(), "CART_DELETE_EVENT", version, System.currentTimeMillis());
    }
}
