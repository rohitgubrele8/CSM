package com.codiecon.codiecon.models.request;

import com.codiecon.codiecon.models.entity.LoginDetails;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SignUpRequest {

  private String email;

  private String name;

  private String password;

  private LoginDetails.UserRole role;

}
