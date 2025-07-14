package br.com.alura.scrammer_spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScrammerSpringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScrammerSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Scrammer Spring Application is running! ✨");
	}
}
