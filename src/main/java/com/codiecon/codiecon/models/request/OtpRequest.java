package com.codiecon.codiecon.models.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OtpRequest implements Serializable {
  private static final long serialVersionUID = 1L;
  @NotBlank
  private String email;
  @NotNull
  private Integer otp;
}
