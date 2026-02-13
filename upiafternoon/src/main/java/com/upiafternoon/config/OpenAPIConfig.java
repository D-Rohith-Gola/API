package com.upiafternoon.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
//@Profile("prod")
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("UPI Account Management API")
                        .version("2.0")
                        .description("API for managing UPI Account in the NPCI Family")
                        .contact(new Contact()
                                .name("D Rohith Gola")
                                .email("rohith.gola@npci.org.in")
                                .url("https://rohithgola.com")));
    }
}