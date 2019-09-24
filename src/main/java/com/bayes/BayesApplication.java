package com.bayes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableJpaAuditing
@EnableSwagger2
public class BayesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BayesApplication.class, args);
	}

	@Bean
	public Docket SwaggerConfig()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.bayes"))
				.build()
			    .apiInfo(apiDetails());

	}

	private ApiInfo apiDetails()
	{
		return new ApiInfo("Overwatch Heroes API",
				"get info about Heroes and abilities",
				"1.0",
				"Free",
				new springfox.documentation.service.Contact("Rashmitha Hebbar","https://github.com/RashmithaHebbar/Bayes","rashmithahebbar@gmail.com")
				,"API License"
				,"https://www.linkedin.com/in/rashmithahebbar/"
				,Collections.emptyList());
	}


}
