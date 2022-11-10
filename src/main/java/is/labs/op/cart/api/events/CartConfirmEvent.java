package is.labs.op.cart.api.events;

import is.labs.op.cart.api.aggregate.CartAggregate;
import org.jetbrains.annotations.NotNull;
import ru.quipy.core.annotations.DomainEvent;
import ru.quipy.domain.Event;

import java.util.UUID;

@DomainEvent(name = "CART_CONFIRM_EVENT")
public class CartConfirmEvent extends Event<CartAggregate> {

    private String address;
    public CartConfirmEvent(long version, String address) {
        super(UUID.randomUUID(), "CART_CONFIRM_EVENT", version, System.currentTimeMillis());
        this.address=address;
    }

    public String getAddress() {
        return address;
    }
}
