package is.labs.op.cart.api.response;

import is.labs.op.cart.api.aggregate.CartAggregateState;
import is.labs.op.cart.api.dto.ItemInCartDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

@Data
public class CartResponse {

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

    public CartResponse(CartAggregateState cartAggregateState) {
        this.cartId = cartAggregateState.getCartId();
        this.createdAt = cartAggregateState.getCreatedAt();
        this.updatedAt = cartAggregateState.getUpdatedAt();
        this.status = cartAggregateState.getStatus();
        this.address = cartAggregateState.getAddress();
        this.notEarlierThan = cartAggregateState.getNotEarlierThan();
        this.notLaterThan = cartAggregateState.getNotLaterThan();
        this.customerId = cartAggregateState.getCustomerId();
        this.items = cartAggregateState.getItems();
        this.version = cartAggregateState.getVersion();
    }
}
