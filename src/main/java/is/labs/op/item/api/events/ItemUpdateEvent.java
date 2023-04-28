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

    UUID itemId;
    public ItemUpdateEvent(int version, float price, int quantityAvailable, UUID itemId) {
        super(UUID.randomUUID(), "ITEM_UPDATE_EVENT", version, System.currentTimeMillis());
        this.price=price;
        this.quantityAvailable=quantityAvailable;
        this.itemId=itemId;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }
}
