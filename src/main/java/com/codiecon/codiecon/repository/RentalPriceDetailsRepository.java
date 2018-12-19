package com.codiecon.codiecon.repository;

import com.codiecon.codiecon.models.entity.RentalPriceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalPriceDetailsRepository extends JpaRepository<RentalPriceDetails,String> {

}
