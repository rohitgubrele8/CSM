package com.codiecon.codiecon.serviceImpl;

import com.codiecon.codiecon.models.Response.LoginResponse;
import com.codiecon.codiecon.models.entity.LoginDetails;
import com.codiecon.codiecon.models.request.LoginRequest;
import com.codiecon.codiecon.models.request.OwnerDetailsRequest;
import com.codiecon.codiecon.models.request.SignUpRequest;
import com.codiecon.codiecon.repository.DriverDetailsRepository;
import com.codiecon.codiecon.repository.LoginDetailsRepository;
import com.codiecon.codiecon.repository.OwnerDetailsRepository;
import com.codiecon.codiecon.service.SignUpService;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class SignUpServiceImpl implements SignUpService {

  private static final int MIN_OTP_RANGE = 1000;
  private static final int MAX_OTP_RANGE = 9999;

  @Autowired
  OwnerDetailsRepository ownerDetailsRepository;

  @Autowired
  LoginDetailsRepository loginDetailsRepository;

  @Autowired
  DriverDetailsRepository driverDetailsRepository;


  @Override
  public void signUp(SignUpRequest signUpRequest) {

    try {
      LoginDetails loginDetails = new LoginDetails();
      loginDetails.setEmail(signUpRequest.getEmail());
      loginDetails.setPassword(signUpRequest.getPassword());
      loginDetails.setRole(signUpRequest.getRole());
      loginDetails.setName(signUpRequest.getName());
      loginDetailsRepository.save(loginDetails);
    } catch (Exception e) {
      throw new RuntimeException("Duplicate email");
    }
  }


  @Override
  public LoginResponse login(LoginRequest loginRequest) {
    try {
      LoginDetails loginDetails = loginDetailsRepository
          .findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
      Preconditions.checkArgument(Objects.nonNull(loginDetails));
      return new LoginResponse(true, HttpStatus.OK.value(), true, loginDetails.getRole());
    } catch (Exception e) {
      return new LoginResponse(false, HttpStatus.OK.value(), false, null);
    }

  }

}
