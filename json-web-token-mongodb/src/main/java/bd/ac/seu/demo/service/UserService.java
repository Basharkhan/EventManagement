package bd.ac.seu.demo.service;

import bd.ac.seu.demo.model.User;
import bd.ac.seu.demo.model.UserDto;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import javax.mail.MessagingException;
import java.util.List;

public interface UserService {
    void createUser(UserDto user);
    void createAdmin(UserDto user);
    void sendMail(User user) throws MessagingException;
    List<User> findAll();
    void delete(String id);
    User findOne(String username);
    User findById(String id);
    String uploadMultipartFile(MultipartFile file);

}
