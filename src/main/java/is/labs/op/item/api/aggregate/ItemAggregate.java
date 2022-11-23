package is.labs.op.item.api.aggregate;

import is.labs.op.cart.api.model.CartItem;
import ru.quipy.core.annotations.AggregateType;
import ru.quipy.domain.Aggregate;

import javax.persistence.*;
import java.util.Set;

@AggregateType(aggregateEventsTableName = "ItemAggregate")
public class ItemAggregate implements Aggregate{

}
