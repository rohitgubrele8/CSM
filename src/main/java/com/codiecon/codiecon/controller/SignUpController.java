package com.codiecon.codiecon.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class SignUpController {



  @RequestMapping(value = "vehicleOwner", method = RequestMethod.POST, consumes = MediaType
      .APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
  public BaseResponse saveBankDetails(
      @Validated @RequestBody BankDetailsRequest bankDetailsRequest) {
    LOGGER.debug("Saving Bank Details with values: {}", bankDetailsRequest.toString());
    userDetailsService.saveBankDetails(bankDetailsRequest);
    return new BaseResponse(true, HttpStatus.OK.value());
  }

}
