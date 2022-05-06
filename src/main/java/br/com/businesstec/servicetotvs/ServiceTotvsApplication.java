package br.com.businesstec.servicetotvs;

import br.com.businesstec.servicetotvs.config.properties.SoapProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ServiceTotvsApplication {

	@Autowired
	private SoapProperties soapProperties;

	public static void main(String[] args) {
		SpringApplication.run(ServiceTotvsApplication.class, args);
	}

	@Bean
	CommandLineRunner run(SoapProperties soapProperties) {
		return args -> {
			System.out.println(soapProperties.getSaveRecord());
		};
	}

	@Bean
	ObjectMapper objectMapper() {
		var objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		return objectMapper;
	}
}
