package ru.bordun.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI getOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("REST API for determination of intersecting subsets and their relationship to pint Х")
                        .version("0.0.1")
                        .contact(new Contact()
                                .email("Albordunw@Gmail.com")
                                .url("null")
                                .name("Aleksander Bordun")));
    }

}
