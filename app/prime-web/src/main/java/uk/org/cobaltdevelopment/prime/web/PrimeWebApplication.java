package uk.org.cobaltdevelopment.prime.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;

import uk.org.cobaltdevelopment.prime.PrimeGenerator;
import uk.org.cobaltdevelopment.prime.web.adapter.DefaultPrimeTableAdapter;
import uk.org.cobaltdevelopment.prime.web.adapter.PrimeTableAdapter;
import uk.org.cobaltdevelopment.prime.web.controller.Controllers;
import uk.org.cobaltdevelopment.prime.web.service.Services;

@ContextConfiguration(classes = { Controllers.class, Services.class })
@SpringBootApplication
public class PrimeWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeWebApplication.class, args);
	}

	@Bean
	public PrimeGenerator primeGenerator() {
		return new PrimeGenerator();
	}

	@Bean
	public PrimeTableAdapter primeTableAdapter() {
		return new DefaultPrimeTableAdapter();
	}
}
