package com.storres.m5pf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class OpenApiConfiguration {

    @Bean
    OpenAPI openApi(){
        return new OpenAPI()
        .info(new Info()
    .title("Api de gestion de Libros")
    .description("Sistema de gestion de libros para una libreria virtual")
    .version("V1.0")
    .contact(new Contact() 
    .name("Santiago Torres Henao")
    .email("smart.repair.center11@gmail.com")
    
    )
    
        );
    }

}
