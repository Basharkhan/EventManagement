package bd.ac.seu.demo.repo;

import bd.ac.seu.demo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    void deleteById(String id);
    User findUserByUserName(String name);
    User findUserById(String id);
    User findUserByUserNameOrEmail(String userName, String email);
    User findUserByEmail(String email);
}
