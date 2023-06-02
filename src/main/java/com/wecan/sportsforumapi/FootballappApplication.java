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

	}


}
