package is.labs.op.item.api.request;

import lombok.Data;

@Data
public class ItemRequest {

    String name;
    float price;
    int quantity;

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
