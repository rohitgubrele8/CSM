package com.codiecon.codiecon.serviceImpl;

import com.codiecon.codiecon.models.entity.OwnerDetails;
import com.codiecon.codiecon.models.entity.PaymentDetails;
import com.codiecon.codiecon.models.enums.ApplicationStatus;
import com.codiecon.codiecon.models.request.OwnerDetailsRequest;
import com.codiecon.codiecon.models.vo.OwnerDetailsVo;
import com.codiecon.codiecon.models.vo.PaymentDetailsVo;
import com.codiecon.codiecon.repository.OwnerDetailsRepository;
import com.codiecon.codiecon.repository.PaymentDetailsRepository;
import com.codiecon.codiecon.service.OwnerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class OwnerDetailsServiceImpl implements OwnerDetailsService {

  @Autowired
  private OwnerDetailsRepository ownerDetailsRepository;

  @Autowired
  private PaymentDetailsRepository paymentDetailsRepository;

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


}
