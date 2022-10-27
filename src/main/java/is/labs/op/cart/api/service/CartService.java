package is.labs.op.cart.api.service;

import is.labs.op.cart.api.dto.FrontEndCartDto;
import is.labs.op.cart.api.request.CartConfirmRequest;
import is.labs.op.cart.api.request.CartUpdateRequest;

public interface CartService {
    FrontEndCartDto createCart();
    FrontEndCartDto updateCart(CartUpdateRequest cartUpdateRequest, int cartId);
    FrontEndCartDto getCart(int cartId);
    FrontEndCartDto deleteCart(int cartId);

    FrontEndCartDto confirmCart(CartConfirmRequest cartConfirmRequest, int cartId);
}
