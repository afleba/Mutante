package com.application.mutante;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MutanteProjectApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MutanteProjectApplication.class);
		ConfigurableApplicationContext context = app.run(args);

		// Obteniendo el puerto desde las propiedades de la aplicación
		String port = context.getEnvironment().getProperty("server.port");
		System.out.println("La aplicación está corriendo en el puerto: " + port);
	}
}
