package com.example.demowithtests.util.config.swagger;

import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;

import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class OpenApiConfig {

//    @Bean
//    public GroupedOpenApi publicUserApi() {
//        return GroupedOpenApi.builder()
//                .group("Users")
//                .pathsToMatch("/users/**")
//                .build();
//    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Application Employee API")
                        .description(" Spring Boot REST service uses OpenAPI 3.")
                        .version("v0.0.V1__init.sql"));
//    @Bean
//    public OpenAPI customApi(@Value("${application-description}")String appDescription,
//                                 @Value("${application-version}")String appVersion) {
//        return new OpenAPI().info(new Info()
//
//                        .license(new License().name("Apache 2.0")
//                                .url("http://springdoc.org"))
//                        .contact(new Contact().name("username")
//                                .email("test@gmail.com")))
//                .servers(List.of(new Server().url("http://localhost:8080")
//                                .description("Dev service"),
//                        new Server().url("http://localhost:8082")
//                                .description("Beta service")));
//    }

}}
