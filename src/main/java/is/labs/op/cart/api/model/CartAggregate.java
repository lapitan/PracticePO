package is.labs.op.cart.api.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
public class CartAggregate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    UUID id;

    @Column
    UUID object_id;

    @Column
    UUID event_type;
}
