package is.labs.op.cart.api.dto;

import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Data
public class FrontEndCartDto {
    ArrayList<FullItemInCartDto> items;
    int id;
    String status;
    int userOwnerId;

    @Nullable
    String address;

    @Nullable
    Calendar notEarlierThan;

    @Nullable
    Calendar notLaterThan;
}
