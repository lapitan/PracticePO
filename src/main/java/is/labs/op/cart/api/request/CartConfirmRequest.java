package is.labs.op.cart.api.request;

import lombok.Data;

import java.util.Calendar;

@Data
public class CartConfirmRequest {
    String address;

    String notEarlierThan;

    String notLaterThan;
}
