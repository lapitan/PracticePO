package is.labs.op.cart.api.aggregate;


import is.labs.op.cart.api.events.CartConfirmEvent;
import is.labs.op.cart.api.events.CartCreateEvent;
import is.labs.op.cart.api.events.CartDeleteEvent;
import is.labs.op.cart.api.events.CartUpdateEvent;
import is.labs.op.cart.api.model.Cart;
import is.labs.op.cart.api.model.CartItem;
import is.labs.op.item.api.model.Item;
import is.labs.op.user.api.model.Customer;
import org.jetbrains.annotations.Nullable;
import ru.quipy.core.annotations.StateTransitionFunc;
import ru.quipy.domain.AggregateState;

import java.util.Calendar;
import java.util.Set;

public class CartAggregateState implements AggregateState<Integer,CartAggregate> {

    private int cartId;

    private Long createdAt = System.currentTimeMillis();
    private Long updatedAt = System.currentTimeMillis();

    private String status="null";

    private String address;

    private Calendar notEarlierThan;
    private Calendar notLaterThan;

    private Customer customer;

    private Set<CartItem> items;

    private int version=0;


    @Nullable
    @Override
    public Integer getId() {
        return cartId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public CartCreateEvent createCartCommand(Customer customer){
        if (!status.equals("null")){
            throw new RuntimeException("Can't create cart, cart is already "+status);
        }
        return new CartCreateEvent(this.getVersion(), customer);
    }

    public CartConfirmEvent confirmCartCommand(String address,Calendar notEarlierThan,Calendar notLaterThan){
        if (status.equals("Deleted")){
            throw new RuntimeException("Can't confirm cart, cart is already "+status);
        }
        return new CartConfirmEvent(this.getVersion(),address,notEarlierThan,notLaterThan);
    }

    public CartDeleteEvent deleteCartCommand(){
        if (status.equals("Deleted")){
            throw new RuntimeException("Can't delete cart, cart is already "+status);
        }
        return new CartDeleteEvent(this.getVersion());
    }

    public CartUpdateEvent updateCartCommand(Set<CartItem> items){
        if (status.equals("Deleted")){
            throw new RuntimeException("Can't update cart, cart is already "+status);
        }
        return new CartUpdateEvent(this.getVersion(), items);
    }

    @StateTransitionFunc
    public void cartCreateApply(CartCreateEvent cartCreateEvent){
        this.cartId=Integer.parseInt(cartCreateEvent.getId().toString());
        updatedAt=createdAt;
        this.customer=cartCreateEvent.getCustomer();
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
    public void cartDeleteApply(CartDeleteEvent cartDeleteEvent){
        this.status="Deleted";
        updatedAt=cartDeleteEvent.getCreatedAt();
        version = (int)cartDeleteEvent.getVersion();
    }

    @StateTransitionFunc
    public void cartUpdateApply(CartUpdateEvent cartUpdateEvent){
        version = (int)cartUpdateEvent.getVersion();
        updatedAt=cartUpdateEvent.getCreatedAt();
        items=cartUpdateEvent.getItems();
    }
}
