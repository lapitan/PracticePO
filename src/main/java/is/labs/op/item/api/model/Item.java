package is.labs.op.item.api.model;

import is.labs.op.cart.api.model.CartItem;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.*;
import java.util.Set;

@Data
//@Entity
@Document("Item")
public class Item {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

//    @Column
    String name;

//    @Column
    float price;

//    @Column
    int quantityAvailable;

//    @OneToMany(mappedBy = "item")
    Set<CartItem> carts;
}
