package com.codiecon.codiecon.controller;


import com.codiecon.codiecon.models.Response.BaseResponse;
import com.codiecon.codiecon.models.entity.LoginDetails;
import com.codiecon.codiecon.models.request.OwnerDetailsRequest;
import com.codiecon.codiecon.models.Response.LoginResponse;
import com.codiecon.codiecon.models.request.LoginRequest;
import com.codiecon.codiecon.models.request.SignUpRequest;
import com.codiecon.codiecon.service.SignUpService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@Api(value = "SignUpController", description = "SignUpFlow")
@RestController
@RequestMapping(value = "/signUp")
public class SignUpController {


  @Autowired
  private SignUpService signUpService;
//
//  @Deprecated
//  @RequestMapping(value = "/vehicleOwner", method = RequestMethod.POST, consumes = MediaType
//      .APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
//  public BaseResponse saveVehicleOwnerDetails(
//      @Validated @RequestBody OwnerDetailsRequest ownerDetailsRequest) {
//    signUpService.vehicleOwnerSignUp(ownerDetailsRequest);
//    return new BaseResponse(true, HttpStatus.OK.value());
//  }

//  @Deprecated
//  @RequestMapping(value = "validateOwnerOtp", method = RequestMethod.POST, produces = MediaType
//      .APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//  public BaseResponse validateOwnerOtp(@Validated @RequestBody OwnerOtpRequest otpRequest) {
//    signUpService.vehicleOwnerOtpValidation(otpRequest);
//    return new BaseResponse(true, HttpStatus.OK.value());
//  }

}
