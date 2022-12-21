package is.labs.op.cart.api.request;

import lombok.Data;

import java.util.UUID;

@Data
public class CartCreateRequest {
    UUID userOwnerId;
}
