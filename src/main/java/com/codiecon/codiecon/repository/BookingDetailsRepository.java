package com.codiecon.codiecon.repository;

import java.util.Date;

import com.codiecon.codiecon.models.entity.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDetailsRepository extends JpaRepository<BookingDetails,String> {

  boolean existsByVehicleIdAndBookingDateBetween(String vehicleId, @DateTimeFormat(pattern = "dd.MM.yyyy") Date startDate,
      @DateTimeFormat(pattern = "dd.MM.yyyy") Date endDate);
}
