package bd.ac.seu.eventmanagementbackend.repository;

import bd.ac.seu.eventmanagementbackend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findUsersByUserName(String name);
    User findUserByUserNameAndEmail(String name, String email);
    User findUserByUserNameAndPassword(String name, String password);
    User findUserByUserNameOrEmail(String name, String email);
}
