package com.codiecon.codiecon.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
import com.codiecon.codiecon.models.request.OwnerDetailsRequest;
import com.codiecon.codiecon.service.DriverService;

import io.swagger.annotations.Api;

@Api(value = "DriverController", description = "DriverController")
@RestController
@RequestMapping(value = "/drivers")
public class DriverController {

  @Autowired
  private DriverService driverService;

  @RequestMapping(value = "/{driverId}", method = RequestMethod.GET, consumes = MediaType
      .APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
  public List<VehicleDetails> getVehiclesAvailableForTomorrow(@PathVariable("driverId") String driverId) {
//    SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
//    Calendar calendar = Calendar.getInstance();
//    calendar.setTime(new Date());
//    calendar.add(Calendar.DATE , 1);
//    calendar.set(11,0);
//    calendar.set(13,0);
//    calendar.set(14,0);
//    calendar.add(Calendar.MINUTE, -1);
//    Date tommorowStart = calendar.getTime();
//    calendar.add(Calendar.DATE , 1);
//    Date tomorrowEnd = calendar.getTime();
    Date tommorowStart = new Date();
    tommorowStart.setHours(0);
    tommorowStart.setMinutes(0);
    tommorowStart.setSeconds(0);
    tommorowStart.setDate(tommorowStart.getDate()+1);
    Date tomorrowEnd = new Date();
    tomorrowEnd.setHours(0);
    tomorrowEnd.setMinutes(0);
    tomorrowEnd.setSeconds(0);
    tomorrowEnd.setDate(tommorowStart.getDate()+2);

    DriverDetails driverDetails = driverService.findByDriverId(driverId);
    List<VehicleAvailableDates> vehicleAvailableDates = driverService.findByAvailabledates(tommorowStart,tomorrowEnd);
    List<VehicleDetails> vehicleDetails =
        vehicleAvailableDates.stream().map(vehicleAvailableDates1 -> vehicleAvailableDates1.getVehicleDetails())
            .collect(Collectors.toList());
//    vehicleDetails = vehicleDetails.stream().filter(vehicleDetails1 -> vehicleDetails1.getVehicleType().)
    return vehicleDetails;
  }
}