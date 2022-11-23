package is.labs.op.cart.api.dto;

import is.labs.op.item.api.dto.FrontendItemDto;
import lombok.Data;

@Data
public class FullItemInCartDto {
    FrontendItemDto itemDto;
    int quantity;
}
