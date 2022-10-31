package com.david.ProyectoSioca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProyectoSiocaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoSiocaApplication.class, args);
	}

}
