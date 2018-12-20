package com.codiecon.codiecon.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.xml.crypto.Data;

import com.codiecon.codiecon.models.entity.DriverDetails;
import com.codiecon.codiecon.models.entity.VehicleAvailableDates;

public interface DriverService {

  DriverDetails findByDriverId(String driverId);

  List<VehicleAvailableDates> findByAvailabledates(Date tomorrowStart, Date tomorrowEnd);
}
