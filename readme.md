# JobAppApiMicroservices

**Project objectives** :
* Convert a monolithic REST API (https://github.com/aty5/jobappapi) into microservices architecture
* Use it as a basis for learning new skills in microservices environments


**Environment** :
* Docker Engine + Docker Compose (Docker Desktop)
* JDK17 / Maven / Tomcat
* Spring Boot / Spring Data JPA / PostgreSQL
* HTTP Client (Postman,...)
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