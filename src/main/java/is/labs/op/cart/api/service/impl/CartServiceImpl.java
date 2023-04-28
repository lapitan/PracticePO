//package is.labs.op.cart.api.service.impl;
//
//import is.labs.op.cart.api.aggregate.CartAggregate;
//import is.labs.op.cart.api.aggregate.CartAggregateState;
//import is.labs.op.cart.api.dto.FrontEndCartDto;
//import is.labs.op.cart.api.events.CartCreateEvent;
//import is.labs.op.cart.api.request.CartConfirmRequest;
//import is.labs.op.cart.api.request.CartCreateRequest;
//import is.labs.op.cart.api.request.CartUpdateRequest;
//import is.labs.op.cart.api.service.CartService;
//import org.springframework.stereotype.Service;
//import ru.quipy.core.EventSourcingService;
//import ru.quipy.core.EventSourcingServiceFactory;
//
//import java.util.UUID;
//import java.util.function.Consumer;
//import java.util.function.Function;
//
//@Service
//public class CartServiceImpl implements CartService {
//    EventSourcingService eventSourcingService;
//
//    public CartServiceImpl(EventSourcingService eventSourcingService) {
//        this.eventSourcingService = eventSourcingService;
//    }
//
//    @Override
//    public FrontEndCartDto createCart(CartCreateRequest cartCreateRequest) {
////        CartAggregateState cartAggregateState= new CartAggregateState();
////
////        Function<CartAggregateState, CartCreateEvent> function= cartAggregateState1 -> cartAggregateState1.createCartCommand(cartCreateRequest.getUserOwnerId());
////        eventSourcingService.create(function);
//
//        return null;
//    }
//
//    @Override
//    public FrontEndCartDto updateCart(CartUpdateRequest cartUpdateRequest, int cartId) {
//        return null;
//    }
//
//    @Override
//    public FrontEndCartDto getCart(int cartId) {
//        return null;
//    }
//
//    @Override
//    public FrontEndCartDto deleteCart(int cartId) {
//        return null;
//    }
//
//    @Override
//    public FrontEndCartDto confirmCart(CartConfirmRequest cartConfirmRequest, int cartId) {
//        return null;
//    }
//}
