package bd.ac.seu.eventmanagementbackend.repository;

import bd.ac.seu.eventmanagementbackend.model.SpecialEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpecialEventRepo extends MongoRepository<SpecialEvent, String> {
}
