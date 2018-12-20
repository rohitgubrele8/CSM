package com.codiecon.codiecon.serviceImpl;

import com.codiecon.codiecon.models.entity.OwnerDetails;
import com.codiecon.codiecon.models.enums.ApplicationStatus;
import com.codiecon.codiecon.models.request.OwnerDetailsRequest;
import com.codiecon.codiecon.models.request.OwnerOtpRequest;
import com.codiecon.codiecon.repository.OwnerDetailsRepository;
import com.codiecon.codiecon.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;


@Service
public class SignUpServiceImpl implements SignUpService {

  private static final int MIN_OTP_RANGE = 1000;
  private static final int MAX_OTP_RANGE = 9999;

  @Autowired
  OwnerDetailsRepository ownerDetailsRepository;

  @Override
  public void driverSignUp() {

  }

  @Override
  public void vehicleOwnerSignUp(OwnerDetailsRequest ownerDetailsRequest) {
    OwnerDetails ownerDetails = new OwnerDetails();
    ownerDetails.setEmail(ownerDetailsRequest.getEmail());
    ownerDetails.setName(ownerDetailsRequest.getName());
    ownerDetails.setContactNumber(ownerDetailsRequest.getContactNumber());
    ownerDetails.setOwnerAddress(ownerDetailsRequest.getOwnerAddress());
    ownerDetails.setZipCode(ownerDetailsRequest.getZipCode());
    ownerDetails.setOtp(Long.valueOf(ThreadLocalRandom.current()
        .nextInt(MIN_OTP_RANGE, MAX_OTP_RANGE + 1)));
    ownerDetails.setStatus(ApplicationStatus.OTP_PENDING);
    ownerDetailsRepository.save(ownerDetails);
    //todo :: send otp in email or phone
  }

  @Override
  public void vehicleOwnerOtpValidation(OwnerOtpRequest ownerOtpRequest){
    OwnerDetails ownerDetails = ownerDetailsRepository.findByEmail(ownerOtpRequest.getEmail());
    if(ownerDetails.getOtp().equals(ownerOtpRequest.getOtp())){
      ownerDetails.setStatus(ApplicationStatus.OTP_VERIFIED);
    }
    ownerDetailsRepository.save(ownerDetails);
  }

  @Override
  public void bookVehicle() {

  }

  @Override
  public void updateVehicleAvailability() {

  }

  @Override
  public void cancelBooking() {

  }

  @Override
  public void uploadVehicleDocuments() {

  }

  @Override
  public void uploadDriverDocuments() {

  }

}
