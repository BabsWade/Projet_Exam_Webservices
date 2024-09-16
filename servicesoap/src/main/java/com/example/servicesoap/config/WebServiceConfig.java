package com.example.servicesoap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WebServiceConfigurer;
import org.springframework.ws.config.annotation.WebServiceConfigurerAdapter;
import org.springframework.ws.soap.server.endpoint.annotation.SoapEndpoint;
import org.springframework.ws.soap.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.soap.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.soap.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.schema.XsdSchema;
import org.springframework.ws.schema.impl.SimpleXsdSchema;

@Configuration
@EnableWs
public class WebServiceConfig extends WebServiceConfigurerAdapter {

    @Bean
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema bankSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("BankingPort");
        definition.setLocationUri("/ws/banking");
        definition.setTargetNamespace("http://example.com/banking");
        definition.setSchema(bankSchema);
        return definition;
    }

    @Bean
    public XsdSchema bankSchema() {
        return new SimpleXsdSchema(new ClassPathResource("banking.xsd"));
    }
}
