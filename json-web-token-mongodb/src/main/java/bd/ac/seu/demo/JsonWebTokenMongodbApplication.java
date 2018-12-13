package bd.ac.seu.demo;

import bd.ac.seu.demo.model.GeneralEvent;
import bd.ac.seu.demo.model.SpecialEvent;
import bd.ac.seu.demo.model.User;
import bd.ac.seu.demo.model.UserDto;
import bd.ac.seu.demo.repo.GeneralEventRepository;
import bd.ac.seu.demo.repo.SpecialEventRepository;
import bd.ac.seu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class JsonWebTokenMongodbApplication {

	@Autowired
	GeneralEventRepository generalEventRepository;
	@Autowired
	SpecialEventRepository specialEventRepository;
	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(JsonWebTokenMongodbApplication.class, args);
	}

	@Bean
	CommandLineRunner runner () {
		return args -> {

//			generalEventRepository.save(new GeneralEvent("picnic1", "near dhaka", "1-1-1"));
//			generalEventRepository.save(new GeneralEvent("picnic2", "near dhaka", "2-3-1"));
//			generalEventRepository.save(new GeneralEvent("picnic3", "near dhaka", "3-3-1"));
//			generalEventRepository.save(new GeneralEvent("picnic4", "near gazipur", "4-4-1"));
//			generalEventRepository.save(new GeneralEvent("picnic5", "near gazipur", "4-4-1"));
//			generalEventRepository.save(new GeneralEvent("picnic6", "near gazipur", "4-4-1"));
//			generalEventRepository.save(new GeneralEvent("picnic7", "near gazipur", "4-4-1"));
//			generalEventRepository.save(new GeneralEvent("picnic8", "near gazipur", "4-4-1"));
//			generalEventRepository.save(new GeneralEvent("picnic9", "near gazipur", "4-4-1"));
//
//			specialEventRepository.save(new SpecialEvent("picnic10", "near dhaka", "1-1-1"));
//			specialEventRepository.save(new SpecialEvent("picnic11", "near dhaka", "1-1-1"));
//			specialEventRepository.save(new SpecialEvent("picnic12", "near dhaka", "1-1-1"));
//			specialEventRepository.save(new SpecialEvent("picnic13", "near dhaka", "1-1-1"));
//			specialEventRepository.save(new SpecialEvent("picnic14", "near dhaka", "1-1-1"));
//			specialEventRepository.save(new SpecialEvent("picnic15", "near dhaka", "1-1-1"));
//			specialEventRepository.save(new SpecialEvent("picnic16", "near dhaka", "1-1-1"));
//			specialEventRepository.save(new SpecialEvent("picnic17", "near dhaka", "1-1-1"));
//			specialEventRepository.save(new SpecialEvent("picnic18", "near dhaka", "1-1-1"));
//			generalEventRepository.save(new GeneralEvent("EEE FEAST", "Hello CSE", "10-10-2019", "https://drive.google.com/file/d/1QAkv-1OJWEXnQwq-9n-W1O8KRmg7mGtO/view?usp=sharing"));
//			generalEventRepository.save(new GeneralEvent("BBA FEAST", "Hello CSE", "10-10-2019", "https://farm5.staticflickr.com/4814/43983798100_00c9e801d5_b.jpg"));
//			generalEventRepository.save(new GeneralEvent("CSE FEST", "Description\n" +
//					"We cordially invite you to share and exhibit your finest work with photographers from all over the World. ” Intro To The Power Of Imaging - Season 1” does not only showcase the selected photos but it also provides a platform for both professional and amateur photographers, irrespective of age or background, from all over the world to come together and share their experiences and knowledge.\n" +
//					"\n" +
//					"*Exhibition is open for all\n" +
//					"\n" +
//					"\n" +
//					"*Event Date-\n" +
//					"24th – 26th January 2019\n" +
//					"Venue: Bangladesh Shilpakala Academy\n" +
//					"\n" +
//					"\n" +
//					"*All participants will get \n" +
//					"T-Shirt\n" +
//					"Certificate\n" +
//					"Frame\n" +
//					"Crest/Medal ", "10-10-2019", "https://farm5.staticflickr.com/4872/32079645268_f66978ef71_b.jpg"));
		};
	}
}


/*

<a data-flickr-embed="true"  href="https://www.flickr.com/photos/167957004@N04/32079645268/in/dateposted-public/" title="Lightning storm"><img src="https://farm5.staticflickr.com/4872/32079645268_f66978ef71_b.jpg" width="1024" height="320" alt="Lightning storm"></a><script async src="//embedr.flickr.com/assets/client-code.js" charset="utf-8"></script>
 */

//google api key
//AIezSyCZve32h9k5o5WIVwLUO5eGMocSIdEsE0qE