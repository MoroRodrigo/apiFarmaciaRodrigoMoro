package br.edu.infnet.rodrigomoro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class RodrigomoroApplication {

	public static void main(String[] args) {
		SpringApplication.run(RodrigomoroApplication.class, args);
	}

}
