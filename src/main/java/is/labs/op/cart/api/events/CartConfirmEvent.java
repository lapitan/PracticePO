package is.labs.op.cart.api.events;

import is.labs.op.cart.api.aggregate.CartAggregate;
import org.jetbrains.annotations.NotNull;
import ru.quipy.core.annotations.DomainEvent;
import ru.quipy.domain.Event;

import java.util.Calendar;
import java.util.UUID;

@DomainEvent(name = "CART_CONFIRM_EVENT")
public class CartConfirmEvent extends Event<CartAggregate> {

    private String address;

    private Calendar notEarlierThan;
    private Calendar notLaterThan;
    public CartConfirmEvent(long version, String address, Calendar notEarlierThan, Calendar notLaterThan) {
        super(UUID.randomUUID(), "CART_CONFIRM_EVENT", version, System.currentTimeMillis());
        this.address=address;
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
}
