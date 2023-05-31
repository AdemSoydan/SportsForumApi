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
		Title title = new Title(-1, "Diego Rossi", null);
		title = titleService.saveTitle(title);
		User adem = new User(-1,"adem","ademm.soydan@gmail.com","123", null);
		User ali = new User(-1,"ali","ali.koc@gmail.com","123",null);
		User jorge = new User(-1,"jorge","jorge.jesus@gmail.com","123",null);
		adem = userRepository.save(adem);
		ali = userRepository.save(ali);
		jorge = userRepository.save(jorge);

		Entry entry = new Entry(-1,"Düğünümde oynatmamHemen Satın Gitsin bu lavuğu",title,adem,0);
		Entry entry2 = new Entry(-1,"Aslında fena değil ya",title,ali,0);
		Entry entry3 = new Entry(-1,"Aşığım bu çocuğa",title,jorge,0);

		entryService.save(entry);
		entryService.save(entry2);
		entryService.save(entry3);
	}


}
