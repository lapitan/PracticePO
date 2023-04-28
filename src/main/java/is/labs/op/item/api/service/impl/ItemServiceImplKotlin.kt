package `is`.labs.op.item.api.service.impl

import `is`.labs.op.item.api.aggregate.ItemAggregate
import `is`.labs.op.item.api.aggregate.ItemAggregateState
import `is`.labs.op.item.api.dto.FrontendItemDto
import `is`.labs.op.item.api.events.ItemCreateEvent
import `is`.labs.op.item.api.events.ItemDeleteEvent
import `is`.labs.op.item.api.events.ItemUpdateEvent
import `is`.labs.op.item.api.request.ItemCreateRequest
import `is`.labs.op.item.api.request.ItemRequest
import `is`.labs.op.item.api.response.ItemsResponse
import `is`.labs.op.item.api.service.ItemService
import org.springframework.stereotype.Service
import ru.quipy.core.EventSourcingService
import java.util.UUID

@Service
class ItemServiceImplKotlin (private val eventSourcingService: EventSourcingService<UUID, ItemAggregate, ItemAggregateState>) {



    fun addItem(itemRequest: ItemCreateRequest?): ItemCreateEvent? {
        if (itemRequest != null) {
            return eventSourcingService.create { it.createItemCommand(itemRequest.itemName, itemRequest.price, itemRequest.quantityAvailable) }
        }
        return null;
    }

    fun updateItem(itemRequest: ItemRequest?, itemId: UUID): ItemUpdateEvent? {
        if (itemRequest != null) {
            return eventSourcingService.update(itemId){it.updateItemCommand(itemRequest.price, itemRequest.quantity, itemId)}
        }
        return null;
    }

    fun getItem(itemId: UUID): ItemAggregateState? {
        return eventSourcingService.getState(itemId)
    }

    fun deleteItem(itemId: UUID): ItemDeleteEvent? {
        return eventSourcingService.update(itemId){it.deleteItemCommand()}
    }
}