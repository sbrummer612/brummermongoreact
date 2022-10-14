package com.brummer.brummermongoreact.brummermongoreact;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.brummer.brummermongoreact.brummermongoreact.test.Test;
import com.brummer.brummermongoreact.brummermongoreact.test.TestRepository;

import reactor.core.publisher.Flux;

@Configuration
public class LoadDatabase {

	@Bean
	CommandLineRunner init(TestRepository testRepository) {
		
		return args -> {
			Flux.just(
				new Test("testone"),
				new Test("testtwo")
			)
			.flatMap(testRepository::save)
			.subscribe(System.out::println);
		};
	}
}
