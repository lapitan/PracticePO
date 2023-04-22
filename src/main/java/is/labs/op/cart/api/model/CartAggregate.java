package is.labs.op.cart.api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.*;
import java.util.UUID;

@Data
//@Entity
@Document("cartAggregate")
public class CartAggregate {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    UUID id;

//    @Column
    UUID object_id;

//    @Column
    UUID event_type;
}
