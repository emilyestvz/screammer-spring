package br.com.alura.scrammer_spring;

import br.com.alura.scrammer_spring.service.ConsumoApi;
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
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("@JsonAlias");
		System.out.println(json);


	}
}
