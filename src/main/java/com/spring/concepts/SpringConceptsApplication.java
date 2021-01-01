package com.spring.concepts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:spring.xml", "classpath:spring1.xml"})
public class SpringConceptsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConceptsApplication.class, args);
	}

}
