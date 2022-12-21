package is.labs.op.item.api.model;

import is.labs.op.cart.api.model.CartItem;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    String name;

    @Column
    float price;

    @Column
    int quantityAvailable;

    @OneToMany(mappedBy = "item")
    Set<CartItem> carts;
}
