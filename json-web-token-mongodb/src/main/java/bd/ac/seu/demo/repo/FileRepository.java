package bd.ac.seu.demo.repo;

import bd.ac.seu.demo.model.FileModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileRepository extends MongoRepository<FileModel, String> {

}
