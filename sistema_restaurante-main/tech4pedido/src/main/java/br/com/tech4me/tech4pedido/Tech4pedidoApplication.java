package br.com.tech4me.tech4pedido;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class Tech4pedidoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tech4pedidoApplication.class, args);
	}

}
