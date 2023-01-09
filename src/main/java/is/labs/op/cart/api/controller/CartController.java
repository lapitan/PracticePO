package is.labs.op.cart.api.controller;

import is.labs.op.cart.api.dto.FrontEndCartDto;
import is.labs.op.cart.api.request.CartConfirmRequest;
import is.labs.op.cart.api.request.CartCreateRequest;
import is.labs.op.cart.api.request.CartUpdateRequest;
import is.labs.op.cart.api.service.CartService;
import is.labs.op.item.api.dto.FrontendItemDto;
import is.labs.op.item.api.request.ItemRequest;
import is.labs.op.item.api.response.ItemsResponse;
import is.labs.op.item.api.service.ItemService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public FrontEndCartDto createCart(CartCreateRequest cartCreateRequest){
        return cartService.createCart(cartCreateRequest);
    }

    @PutMapping(value = "/{cartId}")
    public FrontEndCartDto updateCart(@RequestBody CartUpdateRequest cartUpdateRequest, @PathVariable int cartId){
        return cartService.updateCart(cartUpdateRequest,cartId);
    }

    @PostMapping(value = "/{cartId}/confirm")
    public FrontEndCartDto confirmCart(@RequestBody CartConfirmRequest cartConfirmRequest, @PathVariable int cartId){
        return cartService.confirmCart(cartConfirmRequest,cartId);
    }

    @GetMapping(value = "/{cartId}")
    public FrontEndCartDto getCart(@PathVariable int cartId){
        return cartService.getCart(cartId);
    }

    @DeleteMapping(value = "/{cartId}")
    public FrontEndCartDto deleteCart(@PathVariable int cartId){
        return cartService.deleteCart(cartId);
    }



}
