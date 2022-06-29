package br.com.businesstec.servicetotvs.utils;

import org.springframework.stereotype.Component;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessage;

import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;

@Component
public class MyCdataInterceptor implements EndpointInterceptor {
    @Override

    public boolean handleRequest(MessageContext messageContext, Object o) throws Exception {
        return true;
    }
    @Override

    public boolean handleResponse(MessageContext messageContext, Object o) throws Exception {

        WebServiceMessage response = messageContext.getResponse();
        System.out.println(o);
        SaajSoapMessage saajSoapMessage = (SaajSoapMessage) response;
        var soapMessage = saajSoapMessage.getSaajMessage();
        var soapPart = soapMessage.getSOAPPart();
        var envelope = soapPart.getEnvelope();
        var body = envelope.getBody();
        var it = body.getChildElements();


//        var interestingNode = (Node) it.getNextSibling();
//
//        CDATASection cdat = soapPart.createCDATASection(interestingNode.getFirstChild().getNodeValue());
//        interestingNode.removeChild(interestingNode.getFirstChild());
//        interestingNode.appendChild(cdat);
        return true;
    }

    @Override
    public boolean handleFault(MessageContext messageContext, Object o) throws Exception {
        return false;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Object o, Exception e) throws Exception {

    }


    public boolean handleRequest(MessageContext messageContext) throws WebServiceClientException {
        try {
            WebServiceMessage response = messageContext.getRequest();

            SoapMessage saajSoapMessage = (SoapMessage) response;
//            var soapMessage = saajSoapMessage.getSaajMessage();
//            var soapPart = soapMessage.getSOAPPart();
//            SOAPEnvelope envelope = null;
//            envelope = soapPart.getEnvelope();
//            var body = envelope.getBody();
//            var it = body.getChildElements();
//            it.forEachRemaining(t ->
//                    System.out.println(t)
//            );
//            System.out.println(it);
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean handleResponse(MessageContext messageContext) throws WebServiceClientException {

        try {
            WebServiceMessage response = messageContext.getResponse();

            SaajSoapMessage saajSoapMessage = (SaajSoapMessage) response;
            var soapMessage = saajSoapMessage.getSaajMessage();
            var soapPart = soapMessage.getSOAPPart();
            SOAPEnvelope envelope = null;
            envelope = soapPart.getEnvelope();
            var body = envelope.getBody();
            var it = body.getChildElements();
            it.forEachRemaining(t -> System.out.println(t));
            System.out.println(it);
        } catch (SOAPException e) {
            e.printStackTrace();
        }


//        var interestingNode = (Node) it.getNextSibling();
//
//        CDATASection cdat = soapPart.createCDATASection(interestingNode.getFirstChild().getNodeValue());
//        interestingNode.removeChild(interestingNode.getFirstChild());
//        interestingNode.appendChild(cdat);
        return true;
    }

    public boolean handleFault(MessageContext messageContext) throws WebServiceClientException {

        return false;
    }

    public void afterCompletion(MessageContext messageContext, Exception e) throws WebServiceClientException {

    }
}