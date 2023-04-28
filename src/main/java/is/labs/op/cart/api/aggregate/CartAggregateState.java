package is.labs.op.cart.api.aggregate;


import is.labs.op.cart.api.dto.ItemInCartDto;
import is.labs.op.cart.api.events.CartConfirmEvent;
import is.labs.op.cart.api.events.CartCreateEvent;
//import is.labs.op.cart.api.events.CartDeleteEvent;
import is.labs.op.cart.api.events.CartDeleteEvent;
import is.labs.op.cart.api.events.CartUpdateEvent;
import is.labs.op.cart.api.model.Cart;
import is.labs.op.cart.api.model.CartItem;
import is.labs.op.item.api.model.Item;
import is.labs.op.user.api.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Nullable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.quipy.core.annotations.StateTransitionFunc;
import ru.quipy.domain.AggregateState;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;
import java.util.UUID;

@Document
@Slf4j
public class CartAggregateState implements AggregateState<UUID,CartAggregate> {

    private UUID cartId;

    private Long createdAt = System.currentTimeMillis();
    private Long updatedAt = System.currentTimeMillis();

    private String status="null";

    private String address;

    private Calendar notEarlierThan;
    private Calendar notLaterThan;

    private UUID customerId;

    private ArrayList<ItemInCartDto> items;

    private int version=0;


    @Nullable
    @Override
    public UUID getId() {
        return cartId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public CartCreateEvent createCartCommand(UUID customerId){
        log.info("cart create command for user"+customerId.toString());
        if (!status.equals("null")){
            log.error("cart already exists");
            throw new RuntimeException("Can't create cart, cart is already "+status);
        }
        CartCreateEvent cartCreateEvent=new CartCreateEvent(this.getVersion(), customerId);
        log.info("cart create command ended");
        return cartCreateEvent;
    }

    public CartConfirmEvent confirmCartCommand(UUID cartId, String address,Calendar notEarlierThan,Calendar notLaterThan){
        log.info("");
        if (status.equals("Deleted")){
            throw new RuntimeException("Can't confirm cart, cart is already "+status);
        }
        return new CartConfirmEvent(this.getVersion(),address,notEarlierThan,notLaterThan, cartId);
    }

    public CartUpdateEvent updateCartCommand(ArrayList<ItemInCartDto> items){
        if (status.equals("Deleted")){
            throw new RuntimeException("Can't update cart, cart is already "+status);
        }
        return new CartUpdateEvent(this.getVersion(), items);
    }

    public CartDeleteEvent deleteCartCommand(){
        if (status.equals("Deleted")){
            throw new RuntimeException("Can't delete cart, cart is already "+status);
        }
        return new CartDeleteEvent(this.getVersion(), cartId);
    }

    @StateTransitionFunc
    public void cartCreateApply(CartCreateEvent cartCreateEvent){
        cartId=cartCreateEvent.getCartId();
        updatedAt=createdAt;
        customerId=cartCreateEvent.getCustomerId();
        status="Created";
        version = (int)cartCreateEvent.getVersion();
    }

    @StateTransitionFunc
    public void cartConfirmApply(CartConfirmEvent cartConfirmEvent){
        this.status="Confirmed";
        updatedAt=cartConfirmEvent.getCreatedAt();
        version = (int)cartConfirmEvent.getVersion();
        this.address=cartConfirmEvent.getAddress();
        this.notEarlierThan=cartConfirmEvent.getNotEarlierThan();
        this.notLaterThan=cartConfirmEvent.getNotLaterThan();
    }

    @StateTransitionFunc
    public void cartUpdateApply(CartUpdateEvent cartUpdateEvent){
        version = (int)cartUpdateEvent.getVersion();
        updatedAt=cartUpdateEvent.getCreatedAt();
        items=cartUpdateEvent.getItems();
    }

    @StateTransitionFunc
    public void cartDeleteApply(CartDeleteEvent cartDeleteEvent){
        this.status="Deleted";
        version = (int)cartDeleteEvent.getVersion();
        updatedAt=cartDeleteEvent.getCreatedAt();
    }

    public UUID getCartId() {
        return cartId;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public String getStatus() {
        return status;
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

    public UUID getCustomerId() {
        return customerId;
    }

    public ArrayList<ItemInCartDto> getItems() {
        return items;
    }
}
