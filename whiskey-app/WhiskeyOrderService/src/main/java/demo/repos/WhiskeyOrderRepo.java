package demo.repos;

import demo.model.WhiskeyOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WhiskeyOrderRepo extends CrudRepository<WhiskeyOrder, String> {
    List<WhiskeyOrder> findByWhiskeyUUID(String uuid);
}
