package com.creditscoresoapservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
@ComponentScan("com.creditscoresoapservice") 
public class AppConfig extends WsConfigurerAdapter {

	@Bean(name = "creditscore")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema creditscoreSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("CreditscorePort");
		wsdl11Definition.setLocationUri("/soapws");
		wsdl11Definition.setTargetNamespace("http://creditscoresoapservice.com/soap");
		wsdl11Definition.setSchema(creditscoreSchema);
		return wsdl11Definition;
	}
	@Bean
	public XsdSchema creditscoreSchema() {
		return new SimpleXsdSchema(new ClassPathResource("creditscore.xsd"));
	}
}
