package com.codiecon.codiecon.serviceImpl;

import java.util.Date;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.codiecon.codiecon.models.Response.BaseResponse;
import com.codiecon.codiecon.models.entity.BookingDetails;
import com.codiecon.codiecon.models.entity.DriverDetails;
import com.codiecon.codiecon.models.entity.PaymentDetails;
import com.codiecon.codiecon.models.entity.RentalPriceDetails;
import com.codiecon.codiecon.models.entity.VehicleDetails;
import com.codiecon.codiecon.models.request.BookingRequest;
import com.codiecon.codiecon.repository.BookingDetailsRepository;
import com.codiecon.codiecon.repository.DriverDetailsRepository;
import com.codiecon.codiecon.repository.PaymentDetailsRepository;
import com.codiecon.codiecon.repository.RentalPriceDetailsRepository;
import com.codiecon.codiecon.repository.VehicleDetailsRepository;
import com.codiecon.codiecon.service.BookingService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingServiceImpl implements BookingService {

  @Autowired
  private BookingDetailsRepository repository;

  @Autowired
  private PaymentDetailsRepository paymentDetailsRepository;

  @Autowired
  private DriverDetailsRepository driverDetailsRepository;

  @Autowired
  private VehicleDetailsRepository vehicleDetailsRepository;

  @Transactional
  @Override
  public boolean bookVehicle(BookingRequest bookingRequest) {
    BookingDetails bookingDetails = new BookingDetails();
    DriverDetails driverDetails = new DriverDetails();
    driverDetails.setId(bookingRequest.getDriverId());
    bookingDetails.setDriverDetails(driverDetails);
    Date date = new Date();
    date.setTime(0);
    date.setHours(0);
    date.setSeconds(0);
    Date tomorrow = new Date();
    tomorrow.setDate(date.getDate() + 1);
    bookingDetails.setDate(tomorrow);
    VehicleDetails vehicleDetails = new VehicleDetails();
    vehicleDetails.setId(bookingRequest.getVehicleId());
    bookingDetails.setVehicleDetails(vehicleDetails);
    repository.saveAndFlush(bookingDetails);
    VehicleDetails vehicleDetails1 = vehicleDetailsRepository.findById(bookingRequest.getVehicleId()).get();
    Hibernate.initialize(vehicleDetails1.getRentalPriceDetails());
    Hibernate.initialize(vehicleDetails1.getOwnerDetails());
    PaymentDetails ownerPaymentDetails = paymentDetailsRepository.findByEmail(vehicleDetails1.getOwnerDetails().getEmail());
    ownerPaymentDetails
        .setAmountOwe(ownerPaymentDetails.getAmountOwe() + vehicleDetails1.getRentalPriceDetails().getRentPerDay());
    paymentDetailsRepository.saveAndFlush(ownerPaymentDetails);
    DriverDetails details = driverDetailsRepository.findById(bookingRequest.getDriverId()).get();
    PaymentDetails driverPaymentDetails = paymentDetailsRepository.findByEmail(details.getEmail());
    driverPaymentDetails
        .setAmountDue(driverPaymentDetails.getAmountDue() + vehicleDetails1.getRentalPriceDetails().getRentPerDay());
    paymentDetailsRepository.saveAndFlush(driverPaymentDetails);
    return true;
  }
}
