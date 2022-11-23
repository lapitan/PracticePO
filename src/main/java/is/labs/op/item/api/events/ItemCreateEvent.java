package is.labs.op.item.api.events;

import is.labs.op.item.api.aggregate.ItemAggregate;
import ru.quipy.core.annotations.DomainEvent;
import ru.quipy.domain.Event;

import java.util.UUID;

@DomainEvent(name = "ITEM_CREATE_EVENT")
public class ItemCreateEvent extends Event<ItemAggregate> {

    String itemName;
    float price;
    int quantityAvailable;
    public ItemCreateEvent(int version, String itemName, float price, int quantityAvailable) {
        super(UUID.randomUUID(), "CART_CREATE_EVENT", version, System.currentTimeMillis());
        this.itemName=itemName;
        this.price=price;
        this.quantityAvailable=quantityAvailable;
    }

    public String getItemName() {
        return itemName;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }
}