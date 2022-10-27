package is.labs.op.item.api.service;

import is.labs.op.item.api.dto.FrontendItemDto;
import is.labs.op.item.api.request.ItemRequest;
import is.labs.op.item.api.response.ItemsResponse;

public interface ItemService {

    FrontendItemDto addItem(ItemRequest itemRequest);
    FrontendItemDto updateItem(ItemRequest itemRequest, int id);
    ItemsResponse getAllItems();
    FrontendItemDto deleteItem(int itemId);

}
