package is.labs.op.user.api.model;

import is.labs.op.cart.api.model.Cart;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    String login;

    @Column
    String email;

    @Column
    String phoneNumber;

    @OneToMany(mappedBy = "customer")
    List<Cart> carts;

}
