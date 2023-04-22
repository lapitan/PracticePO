package is.labs.op.cart.api.model;

import is.labs.op.item.api.model.Item;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.*;

@Data
//@Entity
@Document("CartItem")
public class CartItem {

    @Id
    CartItemId cartItemId;

//    @ManyToOne
//    @MapsId("cartId")
//    @JoinColumn(name="cart_id")
    Cart cart;

//    @ManyToOne
//    @MapsId("itemId")
//    @JoinColumn(name="item_id")
    Item item;

//    @Column
    int quantity;

}
