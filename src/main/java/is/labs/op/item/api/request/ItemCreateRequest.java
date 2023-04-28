package is.labs.op.item.api.request;

import lombok.Data;

@Data
public class ItemCreateRequest {

    String itemName;
    float price;
    int quantityAvailable;

    public String getItemName() {
        return itemName;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }
}
