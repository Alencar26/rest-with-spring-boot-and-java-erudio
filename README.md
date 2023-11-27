# Projeto REST API c/ SpringBoot | Java | AWS

### Note que o repositório possui várias Branches para navegar pelas fases de aprendizado.

## Menu Branches:
- **[Main](https://github.com/Alencar26/rest-with-spring-boot-and-java-erudio/tree/main/05_FistStepInJavaWithSpringBoot/rest-with-spring-boot-and-java-erudio)**: possui o conceito básico de REST API. (PathVariables, RequestParams e Excessão Customizada)
- **[EX_injecao_dependencia](https://github.com/Alencar26/rest-with-spring-boot-and-java-erudio/tree/Ex_injecao_dependencia/05_FistStepInJavaWithSpringBoot/rest-with-spring-boot-and-java-erudio)**: 
    -   Explorando novos métodos do REST. (Injeção de Dependencia, CRUD e ResposeStatus)
    - **CRUD completo com interação com base de dados na AWS**
    - Conceitors de repository do JPA
    - Refatoração para código mais legível
- **[PadraoProjetoValueObject](https://github.com/Alencar26/rest-with-spring-boot-and-java-erudio/tree/PadraoProjetoValueObject/05_FistStepInJavaWithSpringBoot/rest-with-spring-boot-and-java-erudio)**
    - Implementação do padrão de projeto Value Object (VO)
    - Utilização de Mapper para converter uma classe em outra
    - Dozer Mapper
    - Testes Unitários
- **[feature/versionamento_endpont](https://github.com/Alencar26/rest-with-spring-boot-and-java-erudio/tree/feature/versionamento_endpoint/05_FistStepInJavaWithSpringBoot/rest-with-spring-boot-and-java-erudio)**
    - Criação de nova versão para a rota de  criação
    - Mapper Customizado
    - Refatoração do código para suportar nova versão.
- **[frature/migrations_com_flyway](https://github.com/Alencar26/rest-with-spring-boot-and-java-erudio/tree/frature/migrations_com_flyway/05_FistStepInJavaWithSpringBoot/rest-with-spring-boot-and-java-erudio)**
    - Implementação de migration para gerenciar a base de dados;
    - Add dependência necessárias;
    - Novo endpoint com versionamento.
- **[feature/Custom_Json_Serialization](https://github.com/Alencar26/rest-with-spring-boot-and-java-erudio/tree/feature/Custom_Json_Serialization/05_FistStepInJavaWithSpringBoot/rest-with-spring-boot-and-java-erudio)**
    - Ordenação dos campos no JSON da API;
    - Alteração do nome de exibição de um campo no json;
    - Ignorar determinado campo para não ser exibido no Json.
- **[feature/Content_Negotiation](https://github.com/Alencar26/rest-with-spring-boot-and-java-erudio/tree/feature/Content_Negotiation/05_FistStepInJavaWithSpringBoot/rest-with-spring-boot-and-java-erudio)**
    - Suporte a XML e YAML
    - Controle via QueryParam
    - Controle via HeaderParam
- [feature/HATEOAS](https://github.com/Alencar26/rest-with-spring-boot-and-java-erudio/tree/feature/HATEOAS/05_FistStepInJavaWithSpringBoot/rest-with-spring-boot-and-java-erudio)
    - Implementação de HATEOAS para gerar link no response da request.
    - Mockito - Cobertura de testes automatizados para validar a geração dos Link.
    - JsonProperty - Ordenação dos elementos no response e alteração na nomenclatura dos mesmos.
    - Add nova Custom Exception