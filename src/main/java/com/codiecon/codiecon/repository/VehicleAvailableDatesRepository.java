package com.codiecon.codiecon.repository;

import com.codiecon.codiecon.models.entity.VehicleAvailableDates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleAvailableDatesRepository extends JpaRepository<VehicleAvailableDates,String> {

}
