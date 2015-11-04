package demo.repos;

import demo.model.Whiskey;
import org.springframework.data.repository.CrudRepository;

public interface WhiskeyRepo extends CrudRepository<Whiskey, String> {
}
