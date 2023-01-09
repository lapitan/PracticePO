package is.labs.op.item.impl.service;

import is.labs.op.item.api.dto.FrontendItemDto;
import is.labs.op.item.api.request.ItemRequest;
import is.labs.op.item.api.response.ItemsResponse;
import is.labs.op.item.api.service.ItemService;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    @Override
    public FrontendItemDto addItem(ItemRequest itemRequest) {
        return null;
    }

    @Override
    public FrontendItemDto updateItem(ItemRequest itemRequest, int id) {
        return null;
    }

    @Override
    public ItemsResponse getAllItems() {
        return null;
    }

    @Override
    public FrontendItemDto deleteItem(int itemId) {
        return null;
    }
}
