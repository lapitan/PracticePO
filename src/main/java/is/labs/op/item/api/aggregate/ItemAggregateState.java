package is.labs.op.item.api.aggregate;

import is.labs.op.item.api.events.ItemCreateEvent;
import is.labs.op.item.api.events.ItemDeleteEvent;
import is.labs.op.item.api.events.ItemUpdateEvent;
import is.labs.op.item.api.events.ItemCreateEvent;
import is.labs.op.user.api.model.Customer;
import org.jetbrains.annotations.Nullable;
import ru.quipy.core.annotations.StateTransitionFunc;
import ru.quipy.domain.AggregateState;

import java.util.Calendar;
import java.util.Set;

public class ItemAggregateState implements AggregateState<Integer, ItemAggregate> {

    int itemId;

    String name;

    float price;

    int quantityAvailable;

    private Long createdAt = System.currentTimeMillis();
    private Long updatedAt = System.currentTimeMillis();
    int version=0;

    String status="null";

    @Nullable
    @Override
    public Integer getId() {
        return itemId;
    }

    public int getVersion() {
        return version;
    }

    public ItemCreateEvent createItemCommand(String name, float price, int quantityAvailable){
        if (!status.equals("null")){
            throw new RuntimeException("Can't create item, item is already "+status);
        }
        return new ItemCreateEvent(this.getVersion(), name, price, quantityAvailable);
    }

    public ItemDeleteEvent deleteItemCommand(){
        if (status.equals("Deleted")){
            throw new RuntimeException("Can't delete item, item is already "+status);
        }
        return new ItemDeleteEvent(this.getVersion());
    }

    public ItemUpdateEvent updateItemCommand(float price, int quantityAvailable){
        if (status.equals("Deleted")){
            throw new RuntimeException("Can't update item, item is already "+status);
        }
        return new ItemUpdateEvent(this.getVersion(), price, quantityAvailable);
    }

    @StateTransitionFunc
    public void itemCreateApply(ItemCreateEvent itemCreateEvent){
        this.itemId=Integer.parseInt(itemCreateEvent.getId().toString());
        updatedAt=createdAt;
        this.name=itemCreateEvent.getItemName();
        this.price=itemCreateEvent.getPrice();
        this.quantityAvailable=itemCreateEvent.getQuantityAvailable();
        version=(int) itemCreateEvent.getVersion();
        status="Created";
    }

    @StateTransitionFunc
    public void itemDeleteApply(ItemDeleteEvent itemDeleteEvent){
        this.status="Deleted";
        updatedAt=itemDeleteEvent.getCreatedAt();
        version=(int) itemDeleteEvent.getVersion();
    }

    @StateTransitionFunc
    public void itemUpdateApply(ItemUpdateEvent itemUpdateEvent){
        version=(int) itemUpdateEvent.getVersion();
        updatedAt=itemUpdateEvent.getCreatedAt();
        this.price=itemUpdateEvent.getPrice();
        this.quantityAvailable=itemUpdateEvent.getQuantityAvailable();

    }

}
