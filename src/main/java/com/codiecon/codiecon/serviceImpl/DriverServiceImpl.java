package com.codiecon.codiecon.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.codiecon.codiecon.models.entity.PaymentDetails;
import com.codiecon.codiecon.models.request.DriverDetailsRequest;
import com.codiecon.codiecon.models.vo.DriverDetailsVo;
import com.codiecon.codiecon.models.vo.PaymentDetailsVo;
import com.codiecon.codiecon.repository.BookingDetailsRepository;
import com.codiecon.codiecon.repository.PaymentDetailsRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codiecon.codiecon.models.entity.DriverDetails;
import com.codiecon.codiecon.models.entity.VehicleAvailableDates;
import com.codiecon.codiecon.repository.DriverDetailsRepository;
import com.codiecon.codiecon.repository.VehicleAvailableDatesRepository;
import com.codiecon.codiecon.service.DriverService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DriverServiceImpl implements DriverService {

  @Autowired
  private DriverDetailsRepository driverDetailsRepository;

  @Autowired
  private VehicleAvailableDatesRepository vehicleAvailableDatesRepository;

  @Autowired
  private PaymentDetailsRepository paymentDetailsRepository;

  @Autowired
  private BookingDetailsRepository bookingDetailsRepository;

  @Override
  public DriverDetails findByDriverId(String driverId) {
    return driverDetailsRepository.findById(driverId).get();
  }

  @Override
  public boolean isAvailableForTomorrow(String vehicleId, Date tomorrowStart, Date tomorrowEnd) {
    return bookingDetailsRepository.existsByVehicleIdAndBookingDateBetween(vehicleId, tomorrowStart, tomorrowEnd);
  }

  @Override
  public List<VehicleAvailableDates> findByAvailabledates(Date tomorrowStart, Date tomorrowEnd) {
    List<VehicleAvailableDates> vehicleAvailableDates =
        vehicleAvailableDatesRepository.findAllByDateBetween(tomorrowStart, tomorrowEnd);
    return vehicleAvailableDates.stream()
        .map(vehicleAvailableDates1 -> initialize(vehicleAvailableDates1))
        .collect(Collectors.toList());
  }


  private VehicleAvailableDates initialize(VehicleAvailableDates vehicleAvailableDates) {
    Hibernate.initialize(vehicleAvailableDates.getVehicleDetails());
    return vehicleAvailableDates;
  }


  @Override
  @Transactional
  public void saveDriverDetails(DriverDetailsRequest driverDetailsRequest) {
    DriverDetails driverDetails = new DriverDetails();
    driverDetails.setEmail(driverDetailsRequest.getEmail());
    driverDetails.setName(driverDetailsRequest.getName());
    driverDetails.setDlNumber(driverDetailsRequest.getDlNumber());
    driverDetails.setDlType(driverDetailsRequest.getDlType());
    driverDetails.setContactNumber(driverDetailsRequest.getContactNumber());
    driverDetailsRepository.save(driverDetails);
    PaymentDetails paymentDetails = new PaymentDetails();
    paymentDetails.setBankAccountNumber(
        driverDetailsRequest.getPaymentDetailsRequest().getBankAccountNumber());
    paymentDetails.setBankName(driverDetailsRequest.getPaymentDetailsRequest().getBankName());
    paymentDetails.setBranchName(driverDetailsRequest.getPaymentDetailsRequest().getBranchName());
    paymentDetails.setEmail(driverDetailsRequest.getEmail());
    paymentDetailsRepository.save(paymentDetails);

  }


  @Override
  @Transactional
  public DriverDetailsVo getDriverDetails(String email) {
    DriverDetails driverDetails = driverDetailsRepository.findByEmail(email);
    PaymentDetails paymentDetails = paymentDetailsRepository.findByEmail(email);
    DriverDetailsVo driverDetailsVo = new DriverDetailsVo();
    PaymentDetailsVo paymentDetailsVo = new PaymentDetailsVo();
    paymentDetailsVo.setBranchName(paymentDetails.getBranchName());
    paymentDetailsVo.setBankName(paymentDetails.getBankName());
    paymentDetailsVo.setBankAccountNumber(paymentDetails.getBankAccountNumber());
    driverDetailsVo.setEmail(email);
    driverDetailsVo.setContactNumber(driverDetails.getContactNumber());
    driverDetailsVo.setName(driverDetails.getEmail());
    driverDetailsVo.setDlNumber(driverDetails.getDlNumber());
    driverDetailsVo.setDlType(driverDetails.getDlType());
    driverDetailsVo.setPaymentDetailsVo(paymentDetailsVo);
    return driverDetailsVo;
  }


}
