package com.brummer.brummermongoreact.brummermongoreact;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brummer.brummermongoreact.brummermongoreact.test.Test;
import com.brummer.brummermongoreact.brummermongoreact.test.TestRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class HomeRestController {

	private final TestRepository testRepository;
	private final static String BASE_PATH = "/homeRestController";	
	
	public HomeRestController(TestRepository testRepository) {
		this.testRepository = testRepository;
	}
	
//	@GetMapping("")
//	public String greeting(@RequestParam(required = false, defaultValue = "") String name) {
//		String url = "<br> select <a href='/homeController/listTests'>Tests</a>";
//		return name.equals("") ? "Hey!" + url : "Hey, " + name + "!" + url;
//	}
	
	@GetMapping(BASE_PATH + "/listAllTests")
	public Flux<Test> listTests(){
		return testRepository.findAll();
	}
	
	@GetMapping(BASE_PATH + "/deleteAllTests")
	public Mono<Void> deleteById(){
		return testRepository.deleteAll();
	}
	
}
