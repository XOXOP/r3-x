package com.example.r3.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Swager {

    @Bean
    public OpenAPI api(){
return  new OpenAPI()
        .servers(
                List.of( new Server().url("http://http://localhost:8080/7/status"))).info(
                        new Info().title("Our Shipment arrive")
        );
    }
}
