package bd.ac.seu.demo.repo;

import bd.ac.seu.demo.model.SpecialEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpecialEventRepository extends MongoRepository<SpecialEvent, String> {

}
