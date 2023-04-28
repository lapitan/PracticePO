package is.labs.op.cart.api.events;

import com.google.gson.JsonObject;
import is.labs.op.cart.api.aggregate.CartAggregate;
import is.labs.op.utility.Jsonable;
import org.jetbrains.annotations.NotNull;
import ru.quipy.core.annotations.DomainEvent;
import ru.quipy.domain.Event;

import java.util.UUID;

@DomainEvent(name = "CART_DELETE_EVENT")
public class CartDeleteEvent extends Event<CartAggregate> implements Jsonable {

    UUID cartId;
    public CartDeleteEvent(int version, UUID cartId) {
        super(UUID.randomUUID(), "CART_DELETE_EVENT", version, System.currentTimeMillis());
        this.cartId=cartId;
    }

    @Override
    public JsonObject toJson() {
        return null;
    }

    public UUID getCartId() {
        return cartId;
    }
}
