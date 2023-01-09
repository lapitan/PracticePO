package is.labs.op.item.api.response;

import is.labs.op.item.api.dto.FrontendItemDto;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ItemsResponse {
    ArrayList<FrontendItemDto> frontendItemDtoArrayList;
}
