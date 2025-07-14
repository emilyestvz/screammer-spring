package br.com.alura.scrammer_spring.service;

public interface IConverteDados {
    /**
     * Método genérico para converter um JSON em um objeto do tipo T.
     *
     * @param json o JSON a ser convertido
     * @param <T> o tipo do objeto de destino
     * @return o objeto convertido do tipo T
     */
    <T> T obterDados(String json, Class<T> classe);
}
