package tn.esprit.examen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;


@SpringBootApplication
public class GatewayApplication {
/*	@Configuration
	public class GatewayConfig {
		@Bean
		public RestClient.Builder restClientBuilder() {
			return RestClient.builder();
		}
	}
*/
public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	/*@Bean
	RouteLocator gatewayRoutes (RouteLocatorBuilder routeLocatorBuilder){
		return routeLocatorBuilder.routes()
				.route(r->r.path("/products/**").uri("http://localhost:8089/"))
				.route(r -> r.path("/products/**").uri("lb://MSPRODUIT"))
				.build();
	}
	/*DiscoveryClientRouteDefinitionLocator definitionLocator(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties properties){
		return  new DiscoveryClientRouteDefinitionLocator(rdc,properties);
	}
	*/


}
