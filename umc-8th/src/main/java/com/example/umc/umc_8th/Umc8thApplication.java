package com.example.umc.umc_8th;

import com.example.umc.umc_8th.store.StoreQueryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
public class Umc8thApplication {

	public static void main(String[] args) {
		SpringApplication.run(Umc8thApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			StoreQueryService storeQueryService = context.getBean(StoreQueryService.class);

			String name = "요아정";
			Float score = 4.0f;

			System.out.println("Executing findStoresByNameAndScore with parameters: ");
			System.out.println("Name " + name);
			System.out.println("Score " + score);

			storeQueryService.findStoresByNameAndScore(name, score)
					.forEach(System.out::println);
		};
	}
}
