package com.codiecon.codiecon.controller;

import com.codiecon.codiecon.models.Response.BaseResponse;
import com.codiecon.codiecon.models.Response.VehicleDetailsResponse;
import com.codiecon.codiecon.models.entity.VehicleDetails;
import com.codiecon.codiecon.models.request.OwnerDetailsRequest;
import com.codiecon.codiecon.models.request.VehicleDetailsRequest;
import com.codiecon.codiecon.models.vo.VehicleDetailsVo;
import com.codiecon.codiecon.service.VehicleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@CrossOrigin("*")
@Api(value = "SignUpController", description = "SignUpFlow")
@RestController
@RequestMapping(value = "/vehicle", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
    MediaType.APPLICATION_FORM_URLENCODED_VALUE)
public class vehicleController {

  private static final String EMAIL = "email";

  @Autowired
  private VehicleService vehicleService;


  @RequestMapping(value = "/save", method = RequestMethod.POST, consumes =
      MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public BaseResponse saveVehicleDetails(
      @Validated @RequestBody VehicleDetailsRequest vehicleDetailsRequest) {
    vehicleService.saveVehicle(vehicleDetailsRequest);
    return new BaseResponse(true, HttpStatus.OK.value());
  }

  @RequestMapping(value = "/getList/{email}", method = RequestMethod.GET, consumes =
      MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public VehicleDetailsResponse getVehicleDetails(@PathVariable(EMAIL) String email) {
    List<VehicleDetailsVo> vehicleDetailsVos = vehicleService.getVehicle(email);
    VehicleDetailsResponse vehicleDetailsResponses =
        new VehicleDetailsResponse(true, HttpStatus.OK.value(), vehicleDetailsVos);
    return vehicleDetailsResponses;
  }

}
