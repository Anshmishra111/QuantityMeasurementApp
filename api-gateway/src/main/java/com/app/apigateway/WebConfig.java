package com.app.apigateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.core.io.ClassPathResource;

import static org.springframework.web.reactive.function.server.RouterFunctions.resources;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class WebConfig {

    @Bean
    public RouterFunction<ServerResponse> htmlRouter() {
        return route(GET("/"), 
            request -> ServerResponse.ok().contentType(org.springframework.http.MediaType.TEXT_HTML)
                .bodyValue(new ClassPathResource("static/index.html")))
            .and(resources("/**", new ClassPathResource("static/")));
    }
}
