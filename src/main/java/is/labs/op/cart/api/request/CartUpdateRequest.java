package is.labs.op.cart.api.request;

import is.labs.op.cart.api.dto.ItemInCartDto;
import lombok.Data;

import java.util.ArrayList;

@Data
public class CartUpdateRequest {
    ArrayList<ItemInCartDto> items;
}
