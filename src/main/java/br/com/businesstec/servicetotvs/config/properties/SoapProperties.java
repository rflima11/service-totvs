package br.com.businesstec.servicetotvs.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "soap")
public class SoapProperties {

    private String defaultUri;
    private SoapWebservices realizarConsulta;
    private SoapWebservices saveRecord;
    private String action;
    private String packageWsdl;
    private String username;
    private String password;

    public String getDefaultUri() {
        return defaultUri;
    }

    public void setDefaultUri(String defaultUri) {
        this.defaultUri = defaultUri;
    }

    public SoapWebservices getRealizarConsulta() {
        return realizarConsulta;
    }

    public void setRealizarConsulta(SoapWebservices realizarConsulta) {
        this.realizarConsulta = realizarConsulta;
    }

    public SoapWebservices getSaveRecord() {
        return saveRecord;
    }

    public void setSaveRecord(SoapWebservices saveRecord) {
        this.saveRecord = saveRecord;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getPackageWsdl() {
        return packageWsdl;
    }

    public void setPackageWsdl(String packageWsdl) {
        this.packageWsdl = packageWsdl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
