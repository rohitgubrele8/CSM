package com.codiecon.codiecon.models.Response;

import com.codiecon.codiecon.models.entity.LoginDetails;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OtpResponse extends BaseResponse {
  private LoginDetails.UserRole role;

  private boolean response;

  public OtpResponse(boolean success, int status, LoginDetails.UserRole role,boolean response) {
    super(success, status);
    this.role = role;
    this.response = response;
  }
}
