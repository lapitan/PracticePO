package is.labs.op.cart.api.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CartItemId implements Serializable {

    @Column
    int cartId;

    @Column
    int itemId;

}
