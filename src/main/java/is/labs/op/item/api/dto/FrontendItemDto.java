package is.labs.op.item.api.dto;

import is.labs.op.item.api.aggregate.ItemAggregateState;
import lombok.Data;

import java.util.UUID;

@Data
public class FrontendItemDto {
    UUID id;
    String name;
    float price;
    int quantityAvailable;

    public FrontendItemDto(ItemAggregateState itemAggregateState) {
        this.id = itemAggregateState.getId();
        this.name = itemAggregateState.getName();
        this.price = itemAggregateState.getPrice();
        this.quantityAvailable = itemAggregateState.getQuantityAvailable();
    }
}
