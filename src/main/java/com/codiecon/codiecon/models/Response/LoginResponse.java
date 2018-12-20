package com.codiecon.codiecon.models.Response;

import com.codiecon.codiecon.models.entity.LoginDetails;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LoginResponse extends BaseResponse {

  private boolean exist;

  private LoginDetails.UserRole role;

  public LoginResponse(boolean success, int status, boolean exist, LoginDetails.UserRole role) {
    super(success, status);
    this.exist = exist;
    this.role = role;
  }
}

