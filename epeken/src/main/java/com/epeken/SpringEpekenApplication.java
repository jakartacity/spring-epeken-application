package com.epeken;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.epeken.model")
@EnableJpaRepositories("com.epeken.repository")
public class SpringEpekenApplication {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SpringEpekenApplication.class, args);
	}

}
