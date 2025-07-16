package br.com.alura.scrammer_spring.principal;

import br.com.alura.scrammer_spring.service.ConsumoApi;

import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();

    // URL base da API OMDB
    private final String ENDERECO ="https://omdbapi.com/?t=";
    private final String API_KEY ="&apikey=6585022c";

    public void exibeMenu() {
        Scanner scanner = new Scanner(System.in);
        int escolha = 0;
        var nomeSerie = leitura.nextLine();

        var json = consumo.obterDados(ENDERECO + nomeSerie + API_KEY);

        while (true) {
            System.out.println("Bem-vindo(a) ao Screammer Spring! ✨");
            System.out.println("\nSelecione uma opção:");
            System.out.println("1. Buscar série por nome");
            System.out.println("2. Buscar episódio por nome");
            System.out.println("3. Buscar temporada por número");
            System.out.println("4. Sair");
            System.out.println("\nDigite sua escolha: ");

            if (scanner.hasNextInt()) {
                escolha = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine(); // Limpa entrada inválida
                continue;
            }

            switch (escolha) {
                case 1:
                    System.out.println("\nDigite o nome da série que deseja buscar: ");
                    String urlSerie = ENDERECO + nomeSerie.replace(" ", "+") + API_KEY;
                    System.out.println("\nVocê buscou pela série: " + nomeSerie);
                    System.out.println("URL de busca: " + urlSerie);
                    break;
                case 2:
                    System.out.println("\nDigite o nome do episódio que deseja buscar: ");
                    String nomeEpisodio = scanner.nextLine();
                    String urlEpisodio = ENDERECO + nomeEpisodio.replace(" ", "+") + API_KEY;
                    System.out.println("\nVocê buscou pelo episódio: " + nomeEpisodio);
                    System.out.println("URL de busca: " + urlEpisodio);
                    break;
                case 3:
                    System.out.println("\nDigite o número da temporada que deseja buscar: ");
                    if (scanner.hasNextInt()) {
                        int numeroTemporada = scanner.nextInt();
                        scanner.nextLine(); // Limpa o buffer
                        String urlTemporada = ENDERECO + "season+" + numeroTemporada + API_KEY;
                        System.out.println("\nVocê buscou pela temporada número: " + numeroTemporada);
                        System.out.println("URL de busca: " + urlTemporada);
                    } else {
                        System.out.println("Número inválido.");
                        scanner.nextLine(); // Limpa entrada inválida
                    }
                    break;
                case 4:
                    System.out.println("Saindo do programa. Até logo! ✨");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }
    }
}
