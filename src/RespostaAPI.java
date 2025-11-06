import com.google.gson.annotations.SerializedName;
import java.util.Map;
/**
 * Classe modelo que representa a resposta retornada pela API de câmbio.
 * Contém as informações principais, como o código da moeda base e as taxas de conversão.
 */
public class RespostaAPI {
    // Indica o status da resposta (ex: "success" ou "error")
    private String result;

    // Código da moeda base utilizada na consulta (ex: "USD", "BRL", "EUR")
    @SerializedName("base_code")
    private String baseCode;  // Java usa camelCase

    // Mapa contendo as taxas de conversão para outras moedas
    @SerializedName("conversion_rates")
    private Map<String, Double> conversionRates;

    /**
     * Retorna o status da resposta da API.
     *
     * @return String representando o status (ex: "success").
     */
    public String getResult() {
        return result;
    }

    /**
     * Retorna o código da moeda base utilizada na consulta.
     *
     * @return Código da moeda base (ex: "USD").
     */
    public String getBaseCode() {
        return baseCode;
    }

    /**
     * Retorna o mapa de taxas de conversão da moeda base para outras moedas.
     *
     * @return Mapa com pares (código da moeda → taxa de conversão).
     */
    public Map<String, Double> getConversionRates() {
        return conversionRates;
    }

    /**
     * Retorna a taxa de conversão para uma moeda específica.
     *
     * @param codigoMoeda Código da moeda desejada (ex: "BRL", "EUR").
     * @return Valor da taxa de conversão ou null se não encontrado.
     */
    public Double getTaxaDeMoeda(String codigoMoeda) {
        return conversionRates.get(codigoMoeda);
    }
}