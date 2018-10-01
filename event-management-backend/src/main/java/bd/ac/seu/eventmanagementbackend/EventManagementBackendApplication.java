package bd.ac.seu.eventmanagementbackend;

import bd.ac.seu.eventmanagementbackend.model.GeneralEvent;
import bd.ac.seu.eventmanagementbackend.model.SpecialEvent;
import bd.ac.seu.eventmanagementbackend.model.User;
import bd.ac.seu.eventmanagementbackend.repository.GeneralEventRepo;
import bd.ac.seu.eventmanagementbackend.repository.SpecialEventRepo;
import bd.ac.seu.eventmanagementbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EventManagementBackendApplication {

	@Autowired
	UserRepository userRepository;
	@Autowired
	GeneralEventRepo generalEventRepo;
	@Autowired
	SpecialEventRepo specialEventRepo;

	public static void main(String[] args) {
		SpringApplication.run(EventManagementBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
//			generalEventRepo.save(new GeneralEvent("picnic1", "near dhaka", "1-1-1"));
//			generalEventRepo.save(new GeneralEvent("picnic2", "near dhaka", "2-3-1"));
//			generalEventRepo.save(new GeneralEvent("picnic3", "near dhaka", "3-3-1"));
//			generalEventRepo.save(new GeneralEvent("picnic4", "near gazipur", "4-4-1"));
//
//			specialEventRepo.save(new SpecialEvent("picnic10", "near dhaka", "1-1-1"));
//			specialEventRepo.save(new SpecialEvent("picnic11", "near dhaka", "1-1-1"));
//			specialEventRepo.save(new SpecialEvent("picnic12", "near dhaka", "1-1-1"));
//			specialEventRepo.save(new SpecialEvent("picnic13", "near dhaka", "1-1-1"));

//			userRepository.save(new User("a@a.com", "1234"));
//			userRepository.save(new User("b@b.com", "5678"));
		};
	}
}
