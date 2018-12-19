package com.codiecon.codiecon.service;

import com.codiecon.codiecon.models.request.OwnerDetailsRequest;
import com.codiecon.codiecon.models.request.OwnerOtpRequest;

public interface SignUpService {

  public void driverSignUp();

  public void vehicleOwnerSignUp(OwnerDetailsRequest ownerDetailsRequest);

  public void vehicleOwnerOtpValidation(OwnerOtpRequest ownerOtpRequest);

  public void bookVehicle();

  public void updateVehicleAvailability();

  public void cancelBooking();

  public void uploadVehicleDocuments();

  public void uploadDriverDocuments();
}
