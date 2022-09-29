/*
 * package com.example.demo.swagger;
 * 
 * 
 * import java.util.function.Predicate;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration;
 * 
 * import com.spring4all.swagger.PathSelectors;
 * 
 * import springfox.documentation.builders.RequestHandlerSelectors; import
 * springfox.documentation.spi.DocumentationType; import
 * springfox.documentation.spring.web.plugins.Docket; import
 * springfox.documentation.swagger2.annotations.EnableSwagger2;
 * 
 * @Configuration
 * 
 * @EnableSwagger2 public class SwaggerConfig{
 * 
 * @Bean public Docket api() { return new Docket(DocumentationType.SWAGGER_2)
 * .select() .apis(RequestHandlerSelectors.any()) .paths(PathSelectors.any())
 * .paths(Predicate.not(PathSelectors.regex("/error.*"))) .build(); }
 * 
 * }
 */
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import static springfox.documentation.builders.PathSelectors.regex;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
//    //@Autowired
//    // NOTE: Auto wire does not work here so using default values
//   // private Props props = new Props();
//
//    @Bean
//    public Docket productApi() {
//        return new Docket(DocumentationType.SWAGGER_2).groupName("Course")//.apiInfo(apiInfo())
//                //.useDefaultResponseMessages(false) // Allows you to document your own response codes for each request via @ApiResponses
//                .select()
//                .paths(regex("/student.*"))//paths(regex("/course.*"))
//                //.paths(PathSelectors.any())
//             //   .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
//                .build()
//                .apiInfo(apiInfo());
//    }
//   
//   
//
//    private ApiInfo apiInfo() {
//		/*
//		 * String version = props.getVersion(); String name = props.getName(); String
//		 * desc = props.getDescription();
//		 */
//
//      //  String title = String.format("%s REST API - Version: %s", name, version).trim();
//        return new ApiInfoBuilder()
//                .title("Coursess for Student")
//                .description("Course Api and Student Api")
//                //.version(version)
//               // .termsOfServiceUrl("")
//                .build();
//    }
//}

