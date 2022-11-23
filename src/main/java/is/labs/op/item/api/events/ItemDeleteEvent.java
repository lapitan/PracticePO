package is.labs.op.item.api.events;

import is.labs.op.item.api.aggregate.ItemAggregate;
import org.jetbrains.annotations.NotNull;
import ru.quipy.core.annotations.DomainEvent;
import ru.quipy.domain.Event;

import java.util.UUID;

@DomainEvent(name = "ITEM_DELETE_EVENT")
public class ItemDeleteEvent extends Event<ItemAggregate> {

    public ItemDeleteEvent(long version) {
        super(UUID.randomUUID(), "CART_CREATE_EVENT", version, System.currentTimeMillis());
    }
}
