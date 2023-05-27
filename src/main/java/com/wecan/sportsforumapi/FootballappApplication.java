package com.wecan.sportsforumapi;

import com.wecan.sportsforumapi.entity.Entry;
import com.wecan.sportsforumapi.entity.Title;
import com.wecan.sportsforumapi.entity.User;
import com.wecan.sportsforumapi.repository.UserRepository;
import com.wecan.sportsforumapi.service.EntryService;
import com.wecan.sportsforumapi.service.TitleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FootballappApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballappApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(EntryService entryService, TitleService titleService, UserRepository userRepository){
		return runner ->{
			createInstrcutor(entryService,titleService,userRepository);
		};
	}

	private void createInstrcutor(EntryService entryService, TitleService titleService, UserRepository userRepository) {
		Title title = new Title("Diego Rossi");
		titleService.save(title);
		User adem = new User("adem","ademm.soydan@gmail.com","123");
		User ali = new User("ali","ali.koc@gmail.com","123");
		User jorge = new User("jorge","jorge.jesus@gmail.com","123");
		userRepository.save(adem);
		userRepository.save(ali);
		userRepository.save(jorge);
		Entry entry = new Entry("Düğünümde oynatmamHemen Satın Gitsin bu lavuğu",title,adem);
		Entry entry2 = new Entry("Aslında fena değil ya",title,ali);
		Entry entry3 = new Entry("Aşığım bu çocuğa",title,jorge);



		entryService.save(entry);
		entryService.save(entry2);
		entryService.save(entry3);
	}


}
