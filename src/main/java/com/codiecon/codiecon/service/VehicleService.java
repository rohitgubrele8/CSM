package com.codiecon.codiecon.service;

import com.codiecon.codiecon.models.Response.VehicleDetailsResponse;
import com.codiecon.codiecon.models.entity.VehicleDetails;
import com.codiecon.codiecon.models.request.VehicleDetailsRequest;
import com.codiecon.codiecon.models.vo.VehicleDetailsVo;

import java.util.List;

public interface VehicleService {

  public void saveVehicle(VehicleDetailsRequest vehicleDetailsRequest);

  public List<VehicleDetailsVo> getVehicle(String ownerEmail);
}
