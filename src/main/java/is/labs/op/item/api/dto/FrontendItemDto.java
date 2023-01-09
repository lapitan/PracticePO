package is.labs.op.item.api.dto;

import lombok.Data;

@Data
public class FrontendItemDto {
    int id;
    String name;
    float price;
    int quantityAvailable;
}
