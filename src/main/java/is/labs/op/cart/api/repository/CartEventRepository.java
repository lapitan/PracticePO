package is.labs.op.cart.api.repository;

import is.labs.op.cart.api.model.CartEventEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CartEventRepository extends CrudRepository<CartEventEntity, UUID> {
}
