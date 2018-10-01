package bd.ac.seu.eventmanagementbackend.controller;

import bd.ac.seu.eventmanagementbackend.model.GeneralEvent;
import bd.ac.seu.eventmanagementbackend.model.SpecialEvent;
import bd.ac.seu.eventmanagementbackend.model.User;
import bd.ac.seu.eventmanagementbackend.repository.GeneralEventRepo;
import bd.ac.seu.eventmanagementbackend.repository.SpecialEventRepo;
import bd.ac.seu.eventmanagementbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(value = "http://localhost:4200", allowedHeaders = "*")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    GeneralEventRepo generalEventRepo;
    @Autowired
    SpecialEventRepo specialEventRepo;

    @GetMapping("/users")
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @GetMapping("/generalevents")
    public List<GeneralEvent> getGeneralEvents(){
        return generalEventRepo.findAll();
    }

    @GetMapping("/specialevents")
    public List<SpecialEvent> getSpecialEvents(){
        return specialEventRepo.findAll();
    }


    @PostMapping("/register")
    public String register(@RequestBody User user){
        User newUser = userRepository.findUserByUserNameOrEmail(user.getUserName(), user.getEmail());
        if(newUser == null) {
            userRepository.save(user);
            return "OK";
        }
        else {
            System.out.println("User name already exist");
            return "User already exist";
        }
    }

    @GetMapping("/login/{username}/{password}")
    public User login(@PathVariable String username, @PathVariable String password){
        System.out.println("Login was called");
        return userRepository.findUserByUserNameAndPassword(username, password);
    }


/*
    @PostMapping("/login")
    public User login(@RequestBody User user){
        User loginUser = userRepository.findUsersByUserName(user.getUserName());
        if(loginUser == null) {
            System.out.println("Invalid Username");
            return null;
        }
        else if(loginUser.getPassword().equals(user.getPassword())) {
            System.out.println("Valid user");
            return user;
        }
        else{
            System.out.println("Invalid password");
            return null;
        }

    }
*/

}
