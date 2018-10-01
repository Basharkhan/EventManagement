package bd.ac.seu.eventmanagementbackend.repository;

import bd.ac.seu.eventmanagementbackend.model.GeneralEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GeneralEventRepo extends MongoRepository<GeneralEvent, String> {
}
