package is.labs.op.cart.impl.service;

import is.labs.op.cart.api.aggregate.CartAggregateState;
import is.labs.op.cart.api.dto.FrontEndCartDto;
import is.labs.op.cart.api.request.CartConfirmRequest;
import is.labs.op.cart.api.request.CartCreateRequest;
import is.labs.op.cart.api.request.CartUpdateRequest;
import is.labs.op.cart.api.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Override
    public FrontEndCartDto createCart(CartCreateRequest cartCreateRequest) {
        CartAggregateState cartAggregateState= new CartAggregateState();
        cartAggregateState.createCartCommand(cartCreateRequest.getUserOwnerId());
        return null;
    }

    @Override
    public FrontEndCartDto updateCart(CartUpdateRequest cartUpdateRequest, int cartId) {
        return null;
    }

    @Override
    public FrontEndCartDto getCart(int cartId) {
        return null;
    }

    @Override
    public FrontEndCartDto deleteCart(int cartId) {
        return null;
    }

    @Override
    public FrontEndCartDto confirmCart(CartConfirmRequest cartConfirmRequest, int cartId) {
        return null;
    }
}
