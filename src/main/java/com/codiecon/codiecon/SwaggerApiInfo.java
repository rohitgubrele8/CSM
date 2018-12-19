package com.codiecon.codiecon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

  @Component
  public class SwaggerApiInfo {

    @Value("${swagger.application.api.title}")
    private String title;

    @Value("${swagger.application.api.description}")
    private String description;

    @Value("${swagger.application.api.termsOfServiceUrl}")
    private String termsOfServiceUrl;

    @Value("${swagger.application.api.contact}")
    private String contact;

    @Value("${swagger.application.api.license}")
    private String license;

    @Value("${swagger.application.api.licenseUrl}")
    private String licenseUrl;

    @Value("${swagger.application.api.email}")
    private String email;

    @Value("${swagger.application.api.version}")
    private String version;

    public String getVersion() {
      return version;
    }

    public void setVersion(String version) {
      this.version = version;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public String getTitle() {
      return title;
    }

    public String getDescription() {
      return description;
    }

    public String getTermsOfServiceUrl() {
      return termsOfServiceUrl;
    }

    public String getContact() {
      return contact;
    }

    public String getLicense() {
      return license;
    }

    public String getLicenseUrl() {
      return licenseUrl;
    }
  }

