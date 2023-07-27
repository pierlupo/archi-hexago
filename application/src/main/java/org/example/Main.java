package org.example;

import org.example.config.ApiRestConfig;
import org.example.config.ApiRestInitializer;
import org.example.config.InfraConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        SpringApplication infra = new SpringApplication(InfraConfig.class);
        infra.setDefaultProperties(Collections.singletonMap("server.port", "8082"));
        ConfigurableApplicationContext infraContext = infra.run();

        SpringApplication apiRest = new SpringApplication(ApiRestConfig.class);
        apiRest.setDefaultProperties(Collections.singletonMap("server.port", "8081"));
        apiRest.addInitializers(new ApiRestInitializer(infraContext));
        ConfigurableApplicationContext apiRestContext = apiRest.run();
    }
}