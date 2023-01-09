package is.labs.op.cart.api.aggregate;

import is.labs.op.cart.api.events.CartConfirmEvent;
import is.labs.op.cart.api.events.CartCreateEvent;
import is.labs.op.cart.api.events.CartDeleteEvent;
import is.labs.op.cart.api.events.CartUpdateEvent;
import ru.quipy.core.annotations.AggregateType;
import ru.quipy.domain.Aggregate;

@AggregateType(aggregateEventsTableName = "cart_aggregate")
public class CartAggregate implements Aggregate {

}
