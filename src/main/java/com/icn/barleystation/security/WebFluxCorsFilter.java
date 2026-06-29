package com.icn.barleystation.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Configuration
public class WebFluxCorsFilter {

    @Bean
    public WebFilter corsFilter() {
        return (ServerWebExchange exchange, WebFilterChain chain) -> {
            // 1. Inyectamos las cabeceras de CORS manualmente a TODAS las peticiones
            exchange.getResponse().getHeaders().add("Access-Control-Allow-Origin", "*");
            exchange.getResponse().getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");
            exchange.getResponse().getHeaders().add("Access-Control-Allow-Headers", "*");
            exchange.getResponse().getHeaders().add("Access-Control-Max-Age", "3600");

            // 2. SI LA PETICIÓN ES AN OPTIONS (PREFLIGHT), LE RESPONDEMOS 200 OK DE INMEDIATO
            if (exchange.getRequest().getMethod() == HttpMethod.OPTIONS) {
                exchange.getResponse().setStatusCode(HttpStatus.OK);
                return Mono.empty(); // Rompe la cadena aquí, no deja que Springfox la bloquee
            }

            return chain.filter(exchange);
        };
    }
}