package com.codiecon.codiecon.repository;

import java.util.Date;
import java.util.List;

import com.codiecon.codiecon.models.entity.VehicleAvailableDates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleAvailableDatesRepository extends JpaRepository<VehicleAvailableDates,String> {

  List<VehicleAvailableDates> findByDate(@DateTimeFormat(pattern = "dd.MM.yyyy") Date tomorrow);
}
