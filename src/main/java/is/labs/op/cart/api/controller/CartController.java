package is.labs.op.cart.api.controller;

import is.labs.op.cart.api.dto.FrontEndCartDto;
import is.labs.op.cart.api.events.CartConfirmEvent;
import is.labs.op.cart.api.events.CartCreateEvent;
import is.labs.op.cart.api.events.CartDeleteEvent;
import is.labs.op.cart.api.events.CartUpdateEvent;
import is.labs.op.cart.api.request.CartConfirmRequest;
import is.labs.op.cart.api.request.CartCreateRequest;
import is.labs.op.cart.api.request.CartUpdateRequest;
import is.labs.op.cart.api.response.CartResponse;
import is.labs.op.cart.api.service.impl.CartServiceImplKotlin;
import is.labs.op.item.api.aggregate.ItemAggregateState;
import is.labs.op.item.api.events.ItemDeleteEvent;
import is.labs.op.item.api.request.ItemRequest;
import is.labs.op.item.api.service.impl.ItemServiceImplKotlin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "api/cart")
public class CartController {

    private final CartServiceImplKotlin cartService;
    private final ItemServiceImplKotlin itemServiceImplKotlin;

    public CartController(CartServiceImplKotlin cartService, ItemServiceImplKotlin itemServiceImplKotlin) {
        this.cartService = cartService;
        this.itemServiceImplKotlin = itemServiceImplKotlin;
    }

    @PostMapping
    public CartCreateEvent createCart(CartCreateRequest cartCreateRequest) {
        log.info("CartController: got create cart request");
        CartCreateEvent cartCreateEvent = cartService.createCart(cartCreateRequest);
        log.info("CartController: finish create cart request");
        return cartCreateEvent;
    }

    @PutMapping(value = "/{cartId}")
    public CartUpdateEvent updateCart(@RequestBody CartUpdateRequest cartUpdateRequest, String cartId) {
        log.info("CartController: got update cart request");
        cartUpdateRequest.getItems()
                .forEach(itemInCartDto -> {
                    ItemAggregateState itemAggregateState = itemServiceImplKotlin.getItem(UUID.fromString(itemInCartDto.getId()));
                    assert itemAggregateState != null;
                    if (itemAggregateState.getQuantityAvailable() < itemInCartDto.getQuantity()) {
                        log.error("CartController: updateCart: Not enough items");
                        throw new RuntimeException("Not enough items of" + itemInCartDto.getId());
                    }
                });
        log.info("CartController: updateCart: all items enough");
        cartUpdateRequest.getItems().forEach(itemInCartDto -> {
            ItemAggregateState itemAggregateState = itemServiceImplKotlin.getItem(UUID.fromString(itemInCartDto.getId()));

            ItemRequest itemRequest = new ItemRequest();
            assert itemAggregateState != null;
            itemRequest.setName(itemAggregateState.getName());
            itemRequest.setPrice(itemAggregateState.getPrice());
            itemRequest.setQuantity(itemAggregateState.getQuantityAvailable() - itemInCartDto.getQuantity());
            itemServiceImplKotlin.updateItem(itemRequest, UUID.fromString(itemInCartDto.getId()));
        });
        log.info("CartController: updateCart: all items quantity changed");
        CartUpdateEvent cartUpdateEvent = cartService.updateCart(cartUpdateRequest, UUID.fromString(cartId));
        log.info("CartController: finish update cart request");
        return cartUpdateEvent;

    }

    @PostMapping(value = "/confirm")
    public CartConfirmEvent confirmCart(@RequestBody CartConfirmRequest cartConfirmRequest, String cartId) {

        log.info("CartController: got confirm cart request");
        FrontEndCartDto frontEndCartDto = new FrontEndCartDto();

        frontEndCartDto.setAddress(cartConfirmRequest.getAddress());

        Calendar notEarlierThen = Calendar.getInstance();
        Calendar notLaterThen = Calendar.getInstance();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            notEarlierThen.setTime(dateFormat.parse(cartConfirmRequest.getNotEarlierThan()));
            notLaterThen.setTime(dateFormat.parse(cartConfirmRequest.getNotLaterThan()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        frontEndCartDto.setNotEarlierThan(notEarlierThen);
        frontEndCartDto.setNotLaterThan(notLaterThen);

        CartConfirmEvent cartConfirmEvent = cartService.confirmCart(frontEndCartDto, UUID.fromString(cartId));
        log.info("CartController: finish confirm cart request");
        return cartConfirmEvent;
    }

    @GetMapping(value = "/")
    public CartResponse getCart(String cartId) {
        log.info("CartController: got get cart request");
        CartResponse cartResponse = new CartResponse(Objects.requireNonNull(cartService.getCart(UUID.fromString(cartId))));
        log.info("CartController: finish get cart request");
        return cartResponse;
    }

    @DeleteMapping
    public CartDeleteEvent deleteCart(String cartId) {
        log.info("CartController: got delete cart request");
        CartDeleteEvent cartDeleteEvent = cartService.deleteCart(UUID.fromString(cartId));
        log.info("CartController: finish get cart request");
        return cartDeleteEvent;
    }

}
