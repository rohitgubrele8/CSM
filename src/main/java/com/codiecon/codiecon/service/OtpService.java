package com.codiecon.codiecon.service;

import com.codiecon.codiecon.models.Response.OtpResponse;
import com.codiecon.codiecon.models.entity.Otp;
import com.codiecon.codiecon.models.request.OtpRequest;
import io.swagger.models.auth.In;

public interface OtpService {

  OtpResponse validateOtp(OtpRequest otpRequest);

  void reGenerateOtp(String email);

  Integer GenerateOtp();

  void sendOtp(Integer otp,String email);
}


