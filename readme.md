# JobAppApiMicroServices

This app converts a monolithic REST API (https://github.com/aty5/jobappapi) into microservices.

**Technical environment** :
* Docker Engine + Docker Compose (Docker Desktop)
* JDK17 / Maven / Tomcat
* Spring Boot / Spring Data JPA / PostgreSQL
* HTTP Client
* Git

## Architecture
```mermaid
flowchart LR
    Browser[HTTP Client] --> APIGateway[API Gateway]

    %% Encadrer les composants et services avec Eureka
    subgraph Application[Application]
        direction TB

        %% Services
        subgraph JobService[Job Service]
            Job[Job] --> JobDB[(Job DB)]
        end

        subgraph CompanyService[Company Service]
            Company[Company] --> CompanyDB[(Company DB)]
        end

        subgraph ReviewService[Review Service]
            Review[Review] --> ReviewDB[(Review DB)]
        end
    end

    %% Liaisons entre sous-graphes
    JobService --- CompanyService
    ReviewService --- CompanyService
    ReviewService --- JobService

    %% Lien entre l'API Gateway et le sous-graphe Eureka
    APIGateway --> Application
    EurekaServer[Eureka Server] --> Application
    ConfigServer[Config Server] --> Application
    Zipkin[Zipkin] --> Application
```