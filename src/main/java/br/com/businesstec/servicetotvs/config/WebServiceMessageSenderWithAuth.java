package br.com.businesstec.servicetotvs.config;

import br.com.businesstec.servicetotvs.config.properties.SoapProperties;
import org.springframework.stereotype.Component;
import org.springframework.ws.transport.http.HttpUrlConnectionMessageSender;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Base64;

@Component
public class WebServiceMessageSenderWithAuth extends HttpUrlConnectionMessageSender {

    private final SoapProperties properties;

    public WebServiceMessageSenderWithAuth(SoapProperties properties) {
        this.properties = properties;
    }

    @Override
    protected void prepareConnection(HttpURLConnection connection)
            throws IOException {

        String userpassword = properties.getUsername() + ":" + properties.getPassword();
        var encodedAuthorization = Base64.getEncoder().encodeToString(userpassword.getBytes());
        connection.setRequestProperty("Authorization", "Basic " + encodedAuthorization);

        super.prepareConnection(connection);

    }
}
