package is.labs.op.cart.api.model;

import io.swagger.v3.core.util.Json;
import io.swagger.v3.core.util.Json31;
import lombok.Data;
import org.springframework.data.annotation.Id;

//import javax.persistence.*;
import java.util.UUID;

@Data
//@Entity
public class CartEventEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    UUID id;

//    @Column (nullable = false)
    UUID cartId;

//    @Column (nullable = false)
    String eventType;

//    @Column
    String data;
}
