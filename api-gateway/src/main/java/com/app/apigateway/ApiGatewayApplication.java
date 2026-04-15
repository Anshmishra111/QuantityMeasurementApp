package com.app.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * UC18 – API Gateway
 * Routes all incoming requests to the appropriate downstream microservice.
 * Ports: Gateway=8080, auth-service=8081, measurement-service=8082, history-service=8083
 */
@SpringBootApplication
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}
