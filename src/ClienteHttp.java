import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Classe responsável por realizar requisições HTTP GET utilizando a API HttpClient.
 * Encapsula a criação do cliente e o envio das requisições, retornando o corpo da resposta.
 */
public class ClienteHttp {
    // Instância do HttpClient para gerenciar as conexões HTTP
        private HttpClient client;

    /**
     * Construtor padrão.
     * Inicializa o HttpClient para ser utilizado nas requisições.
     */
        public ClienteHttp() {
            this.client = HttpClient.newHttpClient();
        }

    /**
     * Executa uma requisição HTTP GET para a URL informada.
     *
     * @param url Endereço do recurso a ser acessado.
     * @return O corpo da resposta em formato String.
     * @throws IOException Em caso de falha na comunicação ou resposta inválida.
     * @throws InterruptedException Caso a requisição seja interrompida.
     */
        public String get(String url) throws IOException, InterruptedException {
            // Cria o objeto de requisição GET com a URL informada
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            // Envia a requisição e obtém a resposta como String
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Verifica o status da resposta e lança exceção caso não seja sucesso (200 OK)
            if (response.statusCode() != 200) {
                throw new IOException("Erro na requisição: " + response.statusCode());
            }

            // Retorna o corpo da resposta em formato texto
            return response.body();
        }
    }