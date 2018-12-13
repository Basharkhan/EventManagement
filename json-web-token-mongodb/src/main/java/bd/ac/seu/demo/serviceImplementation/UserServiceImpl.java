package bd.ac.seu.demo.serviceImplementation;

import bd.ac.seu.demo.model.FileModel;
import bd.ac.seu.demo.model.Role;
import bd.ac.seu.demo.model.User;
import bd.ac.seu.demo.model.UserDto;
import bd.ac.seu.demo.repo.FileRepository;
import bd.ac.seu.demo.repo.UserRepository;
import bd.ac.seu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService{
    @Autowired
    FileRepository fileRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    JavaMailSender javaMailSender;

    @Autowired
    public UserServiceImpl(JavaMailSender mailSender) {
        this.javaMailSender = mailSender;
    }

    public void sendMail(User user) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("basharkhan71@gmail.com");
        helper.setTo(user.getEmail());
        helper.setSubject("Event Management");
        helper.setText("Here is your attachment.");

        FileSystemResource file = new FileSystemResource("D:\\ticket.pdf");
        helper.addAttachment(file.getFilename(), file);

        javaMailSender.send(mimeMessage);
    }


    @Override
    public void createUser(UserDto user) {
        User newUser = new User();
        newUser.setUserName(user.getUserName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = new Role("USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        newUser.setRoles(roleSet);
        userRepository.save(newUser);
    }

    @Override
    public void createAdmin(UserDto user) {
        User newUser = new User();
        newUser.setUserName(user.getUserName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = new Role("ADMIN");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        newUser.setRoles(roleSet);
        userRepository.save(newUser);
    }

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findOne(String username) {
        return userRepository.findUserByUserName(username);
    }

    @Override
    public User findById(String id) {
        return userRepository.findUserById(id);
    }

    @Override
    public String uploadMultipartFile(MultipartFile file) {
        try {
            FileModel model = new FileModel(file.getOriginalFilename(), file.getContentType(), file.getBytes());
            fileRepository.save(model);
            return "File Uploaded Successfully. File Name " + file.getName();
        } catch (Exception e) {
            return "FAILED! Maybe You had uploaded the file before or the file's size > 500KB";
        }
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findUserByUserName(userName);
        if(user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            //authorities.add(new SimpleGrantedAuthority(role.getName()));
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
        });
        return authorities;
        //return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

}
