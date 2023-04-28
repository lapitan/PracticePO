package is.labs.op.cart.api.events;

import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import is.labs.op.cart.api.aggregate.CartAggregate;
import is.labs.op.utility.Jsonable;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.quipy.core.annotations.DomainEvent;
import ru.quipy.domain.Event;

import java.util.Calendar;
import java.util.UUID;

@DomainEvent(name = "CART_CONFIRM_EVENT")
@Document
public class CartConfirmEvent extends Event<CartAggregate> implements Jsonable {

    private String address;
    private Calendar notEarlierThan;
    private Calendar notLaterThan;

    private UUID cartId;


    public CartConfirmEvent(long version, String address, Calendar notEarlierThan, Calendar notLaterThan, UUID cartId) {
        super(UUID.randomUUID(), "CART_CONFIRM_EVENT", version, System.currentTimeMillis());
        this.address=address;
        this.notEarlierThan=notEarlierThan;
        this.notLaterThan=notLaterThan;
        this.cartId=cartId;
    }

    public String getAddress() {
        return address;
    }

    public Calendar getNotEarlierThan() {
        return notEarlierThan;
    }

    public Calendar getNotLaterThan() {
        return notLaterThan;
    }

    public UUID getCartId() {
        return cartId;
    }

    @Override
    public JsonObject toJson() {
        return null;
    }
}
