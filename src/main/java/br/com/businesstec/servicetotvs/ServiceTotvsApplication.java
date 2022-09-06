package br.com.businesstec.servicetotvs;

import br.com.businesstec.servicetotvs.config.properties.SoapProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.EnableRetry;


@SpringBootApplication
@EnableRetry
public class ServiceTotvsApplication {//extends SpringBootServletInitializer {

	@Autowired
	private SoapProperties soapProperties;

	public static void main(String[] args) {

		SpringApplication application = new SpringApplication(ServiceTotvsApplication.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);
	}

	@Bean
	ObjectMapper objectMapper() {
		var objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		return objectMapper;
	}
}
