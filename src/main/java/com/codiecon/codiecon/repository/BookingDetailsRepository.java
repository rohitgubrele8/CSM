package com.codiecon.codiecon.repository;

import com.codiecon.codiecon.models.entity.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDetailsRepository extends JpaRepository<BookingDetails,String> {


}
