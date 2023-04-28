package is.labs.op.item.api.controller;

import is.labs.op.item.api.aggregate.ItemAggregateState;
import is.labs.op.item.api.dto.FrontendItemDto;
import is.labs.op.item.api.events.ItemCreateEvent;
import is.labs.op.item.api.events.ItemDeleteEvent;
import is.labs.op.item.api.events.ItemUpdateEvent;
import is.labs.op.item.api.request.ItemCreateRequest;
import is.labs.op.item.api.request.ItemRequest;
import is.labs.op.item.api.service.impl.ItemServiceImplKotlin;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/items")
public class ItemController {

    private final ItemServiceImplKotlin itemService;

    public ItemController(ItemServiceImplKotlin itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ItemCreateEvent addItem(@RequestBody ItemCreateRequest itemRequest){
        return itemService.addItem(itemRequest);
    }

    @PutMapping
    public ItemUpdateEvent updateItem(@RequestBody ItemRequest itemRequest, String itemId){
        return itemService.updateItem(itemRequest,UUID.fromString(itemId));
    }

    @GetMapping
    public FrontendItemDto getItem(String itemId){
        ItemAggregateState itemAggregateState=Objects.requireNonNull(itemService.getItem(UUID.fromString(itemId)));
        if (itemAggregateState.getStatus().equals("Deleted")) throw new RuntimeException("Item is deleted. Can't get Item");
        return new FrontendItemDto(itemAggregateState);
    }

    @DeleteMapping
    public ItemDeleteEvent deleteItem(String itemId){
        return itemService.deleteItem(UUID.fromString(itemId));
    }

}
