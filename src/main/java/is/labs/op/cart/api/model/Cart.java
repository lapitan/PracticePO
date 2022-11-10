package is.labs.op.cart.api.model;


import is.labs.op.user.api.model.Customer;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    String status;

    @Column
    String address;

    @Column
    Calendar notEarlierThan;

    @Column
    Calendar notLaterThan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    Customer customer;

    @OneToMany(mappedBy = "cart")
    Set<CartItem> items;

}
