package com.asesoftware.reservas.api.reservas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ConfigurationProperties
@PropertySource(value = {"classpath:application.properties","file:C://properties//reservas.properties"})
//@PropertySource(value = {"classpath:application.properties","file:/Users/user/Documents/asesoft/CO_938_PLAN_SEMILLA_2021_2/properties/reservas.properties"})
public class ReservasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservasApplication.class, args);
	}

}
