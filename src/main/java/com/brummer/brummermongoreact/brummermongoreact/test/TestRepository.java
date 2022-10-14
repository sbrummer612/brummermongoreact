package com.brummer.brummermongoreact.brummermongoreact.test;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Mono;

public interface TestRepository extends ReactiveCrudRepository<Test, String> {

}
