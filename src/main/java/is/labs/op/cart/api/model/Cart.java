package is.labs.op.cart.api.model;


import is.labs.op.user.api.model.Customer;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;

@Data
//@Entity
@Document("cart")
public class Cart {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    //@Column
    String status;

   // @Column
    String address;

   // @Column
    Calendar notEarlierThan;

   // @Column
    Calendar notLaterThan;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "customer_id", nullable = false)
    Customer customer;

//    @OneToMany(mappedBy = "cart")
    Set<CartItem> items;

}
