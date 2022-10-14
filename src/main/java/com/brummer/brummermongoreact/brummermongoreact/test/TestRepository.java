package com.brummer.brummermongoreact.brummermongoreact.test;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TestRepository extends ReactiveCrudRepository<Test, String> {

}
