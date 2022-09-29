package com.example.demo.swagger;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig2 {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths1()).build();
	}

	private Predicate<String> postPaths1() {
		return or(regex("/api/posts.*"), regex("/student.*"),regex("/course.*"));
	}

	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Template API Java SpringBoot")
				.description("Template API ")
				.termsOfServiceUrl("http:8080/api/")
			
				.licenseUrl("netprizm.app").version("netprizm.app 2.0").build();
	}
	
}
