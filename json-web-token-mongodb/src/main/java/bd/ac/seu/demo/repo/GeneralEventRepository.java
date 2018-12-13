package bd.ac.seu.demo.repo;

import bd.ac.seu.demo.model.GeneralEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GeneralEventRepository extends MongoRepository<GeneralEvent, String>{
    GeneralEvent findGeneralEventById(String id);
}
