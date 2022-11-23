package is.labs.op.cart.api.events;

import is.labs.op.cart.api.aggregate.CartAggregate;
import is.labs.op.user.api.model.Customer;
import org.jetbrains.annotations.NotNull;
import ru.quipy.core.annotations.DomainEvent;
import ru.quipy.domain.Event;

import java.util.UUID;

@DomainEvent(name = "CART_CREATE_EVENT")
public class CartCreateEvent extends Event<CartAggregate> {

    Customer customer;
    public CartCreateEvent(int version, Customer customer) {
    super(UUID.randomUUID(), "CART_CREATE_EVENT", version, System.currentTimeMillis());
    this.customer=customer;
    }

    public Customer getCustomer() {
        return customer;
    }
}
