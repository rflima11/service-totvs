package br.com.businesstec.servicetotvs;

import br.com.businesstec.servicetotvs.config.properties.SoapProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ServiceTotvsApplication {//extends SpringBootServletInitializer {

	@Autowired
	private SoapProperties soapProperties;

	public static void main(String[] args) {
		SpringApplication.run(ServiceTotvsApplication.class, args);
	}

	@Bean
	ObjectMapper objectMapper() {
		var objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		return objectMapper;
	}
}
