package com.ecom.gateway;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @author Paul Badea
 **/

@Configuration
public class GatewayConfig {

    @Bean
    public RedisRateLimiter redisRateLimiter() {
        return new RedisRateLimiter(10, 20, 1);
    }

    @Bean
    public KeyResolver hostNameKeyResolver() {
        return exchange -> Mono.just(
                exchange.getRequest().getRemoteAddress().getHostName());
    }



    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("product-service", r -> r.path("/api/products/**")
                        .filters(f -> f
                                        .retry(retryConfig -> retryConfig
                                                .setRetries(10)
                                                .setMethods(HttpMethod.GET)
                                            )
                                        .requestRateLimiter(c -> c
                                                .setRateLimiter(redisRateLimiter())
                                                .setKeyResolver(hostNameKeyResolver()))
                                        .circuitBreaker(c -> c
                                        .setName("ecomBreaker")
                                        .setFallbackUri("forward:/fallback/products")))
                        .uri("lb://product-service"))
                .route("order-service", r -> r.path("/api/orders/**", "/api/cart/**")

                        .uri("lb://order-service"))
                .route("user-service", r -> r.path("/api/users/**")

                        .uri("lb://user-service"))

//                .route("user-service", r -> r
//                        .path("/users/**")
//                        .filters(f -> f.rewritePath("/users(?<segment>/?.*)", "/api/users${segment}"))
//                        .uri("lb://user-service"))

                .route("eureka-server",
                        r -> r
                                    .path("/eureka/main")
                                    .filters(f -> f.setPath("/"))
                                    .uri("http://localhost:8761"))
                .route("eureka-server-static", r -> r.path("/eureka/**").uri("http://localhost:8761"))
                .build();
    }

}
