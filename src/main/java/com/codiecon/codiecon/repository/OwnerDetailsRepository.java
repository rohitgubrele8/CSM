package com.codiecon.codiecon.repository;

import com.codiecon.codiecon.models.Response.VehicleDetailsResponse;
import com.codiecon.codiecon.models.entity.OwnerDetails;
import com.codiecon.codiecon.models.entity.VehicleDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerDetailsRepository extends JpaRepository<OwnerDetails,String> {

  String EMAIL = "email";

  OwnerDetails findByEmail(String email);
//
//  @Query(value = "SELECT NEW com.codiecon.codiecon.models.Response.VehicleDetailsResponse(VD.vehicleNumber, "
//      + "VD.vehicleType , VD.vehicleModel , VD.insuranceNumber) FROM  VehicleDetails VD WHERE VD"
//      + ".ownerDetails.email = :email")
  @Query(value = "SELECT V FROM VehicleDetails V WHERE V.ownerDetails.email = :email")
  List<VehicleDetails> findVehiclesByOwnerEmail(@Param(EMAIL)String email);
}
