package br.com.alura.scrammer_spring.principal;

import br.com.alura.scrammer_spring.model.DadosEpisodio;
import br.com.alura.scrammer_spring.model.DadosSerie;
import br.com.alura.scrammer_spring.model.DadosTemporada;
import br.com.alura.scrammer_spring.service.ConsumoApi;
import br.com.alura.scrammer_spring.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();

    private ConverteDados conversor = new ConverteDados();

    // URL base da API OMDB
    private final String ENDERECO ="https://omdbapi.com/?t=";
    private final String API_KEY ="&apikey=6585022c";

    public void exibeMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=========================================");
        System.out.println("\t\tBem-vindo ao Scrammer! ✨");
        System.out.println("=========================================");
        System.out.println("Digite o nome da série que deseja pesquisar: ");

        var nomeSerie = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);

        System.out.println(dados);

        // Exibindo as temporadas e seus episódios
		List<DadosTemporada> temporadas = new ArrayList<>();

		for (int i = 1; i <= dados.totalTemporadas(); i++) {
			json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
			var dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}

		temporadas.forEach(System.out::println);

//        for(int i = 0; i < dados.totalTemporadas(); i++) {
//            List<DadosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
//
//            for(int j = 0; j < episodiosTemporada.size(); j++) {
//                DadosEpisodio episodio = episodiosTemporada.get(j);
//                System.out.println("Temporada " + (i + 1) + ", Episódio " + (j + 1) + ": " + episodio.titulo());
//            }
//        }

        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));
        temporadas.forEach(System.out::println);
    }
}


