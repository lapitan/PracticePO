package `is`.labs.op.cart.api.service.impl

import `is`.labs.op.cart.api.aggregate.CartAggregate
import `is`.labs.op.cart.api.aggregate.CartAggregateState
import `is`.labs.op.cart.api.dto.FrontEndCartDto
import `is`.labs.op.cart.api.events.CartConfirmEvent
import `is`.labs.op.cart.api.events.CartCreateEvent
import `is`.labs.op.cart.api.events.CartDeleteEvent
import `is`.labs.op.cart.api.events.CartUpdateEvent
import `is`.labs.op.cart.api.request.CartConfirmRequest
import `is`.labs.op.cart.api.request.CartCreateRequest
import `is`.labs.op.cart.api.request.CartUpdateRequest
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service
import ru.quipy.core.EventSourcingService
import java.util.Calendar
import java.util.UUID

@Service
class CartServiceImplKotlin (private val eventSourcingService: EventSourcingService<UUID, CartAggregate, CartAggregateState>){

    fun createCart(cartCreateRequest: CartCreateRequest?): CartCreateEvent? {
        if (cartCreateRequest != null) {
            eventSourcingService.create { it.createCartCommand(cartCreateRequest.userOwnerId)}
        };
        return null;
    }

    fun updateCart(cartUpdateRequest: CartUpdateRequest?, cartId: UUID): CartUpdateEvent? {
        if (cartUpdateRequest != null) {
            return eventSourcingService.update(cartId){it.updateCartCommand(cartUpdateRequest.items)}
        }
        return null;
    }

    fun getCart(cartId: UUID): CartAggregateState? {
        return eventSourcingService.getState(cartId);
    }

    fun confirmCart(frontEndCartDto: FrontEndCartDto, cartId: UUID): CartConfirmEvent? {
        return eventSourcingService.update(cartId){it.confirmCartCommand(cartId, frontEndCartDto.address, frontEndCartDto.notEarlierThan, frontEndCartDto.notLaterThan)}
    }

    fun deleteCart(cartId: UUID): CartDeleteEvent{
        return eventSourcingService.update(cartId){it.deleteCartCommand()}
    }
}