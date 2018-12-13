package bd.ac.seu.demo.controller;

import bd.ac.seu.demo.model.*;
import bd.ac.seu.demo.repo.FileRepository;
import bd.ac.seu.demo.repo.GeneralEventRepository;
import bd.ac.seu.demo.repo.SpecialEventRepository;
import bd.ac.seu.demo.repo.UserRepository;
import bd.ac.seu.demo.service.UserService;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.xml.ws.Response;
import java.io.*;
import java.util.List;

@CrossOrigin(value = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    GridFsOperations gridFsOperations;

    @Autowired
    FileRepository fileRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SpecialEventRepository specialEventRepository;

    @Autowired
    GeneralEventRepository generalEventRepository;

    @Autowired
    UserService userService;

    @Autowired
    JavaMailSender javaMailSender;

/*
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/user")
    public List<User> getAllUser(){
        return userService.findAll();
    }
*/

    @GetMapping("/hello")
    public String hello(){
        System.out.println("I was called");
        return "Hello";
    }

//    @PreAuthorize("hasRole('ADMNIN')")
    @GetMapping("/admin")
    public List<User> helloAdmin() {
        return userRepository.findAll();
    }


    @PostMapping("/add-special-event")
    public ResponseEntity<String> saveEvent(@RequestBody SpecialEvent specialEvent) {
        SpecialEvent event = new SpecialEvent();

        specialEventRepository.save(specialEvent);
        return ResponseEntity.status(HttpStatus.OK).body("Event Saved");
    }

    @GetMapping("/send-mail/{userId}/{eventId}")
    public String sendMail(@PathVariable String userId, @PathVariable String eventId) throws MessagingException, IOException {
        User user = userRepository.findUserById(userId);
        GeneralEvent generalEvent = generalEventRepository.findGeneralEventById(eventId);

        String dest = "D:/Pdf/";

        String fileName = user.getUserName() + "-" + generalEvent.getId() + ".pdf";
        PdfWriter pdfWriter = new PdfWriter(new FileOutputStream(dest + fileName));

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        String heading = generalEvent.getName();
        String description = generalEvent.getDescription();

        Paragraph paragraph1 = new Paragraph(heading);
        Paragraph paragraph2 = new Paragraph(description);

        Document document = new Document(pdfDocument);

        document.add(paragraph1);
        document.add(paragraph2);

        document.close();

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("basharkhan71@gmail.com");
        helper.setTo(user.getEmail());
        helper.setSubject("Event Management");
        helper.setText("Here is your attachment");

        FileSystemResource fileSystemResource = new FileSystemResource(dest + fileName);

        //save file
        DBObject dbObject = new BasicDBObject();
        dbObject.put("Orgazitaion", "SEU");

        InputStream inputStream = new FileInputStream(dest + fileName);
        gridFsOperations.store(inputStream, fileName, "pdf", dbObject);


        helper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
        javaMailSender.send(mimeMessage);

        return "Message Sent";
    }

    @GetMapping("/retrieve-file")
    public String retrieveFile() {

        List<GridFSDBFile> files = gridFsOperations.find(new Query(Criteria.where("metadata.type").is("data")));

        files.forEach(file -> {
            String fileName = file.getFilename();
                System.out.println("File Name: " + fileName);
        });

        return "File Retrieved";
    }


    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDto userDto){
        User user = userRepository.findUserByUserName(userDto.getUserName());
        if(user == null) {
            userService.createUser(userDto);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(user, HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/admin-signup")
    public ResponseEntity<?> createAdmin(@RequestBody UserDto userDto){
        User user = userRepository.findUserByUserName(userDto.getUserName());
        if(user == null){
            userService.createAdmin(userDto);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } else {
            System.out.println("Admin already exists");
            return new ResponseEntity<>(user, HttpStatus.CONFLICT);
        }
    }



//    @PreAuthorize("hasRole('USER')")
    @GetMapping("/specialevents")
    public List<SpecialEvent> getSpecialEvents(){
        return specialEventRepository.findAll();
    }

    @GetMapping("/generalevents")
    public List<GeneralEvent> getGeneralEvents(){
        return generalEventRepository.findAll();
    }

    @GetMapping("generalevents/{id}")
    public GeneralEvent getEventById(@PathVariable String id) {
        return generalEventRepository.findGeneralEventById(id);
    }

//------------------------------------------------------------
/*
    @PostMapping("/login")
    public User login(@RequestBody User user){
        User loginUser = userRepository.findUserByUserName(user.getUserName());
        if(loginUser == null) {
            System.out.println("Invalid User Name");
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
