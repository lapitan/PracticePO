package is.labs.op.cart.api.events;

import com.google.gson.JsonObject;
import is.labs.op.cart.api.aggregate.CartAggregate;
import is.labs.op.cart.api.model.CartItem;
import is.labs.op.item.api.model.Item;
import is.labs.op.utility.Jsonable;
import org.jetbrains.annotations.NotNull;
import ru.quipy.core.annotations.DomainEvent;
import ru.quipy.domain.Event;

import java.util.Set;
import java.util.UUID;

@DomainEvent(name = "CART_UPDATE_EVENT")
public class CartUpdateEvent extends Event<CartAggregate> implements Jsonable {

    UUID cartId;
    Set<CartItem> items;

    public CartUpdateEvent(int version, Set<CartItem> items) {
        super(UUID.randomUUID(), "CART_UPDATE_EVENT", version, System.currentTimeMillis());
        this.items = items;
    }

    public Set<CartItem> getItems() {
        return items;
    }

    public UUID getCartId() {
        return cartId;
    }

    @Override
    public JsonObject toJson() {
        return null;
    }
}
