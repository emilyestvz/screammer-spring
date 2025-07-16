package br.com.alura.scrammer_spring;

import br.com.alura.scrammer_spring.model.DadosSerie;
import br.com.alura.scrammer_spring.model.DadosEpisodio;
import br.com.alura.scrammer_spring.model.DadosTemporada;
import br.com.alura.scrammer_spring.service.ConsumoApi;
import br.com.alura.scrammer_spring.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

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

		// Consumindo API e convertendo JSON para objeto Java em DadosSerie
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);

		// Consumindo API atualizada e convertendo JSON para objeto Java em Episodios
		json = consumoApi.obterDados("https://omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=6585022c");
		DadosEpisodio dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);
		System.out.println(dadosEpisodio);

		// Exibindo as temporadas e seus episódios
		List<DadosTemporada> temporadas = new ArrayList<>();

		for (int i = 1; i <= dados.totalTemporadas(); i++) {
			json = consumoApi.obterDados("https://omdbapi.com/?t=gilmore+girls&season=" + i + "&apikey=6585022c");
			var dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);

		}

		temporadas.forEach(System.out::println);


	}
}