package is.labs.op.item.api.events;

import is.labs.op.item.api.aggregate.ItemAggregate;
import org.jetbrains.annotations.NotNull;
import ru.quipy.core.annotations.DomainEvent;
import ru.quipy.domain.Event;

import java.util.UUID;

@DomainEvent(name = "ITEM_UPDATE_EVENT")
public class ItemUpdateEvent extends Event<ItemAggregate> {

    float price;
    int quantityAvailable;
    public ItemUpdateEvent(int version, float price, int quantityAvailable) {
        super(UUID.randomUUID(), "CART_CREATE_EVENT", version, System.currentTimeMillis());
        this.price=price;
        this.quantityAvailable=quantityAvailable;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }
}
