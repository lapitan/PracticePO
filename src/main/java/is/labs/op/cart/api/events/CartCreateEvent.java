package is.labs.op.cart.api.events;

import com.google.gson.JsonObject;
import is.labs.op.cart.api.aggregate.CartAggregate;
import is.labs.op.user.api.model.Customer;
import is.labs.op.utility.Jsonable;
import org.jetbrains.annotations.NotNull;
import ru.quipy.core.annotations.DomainEvent;
import ru.quipy.domain.Event;

import java.util.UUID;

@DomainEvent(name = "CART_CREATE_EVENT")
public class CartCreateEvent extends Event<CartAggregate> implements Jsonable {


    UUID customerId;

    UUID cartId;
    public CartCreateEvent(int version, UUID customerId) {
    super(UUID.randomUUID(), "CART_CREATE_EVENT", version, System.currentTimeMillis());
    this.customerId=customerId;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public UUID getCartId() {
        return cartId;
    }

    @Override
    public JsonObject toJson() {
        return null;
    }
}
