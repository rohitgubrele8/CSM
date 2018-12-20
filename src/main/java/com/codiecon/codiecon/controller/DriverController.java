package com.codiecon.codiecon.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.codiecon.codiecon.models.Response.DriverDetailsResponse;
import com.codiecon.codiecon.models.Response.VehicleDetailsResponse;
import com.codiecon.codiecon.models.enums.VehicleType;
import com.codiecon.codiecon.models.request.DriverDetailsRequest;
import com.codiecon.codiecon.models.vo.DriverDetailsVo;
import com.codiecon.codiecon.models.vo.VehicleDetailsVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codiecon.codiecon.models.Response.BaseResponse;
import com.codiecon.codiecon.models.entity.DriverDetails;
import com.codiecon.codiecon.models.entity.VehicleAvailableDates;
import com.codiecon.codiecon.models.entity.VehicleDetails;
import com.codiecon.codiecon.models.enums.DLType;
import com.codiecon.codiecon.models.request.OwnerDetailsRequest;
import com.codiecon.codiecon.service.DriverService;

import io.swagger.annotations.Api;

@Api(value = "DriverController", description = "DriverController")
@RestController
@RequestMapping(value = "/drivers")
public class DriverController {

  @Autowired
  private DriverService driverService;

  @RequestMapping(value = "/save", method = RequestMethod.POST, consumes =
      MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public BaseResponse saveDriverDetails(
      @Validated @RequestBody DriverDetailsRequest driverDetailsRequest) {
    driverService.saveDriverDetails(driverDetailsRequest);
    return new BaseResponse(true, HttpStatus.OK.value());
  }


  @RequestMapping(value = "/details/{email}", method = RequestMethod.GET, consumes =
      MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public DriverDetailsResponse getDriverDetails(@PathVariable("email") String email) {
    DriverDetailsVo driverDetailsVo = driverService.getDriverDetails(email);
    DriverDetailsResponse driverDetailsResponse =
        new DriverDetailsResponse(true, HttpStatus.OK.value(), driverDetailsVo);
    return driverDetailsResponse;
  }

  @RequestMapping(value = "/{driverId}", method = RequestMethod.GET, consumes =
      MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public VehicleDetailsResponse getVehiclesAvailableForTomorrow(
      @PathVariable("driverId") String driverId) {
    Date tommorowStart = new Date();
    tommorowStart.setHours(0);
    tommorowStart.setMinutes(0);
    tommorowStart.setSeconds(0);
    tommorowStart.setDate(tommorowStart.getDate() + 1);
    Date tomorrowEnd = new Date();
    tomorrowEnd.setHours(0);
    tomorrowEnd.setMinutes(0);
    tomorrowEnd.setSeconds(0);
    tomorrowEnd.setDate(tommorowStart.getDate() + 2);

    DriverDetails driverDetails = driverService.findByDriverId(driverId);
    List<VehicleAvailableDates> vehicleAvailableDates =
        driverService.findByAvailabledates(tommorowStart, tomorrowEnd);
    List<VehicleDetails> vehicleDetails = vehicleAvailableDates.stream()
        .map(vehicleAvailableDates1 -> vehicleAvailableDates1.getVehicleDetails())
        .collect(Collectors.toList());
    vehicleDetails = vehicleDetails.stream()
        .filter(vehicleDetails1 -> validate(vehicleDetails1, driverDetails.getDlType()))
        .collect(Collectors.toList());
    List<VehicleDetailsVo> vehicleDetailsVos =
        vehicleDetails.stream().map(vehicleDetails1 -> toVehicleDetailsVo(vehicleDetails1))
            .collect(Collectors.toList());
    return new VehicleDetailsResponse(true, HttpStatus.OK.value(), vehicleDetailsVos);
  }

  private VehicleDetailsVo toVehicleDetailsVo(VehicleDetails vehicleDetails) {
    VehicleDetailsVo vehicleDetailsVo = new VehicleDetailsVo();
    BeanUtils.copyProperties(vehicleDetails, vehicleDetailsVo);
    return vehicleDetailsVo;
  }

  private boolean validate(VehicleDetails vehicleDetails, DLType dlType) {
    switch (dlType) {
      case CAR:
        return VehicleType.CAR.equals(vehicleDetails.getVehicleType());
      case BIKE:
        return VehicleType.BIKE.equals(vehicleDetails.getVehicleType());
      case TRUCK:
        return VehicleType.TRUCK.equals(vehicleDetails.getVehicleType());
      case BIKEANDCAR:
        return (VehicleType.CAR.equals(vehicleDetails.getVehicleType()) || VehicleType.BIKE
            .equals(vehicleDetails.getVehicleType()));
      case CARANDTRUCK:
        return (VehicleType.CAR.equals(vehicleDetails.getVehicleType()) || VehicleType.TRUCK
            .equals(vehicleDetails.getVehicleType()));
      case BIKEANDTRUCK:
        return (VehicleType.TRUCK.equals(vehicleDetails.getVehicleType()) || VehicleType.BIKE
            .equals(vehicleDetails.getVehicleType()));
      case BIKEANDCARANDTRUCK:
        return (VehicleType.CAR.equals(vehicleDetails.getVehicleType()) || VehicleType.BIKE
            .equals(vehicleDetails.getVehicleType())) || VehicleType.TRUCK
            .equals(vehicleDetails.getVehicleType());
      default:
        return false;
    }
  }


}
