import com.google.gson.Gson;

import java.io.IOException;

/**
 * Classe responsável por se comunicar com a API de câmbio (ExchangeRate API)
 * e retornar as taxas de conversão de uma moeda base.
 */

public class ApiMoedasService {
    // Cliente HTTP utilizado para realizar as requisições
    private ClienteHttp clienteHttp;

    // Instância do Gson para desserializar o JSON retornado pela API
    private Gson gson;

    // Chave de autenticação da API
    private String apiKey;

    // URL base da API
    private static String baseUrl = "https://v6.exchangerate-api.com/v6/";

    /**
    * Construtor que inicializa o serviço com a chave de API.
    */
    public ApiMoedasService(String apiKey){
        this.clienteHttp = new ClienteHttp();
        this.gson = new Gson();
        this.apiKey = apiKey;
    }

    /**
     * Busca as taxas de câmbio com base em uma moeda informada.
     *
     * @param moedaBase Código da moeda base (ex: "USD", "BRL", "EUR").
     * @return Um objeto {@link RespostaAPI} contendo os dados da resposta.
     * @throws IOException Em caso de falha de comunicação ou erro de resposta da API.
     * @throws InterruptedException Caso a requisição seja interrompida.
     */
    public RespostaAPI buscarTaxas(String moedaBase) throws IOException, InterruptedException {
        // Monta a URL completa da requisição
        String url = baseUrl + apiKey + "/latest/" + moedaBase;

        // Executa a chamada HTTP e obtém o JSON de resposta
        String jsonResposta = clienteHttp.get(url);

        // Converte o JSON em um objeto RespostaAPI
        return gson.fromJson(jsonResposta, RespostaAPI.class);
    }
}
