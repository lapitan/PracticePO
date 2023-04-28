package is.labs.op.cart.api.dto;

import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Data
public class FrontEndCartDto {
    ArrayList<FullItemInCartDto> items;
    UUID id;
    String status;
    UUID userOwnerId;

    @Nullable
    String address;

    @Nullable
    Calendar notEarlierThan;

    @Nullable
    Calendar notLaterThan;

    @Nullable
    public String getAddress() {
        return address;
    }

    @Nullable
    public Calendar getNotEarlierThan() {
        return notEarlierThan;
    }

    @Nullable
    public Calendar getNotLaterThan() {
        return notLaterThan;
    }
}
