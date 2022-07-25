package com.epam.libraryservice.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final Logger LOG = LoggerFactory.getLogger(SwaggerConfig.class);

	public Docket api() {
		LOG.info("SwaggerConfig Docket api");
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.epam.libraryservice"))
				.build()
				.apiInfo(getapiInfo());
	}

	private ApiInfo getapiInfo() {
		return new ApiInfoBuilder()
				.title("Book Aplication")
				.description("Book Data")
				.build();
	}

}
