package com.codiecon.codiecon.serviceImpl;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.codiecon.codiecon.models.entity.OwnerDetails;
import com.codiecon.codiecon.models.entity.PaymentDetails;
import com.codiecon.codiecon.models.entity.VehicleAvailableDates;
import com.codiecon.codiecon.models.entity.VehicleDetails;
import com.codiecon.codiecon.models.enums.ApplicationStatus;
import com.codiecon.codiecon.models.request.OwnerDetailsRequest;
import com.codiecon.codiecon.models.request.VehicleAvailabilityRequest;
import com.codiecon.codiecon.models.vo.OwnerDetailsVo;
import com.codiecon.codiecon.models.vo.PaymentDetailsVo;
import com.codiecon.codiecon.repository.OwnerDetailsRepository;
import com.codiecon.codiecon.repository.PaymentDetailsRepository;
import com.codiecon.codiecon.repository.VehicleAvailableDatesRepository;
import com.codiecon.codiecon.repository.VehicleDetailsRepository;
import com.codiecon.codiecon.service.OwnerDetailsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class OwnerDetailsServiceImpl implements OwnerDetailsService {

  @Autowired
  private OwnerDetailsRepository ownerDetailsRepository;

  @Autowired
  private PaymentDetailsRepository paymentDetailsRepository;

  @Autowired
  private VehicleAvailableDatesRepository vehicleAvailableDatesRepository;

  @Autowired
  private VehicleDetailsRepository vehicleDetailsRepository;

  @Override
  @Transactional
  public void saveOwnerDetails(OwnerDetailsRequest ownerDetailsRequest) {

    OwnerDetails ownerDetails = new OwnerDetails();
    ownerDetails.setEmail(ownerDetailsRequest.getEmail());
    ownerDetails.setName(ownerDetailsRequest.getName());
    ownerDetails.setContactNumber(ownerDetailsRequest.getContactNumber());
    ownerDetails.setOwnerAddress(ownerDetailsRequest.getOwnerAddress());
    ownerDetails.setZipCode(ownerDetailsRequest.getZipCode());
    ownerDetails.setStatus(ApplicationStatus.DOCUMENTS_SUBMITTED);
    ownerDetailsRepository.save(ownerDetails);
    PaymentDetails paymentDetails = new PaymentDetails();
    paymentDetails.setBankAccountNumber(
        ownerDetailsRequest.getPaymentDetailsRequest().getBankAccountNumber());
    paymentDetails.setBankName(ownerDetailsRequest.getPaymentDetailsRequest().getBankName());
    paymentDetails.setBranchName(ownerDetailsRequest.getPaymentDetailsRequest().getBranchName());
    paymentDetails.setEmail(ownerDetailsRequest.getEmail());
    paymentDetailsRepository.save(paymentDetails);
  }

  @Override
  @Transactional
  public OwnerDetailsVo getOwnerDetails(String email) {
    OwnerDetails ownerDetails = ownerDetailsRepository.findByEmail(email);
    PaymentDetails paymentDetails = paymentDetailsRepository.findByEmail(email);
    OwnerDetailsVo ownerDetailsVo = new OwnerDetailsVo();
    PaymentDetailsVo paymentDetailsVo = new PaymentDetailsVo();
    paymentDetailsVo.setBranchName(paymentDetails.getBranchName());
    paymentDetailsVo.setBankName(paymentDetails.getBankName());
    paymentDetailsVo.setBankAccountNumber(paymentDetails.getBankAccountNumber());
    ownerDetailsVo.setEmail(email);
    ownerDetailsVo.setOwnerId(ownerDetails.getId());
    ownerDetailsVo.setContactNumber(ownerDetails.getContactNumber());
    ownerDetailsVo.setName(ownerDetails.getEmail());
    ownerDetailsVo.setOwnerAddress(ownerDetails.getOwnerAddress());
    ownerDetailsVo.setZipCode(ownerDetails.getZipCode());
    ownerDetailsVo.setPaymentDetailsVo(paymentDetailsVo);
    return ownerDetailsVo;
  }

  @Transactional
  @Override
  public void saveVehicleAvailability(VehicleAvailabilityRequest vehicleAvailabilityRequest) {
    VehicleDetails vehicleDetails =
        vehicleDetailsRepository.findById(vehicleAvailabilityRequest.getVehicleId()).get();

    String availibilityCode = vehicleAvailabilityRequest.getAvailabilityCode();
    int index;
    Date date = new Date();
    date.setHours(10);
    date.setMinutes(0);
    date.setSeconds(0);
    for(index = 0; index<7; index++){
      date.setDate(date.getDate() + 1);
      Date date1 = new Date();
      BeanUtils.copyProperties(date,date1);
      if(availibilityCode.substring(index,index+1).equals("1")){
        VehicleAvailableDates vehicleAvailableDates = new VehicleAvailableDates();
        vehicleAvailableDates.setVehicleDetails(vehicleDetails);
        vehicleAvailableDates.setDate(date1);
        vehicleAvailableDatesRepository.saveAndFlush(vehicleAvailableDates);
      }
    }

  }

}
