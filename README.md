# Meetup Spring Cloud

Bruno Muehlbauer de Souza - Joinville-SC - 24/07/2019

## Projetos

### Eureka

Service discovery da Netflix que registra os microserviços

### MSS-CUSTOMER-API

Serviço que cadastra clientes e se registra no Eureka

### MSS-INVOICE-API

Serviço que cadastra Invoices e se registra no Eureka.
Utiliza o Feign, o ribbon e o eureka para encontrar o e-mail do cliente pelo id sem saber o ip do serviço de customer.

### MSS-GATEWAY

Serviço que utiliza o zuul para criar uma rota e propagar a requisição para os serviços registrados no eureka. 
