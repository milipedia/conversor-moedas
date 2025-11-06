void main() {

    /**
     * Classe principal responsável pela execução do Conversor de Moedas.
     * Exibe o menu interativo e realiza as conversões de acordo com a escolha do usuário.
     */
    Scanner leitura = new Scanner(System.in);
    String apiKey = "f3bd8550ff81186ce371b654";
    ApiMoedasService apiService = new ApiMoedasService(apiKey);

    boolean continuar = true;

    // Loop principal do programa
    while (continuar){
        exibirMenu();
        int opcao = leitura.nextInt();

        // Encerra o programa
        if(opcao == 7){
            continuar = false;
            System.out.println("Encerrando o programa..");
            break;
        }

        System.out.println("Digite o valor a ser convertido: ");
        double valor = leitura.nextDouble();

        // Executa a conversão conforme a opção selecionada
        try{
            realizarConversao(opcao, valor, apiService);
        }catch (IOException | InterruptedException e){
            System.out.println("Erro ao buscar esta conversão: " + e.getMessage());
        }
        System.out.println();
    }
    leitura.close();
}

/**
 * Exibe o menu de opções de conversão.
 */
private static void exibirMenu(){
    System.out.println("=== CONVERSOR DE MOEDAS ===");
    System.out.println("1) Dólar (USD) → Real (BRL)");
    System.out.println("2) Real (BRL) → Dólar (USD)");
    System.out.println("3) Dólar (USD) → Euro (EUR)");
    System.out.println("4) Euro (EUR) → Dólar (USD)");
    System.out.println("5) Dólar (USD) → Libra (GBP)");
    System.out.println("6) Libra (GBP) → Dólar (USD)");
    System.out.println("7) Sair");
    System.out.print("Escolha uma opção: ");
}

/**
 * Realiza a conversão de moeda com base na opção escolhida pelo usuário.
 *
 * @param opcao      Código da opção selecionada no menu.
 * @param valor      Valor a ser convertido.
 * @param apiService Serviço responsável por buscar as taxas de câmbio.
 * @throws IOException           Caso ocorra erro na requisição HTTP.
 * @throws InterruptedException  Caso a requisição seja interrompida.
 */
private static void realizarConversao(int opcao, double valor, ApiMoedasService apiService)
        throws IOException, InterruptedException {
    String moedaOrigem = "";
    String moedaDestino = "";

    // Define as moedas de origem e destino com base na opção
    switch (opcao){
        case 1:
            moedaOrigem = "USD";
            moedaDestino ="BRL";
            break;
        case 2:
            moedaOrigem = "BRL";
            moedaDestino ="USD";
            break;
        case 3:
            moedaOrigem = "USD";
            moedaDestino ="EUR";
            break;
        case 4:
            moedaOrigem = "EUR";
            moedaDestino ="USD";
            break;
        case 5:
            moedaOrigem = "USD";
            moedaDestino ="GBP";
            break;
        case 6:
            moedaOrigem = "GBP";
            moedaDestino ="USD";
            break;
        default:
            System.out.println("Opção inválida");
            return;
    }

    // Consulta as taxas da moeda de origem
    RespostaAPI resposta = apiService.buscarTaxas(moedaOrigem);

    // Verifica se a resposta da API foi bem-sucedida
    if("success".equals(resposta.getResult())){
        Double taxa = resposta.getTaxaDeMoeda(moedaDestino);
        if(taxa != null){
            double valorConvertido = valor * taxa;
            System.out.printf("%.2f %s = %.2f %s%n",
                    valor, moedaOrigem, valorConvertido, moedaDestino);
        }else{
            System.out.println("Moeda destino não encontrada!");
        }
    }else{
        System.out.println("Erro na resposta da API!");
    }
        }