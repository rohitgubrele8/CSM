package com.codiecon.codiecon.serviceImpl;

import com.codiecon.codiecon.models.Response.VehicleDetailsResponse;
import com.codiecon.codiecon.models.entity.OwnerDetails;
import com.codiecon.codiecon.models.entity.VehicleDetails;
import com.codiecon.codiecon.models.request.VehicleDetailsRequest;
import com.codiecon.codiecon.models.vo.VehicleDetailsVo;
import com.codiecon.codiecon.repository.OwnerDetailsRepository;
import com.codiecon.codiecon.repository.RentalPriceDetailsRepository;
import com.codiecon.codiecon.repository.VehicleDetailsRepository;
import com.codiecon.codiecon.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

  @Autowired
  private VehicleDetailsRepository vehicleDetailsRepository;

  @Autowired
  private OwnerDetailsRepository ownerDetailsRepository;

  @Autowired
  private RentalPriceDetailsRepository rentalPriceDetailsRepository;


  @Override
  @Transactional
  public void saveVehicle(VehicleDetailsRequest vehicleDetailsRequest) {
    VehicleDetails vehicleDetails = new VehicleDetails();
    vehicleDetails.setVehicleNumber(vehicleDetailsRequest.getVehicleNumber());
    vehicleDetails.setVehicleType(vehicleDetailsRequest.getVehicleType());
    vehicleDetails.setVehicleModel(vehicleDetailsRequest.getVehicleModel());
    vehicleDetails.setInsuranceNumber(vehicleDetailsRequest.getInsuranceNumber());
    vehicleDetails
        .setOwnerDetails(ownerDetailsRepository.findByEmail(vehicleDetailsRequest.getOwnerEmail()));
    vehicleDetails.setRentalPriceDetails(
        rentalPriceDetailsRepository.findByVehicleType(vehicleDetailsRequest.getVehicleType()));
    vehicleDetailsRepository.save(vehicleDetails);
  }

  @Override
  @Transactional(readOnly = true)
  public List<VehicleDetailsVo> getVehicle(String ownerEmail) {
    List<VehicleDetails> vehicleDetailsList =
        ownerDetailsRepository.findVehiclesByOwnerEmail(ownerEmail);
    List<VehicleDetailsVo> vehicleDetailsVos = new ArrayList<>();
    for(VehicleDetails vehicleDetails: vehicleDetailsList){
      VehicleDetailsVo vehicleDetailsVo = new VehicleDetailsVo();
      vehicleDetailsVo.setVehicleNumber(vehicleDetails.getVehicleNumber());
      vehicleDetailsVo.setInsuranceNumber(vehicleDetails.getInsuranceNumber());
      vehicleDetailsVo.setVehicleType(vehicleDetails.getVehicleType());
      vehicleDetailsVo.setVehicleModel(vehicleDetails.getVehicleModel());
      vehicleDetailsVos.add(vehicleDetailsVo);
    }
    return vehicleDetailsVos;
  }


}
