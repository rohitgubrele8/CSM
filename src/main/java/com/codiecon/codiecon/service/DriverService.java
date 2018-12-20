package com.codiecon.codiecon.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.xml.crypto.Data;

import com.codiecon.codiecon.models.entity.DriverDetails;
import com.codiecon.codiecon.models.entity.VehicleAvailableDates;
import com.codiecon.codiecon.models.entity.VehicleDetails;
import com.codiecon.codiecon.models.request.DriverDetailsRequest;
import com.codiecon.codiecon.models.vo.DriverDetailsVo;

public interface DriverService {

  DriverDetails findByDriverId(String driverId);

  List<VehicleAvailableDates> findByAvailabledates(Date tomorrowStart, Date tomorrowEnd);

  boolean isNotAvailableForTomorrow(String vehicleId, Date tomorrowStart, Date tomorrowEnd);

  public void saveDriverDetails(DriverDetailsRequest driverDetailsRequest);

  public DriverDetailsVo getDriverDetails(String email);

}
