# 💱 Conversor de Moedas

Projeto desenvolvido como **primeiro desafio da formação Backend do programa ONE (Oracle Next Education)**.  
O objetivo é **consumir uma API de câmbio em tempo real** para consultar taxas de conversão entre diferentes moedas.

---

## 🚀 Sobre o projeto

O **Conversor de Moedas** é uma aplicação Java que se conecta à **ExchangeRate API**, obtendo as taxas de câmbio mais recentes.  
A partir dessas informações, é possível realizar conversões entre moedas de forma simples e rápida.

Este projeto foi desenvolvido para praticar:
- Consumo de APIs externas com `HttpClient`
- Manipulação de dados JSON com `Gson`
- Boas práticas de estruturação e documentação de código Java

---

## 🛠️ Tecnologias utilizadas

- ☕ **Java 17+**
- 🧩 **Gson** – para conversão de JSON em objetos Java  
- 🌐 **ExchangeRate API** – para obtenção das taxas de câmbio  
- 🧠 **IntelliJ IDEA** – ambiente de desenvolvimento

---

## ⚙️ Estrutura principal

- `ClienteHttp.java` → Responsável por enviar requisições HTTP e retornar as respostas.  
- `ApiMoedasService.java` → Camada de serviço que consome a API e retorna os dados processados.  
- `RespostaAPI.java` → Classe modelo para mapear os dados retornados pela API.

---

## ▶️ Como executar
```
1. Clone este repositório:

   git clone https://github.com/seu-usuario/conversor-de-moedas.git
Abra o projeto no IntelliJ IDEA.

Adicione a biblioteca Gson ao classpath.

Crie uma conta gratuita na ExchangeRate API e copie sua API Key.

Execute a classe principal e insira a API Key e o código da moeda base (ex: USD, BRL, EUR).
```
💡 Exemplo de uso
```
ApiMoedasService service = new ApiMoedasService("SUA_API_KEY");
RespostaAPI resposta = service.buscarTaxas("USD");

System.out.println("Taxa de câmbio USD → BRL: " + resposta.getTaxaDeMoeda("BRL"));
Saída esperada:
Taxa de câmbio USD → BRL: 5.42
```
🧾 Aprendizados
Criação de classes organizadas e reutilizáveis em Java

Uso de HttpClient e tratamento de respostas HTTP

Conversão e manipulação de JSON com Gson

Integração de API externa e boas práticas de versionamento no GitHub

📄 Licença
Este projeto está sob a licença MIT.
Sinta-se à vontade para usar, estudar e adaptar o código!

✨ Desenvolvido por Bia
Com 💛 e muito aprendizado no programa ONE - Oracle Next Education.
