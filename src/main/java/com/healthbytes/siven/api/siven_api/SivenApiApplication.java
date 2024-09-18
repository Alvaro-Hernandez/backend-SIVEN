package com.healthbytes.siven.api.siven_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SivenApiApplication {

	public static void main(String[] args) {
		System.out.println("DB URL: " + System.getenv("SIVEN_DB_URL"));
		System.out.println("DB Username: " + System.getenv("SIVEN_DB_USERNAME"));
		System.out.println("DB Password: " + System.getenv("SIVEN_DB_PASSWORD"));

		SpringApplication.run(SivenApiApplication.class, args);
	}

}
