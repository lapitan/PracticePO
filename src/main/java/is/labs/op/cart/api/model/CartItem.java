package is.labs.op.cart.api.model;

import is.labs.op.item.api.model.Item;

import javax.persistence.*;

@Entity
public class CartItem {

    @EmbeddedId
    CartItemId cartItemId;

    @ManyToOne
    @MapsId("cartId")
    @JoinColumn(name="cart_id")
    Cart cart;

    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name="item_id")
    Item item;

    @Column
    int quantity;

}
