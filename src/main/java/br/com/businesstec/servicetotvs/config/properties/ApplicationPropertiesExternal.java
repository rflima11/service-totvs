package br.com.businesstec.servicetotvs.config.properties;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:C:\\config\\totvs.properties")
public class ApplicationPropertiesExternal {
}
