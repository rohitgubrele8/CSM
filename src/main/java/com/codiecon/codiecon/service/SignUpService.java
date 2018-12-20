package com.codiecon.codiecon.service;

import com.codiecon.codiecon.models.Response.LoginResponse;
import com.codiecon.codiecon.models.request.LoginRequest;
import com.codiecon.codiecon.models.request.OwnerDetailsRequest;
import com.codiecon.codiecon.models.request.OwnerOtpRequest;
import com.codiecon.codiecon.models.request.SignUpRequest;

public interface SignUpService {

  public void signUp(SignUpRequest signUpRequest);

  public void vehicleOwnerSignUp(OwnerDetailsRequest ownerDetailsRequest);

  public void vehicleOwnerOtpValidation(OwnerOtpRequest ownerOtpRequest);

  public void bookVehicle();

  public void updateVehicleAvailability();

  public void cancelBooking();

  public void uploadVehicleDocuments();

  public void uploadDriverDocuments();

  public LoginResponse login(LoginRequest loginRequest);
}
