package com.tcs;

import java.util.Collection;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ShoppingUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingUserApplication.class, args);
	}
	
	@Bean
	public Docket SwaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/user/**"))
				.apis(RequestHandlerSelectors.basePackage("com.tcs"))
				.build().apiInfo(apiInformation());
	}
	
	private ApiInfo apiInformation() {
		return new ApiInfo("Shopping User API", "API for User related information", "v1", "No terms mentioned by Creator", new springfox.documentation.service.Contact("Varun Bansal", "URL not available", "vbansal32@gmail.com"), "no License", "email@gmail.com", Collections.EMPTY_LIST);
	}

}
