package com.brummer.brummermongoreact.brummermongoreact;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.brummer.brummermongoreact.brummermongoreact.test.Test;
import com.brummer.brummermongoreact.brummermongoreact.test.TestRepository;

import reactor.core.publisher.Mono;

@Controller
public class HomeController {

	private final TestRepository testRepository;
	private final static String BASE_PATH = "/homeController";	

	public HomeController(TestRepository testRepository) {
		this.testRepository = testRepository;
	}
	
	@RequestMapping("")
	public Mono<String> index(Model model){
		
		model.addAttribute("extra", "This application uses SpringBoot, Spring Data Reactive MongoDB, Spring Reactive Web (Webflux), Thymeleaf MVC , lombok, MongoDB instance is needed and is external.");
		return Mono.just("index");
	}
	
	@RequestMapping( BASE_PATH + "/listTests")
	public Mono<String> listTests(Model model) {
		
		model.addAttribute("tests",	testRepository.findAll());
		return Mono.just("testsList");
	}
	
	@GetMapping( BASE_PATH + "/deleteTest")
	public Mono<String> deleteTest(@RequestParam String id){
		
		return testRepository
				.deleteById(id)
				.then(Mono.just("redirect:/homeController/listTests"));
	}
	
	@PostMapping( BASE_PATH + "/updateTest")
	public Mono<String> updateTest(Test updateTest) {
		
		return testRepository
				.save(updateTest)
				.then(Mono.just("redirect:/homeController/listTests"));
		
	}
	
	@PostMapping( BASE_PATH + "/addTest")
	public Mono<String> addTest(Test newTest) {
		
		return testRepository
			.save(newTest)
			.then(Mono.just("redirect:/homeController/listTests"));
		
	}
}
