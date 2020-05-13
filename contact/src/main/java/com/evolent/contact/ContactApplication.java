package com.evolent.contact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EntityScan(basePackages = {"com.evolent.contact.model"})
@ComponentScan(basePackages = {"com.evolent.contact.*"})
public class ContactApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactApplication.class, args);
	}
	
	 @Bean
	 public Docket api() { 
		 return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()                                  
				 .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
				 .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.cloud")))
				 .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.security")))
     		  .build();                                           
	    }

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Contact Service API")
				.description("To support contact service API").version("1.0.0").build();
	}

}
