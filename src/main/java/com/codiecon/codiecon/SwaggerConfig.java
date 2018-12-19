package com.codiecon.codiecon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  public static final String SWAGGER_APPLICATION_PREFIX = "swagger.application.api.";

  @Autowired
  private SwaggerApiInfo swaggerApiInfo;

  @Value("${application.base.path.location}")
  private String appBasePathLocation;

  public ApiInfo apiInfo() {
    return new ApiInfo(swaggerApiInfo.getTitle(), swaggerApiInfo.getDescription(),swaggerApiInfo.getVersion(),
        swaggerApiInfo.getTermsOfServiceUrl(), new Contact(swaggerApiInfo.getContact(),swaggerApiInfo.getLicenseUrl(),swaggerApiInfo.getEmail()),
        swaggerApiInfo.getLicense(), swaggerApiInfo.getLicenseUrl());
  }

  @Bean
  public Docket onboardingSwaggerApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select().apis(RequestHandlerSelectors.basePackage("com.gdn.tms.onboarding"))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(apiInfo());
  }

}
