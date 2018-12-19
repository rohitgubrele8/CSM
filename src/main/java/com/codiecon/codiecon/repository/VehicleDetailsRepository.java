package com.codiecon.codiecon.repository;

import com.codiecon.codiecon.models.entity.VehicleDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDetailsRepository extends JpaRepository<VehicleDetails,String> {

}
