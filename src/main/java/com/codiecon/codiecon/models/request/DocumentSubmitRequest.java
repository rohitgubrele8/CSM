package com.codiecon.codiecon.models.request;

import com.codiecon.codiecon.models.enums.DocumentType;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class DocumentSubmitRequest {
  @NotBlank
  private String email;

  @NotNull
  private MultipartFile image;

  @NotBlank DocumentType documentType;
}
