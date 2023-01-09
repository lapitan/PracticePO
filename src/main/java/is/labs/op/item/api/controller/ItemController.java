package is.labs.op.item.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import is.labs.op.item.api.dto.FrontendItemDto;
import is.labs.op.item.api.request.ItemRequest;
import is.labs.op.item.api.response.ItemsResponse;
import is.labs.op.item.api.service.ItemService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public FrontendItemDto addItem(@RequestBody ItemRequest itemRequest){
        return itemService.addItem(itemRequest);
    }

    @PutMapping(value = "/{itemId}")
    public FrontendItemDto updateItem(@RequestBody ItemRequest itemRequest, @PathVariable int itemId){
        return itemService.updateItem(itemRequest,itemId);
    }

    @GetMapping
    public ItemsResponse getAllItems(){
        return itemService.getAllItems();
    }

    @DeleteMapping(value = "/{itemId}")
    public FrontendItemDto deleteItem(@PathVariable int itemId){
        return itemService.deleteItem(itemId);
    }

}
