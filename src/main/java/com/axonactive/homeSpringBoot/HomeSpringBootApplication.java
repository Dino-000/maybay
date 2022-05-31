package com.axonactive.homeSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HomeSpringBootApplication extends SpringServletContainerInitializer {


	protected SpringApplicationBuilder configure(SpringApplicationBuilder app){
		return app.sources(HomeSpringBootApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(HomeSpringBootApplication.class, args);
	}

}
