package br.com.alura.scrammer_spring;

import br.com.alura.scrammer_spring.model.DadosSerie;
import br.com.alura.scrammer_spring.service.ConsumoApi;
import br.com.alura.scrammer_spring.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScrammerSpringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScrammerSpringApplication.class, args);
	}

	// Consumindo API e convertendo JSON para objeto Java
	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		System.out.println(json);

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);

	}
}
