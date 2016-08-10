package io.tyke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.tyke.repositories.MongoReporitoryFactory;

@SpringBootApplication
public class TykeApplication {


	public static void main(String[] args) {
		SpringApplication.run(TykeApplication.class, args);
	}
	
}
