package com.ra.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication {

//	@Bean
//	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route("catalog-service", r -> r
//						.path("/catalog-service/**")
////						.uri("lb://catalog-core-service"))
//						.uri("http://localhost:8100/"))
//				.build();
//	}


	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
