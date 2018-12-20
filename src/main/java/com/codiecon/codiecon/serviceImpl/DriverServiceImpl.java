package com.codiecon.codiecon.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codiecon.codiecon.models.entity.DriverDetails;
import com.codiecon.codiecon.models.entity.VehicleAvailableDates;
import com.codiecon.codiecon.repository.DriverDetailsRepository;
import com.codiecon.codiecon.repository.VehicleAvailableDatesRepository;
import com.codiecon.codiecon.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {

  @Autowired
  private DriverDetailsRepository driverDetailsRepository;

  @Autowired
  private VehicleAvailableDatesRepository vehicleAvailableDatesRepository;

  @Override
  public DriverDetails findByDriverId(String driverId) {
    return driverDetailsRepository.findById(driverId).get();
  }

  @Override
  public List<VehicleAvailableDates> findByAvailabledates(Date tomorrow) {
    List<VehicleAvailableDates> vehicleAvailableDates = vehicleAvailableDatesRepository.findByDate(tomorrow);
    return vehicleAvailableDates.stream().map(vehicleAvailableDates1 -> initialize(vehicleAvailableDates1))
            .collect(Collectors.toList());
  }

  private VehicleAvailableDates initialize(VehicleAvailableDates vehicleAvailableDates) {
    Hibernate.initialize(vehicleAvailableDates.getVehicleDetails());
    return vehicleAvailableDates;
  }
}
