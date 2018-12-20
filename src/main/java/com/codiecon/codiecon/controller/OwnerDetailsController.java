package com.codiecon.codiecon.controller;

import com.codiecon.codiecon.models.Response.BaseResponse;
import com.codiecon.codiecon.models.Response.OwnerDetailsResponse;
import com.codiecon.codiecon.models.request.OwnerDetailsRequest;
import com.codiecon.codiecon.models.vo.OwnerDetailsVo;
import com.codiecon.codiecon.service.OwnerDetailsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@Api(value = "SignUpController", description = "SignUpFlow")
@RestController
@RequestMapping(value = "/vehicleOwner", produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
public class OwnerDetailsController {

  @Autowired
  private OwnerDetailsService ownerDetailsService;


  @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType
      .APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
  public BaseResponse saveVehicleOwnerDetails(
      @Validated @RequestBody OwnerDetailsRequest ownerDetailsRequest) {
    ownerDetailsService.saveOwnerDetails(ownerDetailsRequest);
    return new BaseResponse(true, HttpStatus.OK.value());
  }


  @RequestMapping(value = "/details/{email}", method = RequestMethod.GET, consumes =
      MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public OwnerDetailsResponse getVehicleDetails(@PathVariable("email") String email) {
    OwnerDetailsVo ownerDetailsVo = ownerDetailsService.getOwnerDetails(email);
    OwnerDetailsResponse ownerDetailsResponse =
        new OwnerDetailsResponse(true, HttpStatus.OK.value(), ownerDetailsVo);
    return ownerDetailsResponse;
  }
}
