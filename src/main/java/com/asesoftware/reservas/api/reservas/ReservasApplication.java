package com.asesoftware.reservas.api.reservas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ConfigurationProperties
@PropertySource(value = {"classpath:application.properties","file:C://Properties//reservas.properties"})
//@PropertySource(value = {"classpath:application.properties","file:/Properties/reservas.properties"})
public class ReservasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservasApplication.class, args);
	}

}
