package com.wecan.footballapp;

import com.wecan.footballapp.entity.Entry;
import com.wecan.footballapp.entity.Title;
import com.wecan.footballapp.entity.User;
import com.wecan.footballapp.repository.EntryRepository;
import com.wecan.footballapp.repository.TitleRepository;
import com.wecan.footballapp.repository.UserRepository;
import com.wecan.footballapp.service.EntryService;
import com.wecan.footballapp.service.TitleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

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
		Title title = new Title("besiktas");
		titleService.save(title);

		Entry entry = new Entry("haydi",title);
		Entry entry1 = new Entry("güzelim",title);
		Entry entry2 = new Entry("tiner",title);
		Entry entry3 = new Entry("cekelim" ,title);

		entryService.save(entry);
		entryService.save(entry1);
		entryService.save(entry2);
		entryService.save(entry3);
	}


}
