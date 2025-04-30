package com.example.umc.umc_8th;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
public class Umc8thApplication {

	public static void main(String[] args) {
		SpringApplication.run(Umc8thApplication.class, args);
	}

}
