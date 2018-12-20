package com.codiecon.codiecon.controller;

import com.codiecon.codiecon.models.Response.BaseResponse;
import com.codiecon.codiecon.models.Response.OtpResponse;
import com.codiecon.codiecon.models.request.OtpRequest;
import com.codiecon.codiecon.service.OtpService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@Api(value = "OtpUpController", description = "OtpFlow")
@RestController
@RequestMapping(value = "/otp")
public class OtpController {

  @Autowired
  private OtpService otpService;

  @RequestMapping(value = "/validateOtp", method = RequestMethod.POST, produces =
      MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public OtpResponse validateOtp(@Validated @RequestBody OtpRequest otpRequest) {
    return otpService.validateOtp(otpRequest);
  }

  @RequestMapping(value = "/generateAndSendOtp/{email}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
  public BaseResponse generateAndSendOtp(@PathVariable("email") @NotBlank String email) {
    otpService.reGenerateOtp(email);
    return new BaseResponse(true, HttpStatus.OK.value());
  }

}
