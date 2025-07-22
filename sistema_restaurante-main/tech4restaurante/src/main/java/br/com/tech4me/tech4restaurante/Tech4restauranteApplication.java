package br.com.tech4me.tech4restaurante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Tech4restauranteApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tech4restauranteApplication.class, args);
	}

}
