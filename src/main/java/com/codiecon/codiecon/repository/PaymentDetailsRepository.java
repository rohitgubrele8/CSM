package com.codiecon.codiecon.repository;

import com.codiecon.codiecon.models.entity.OwnerDetails;
import com.codiecon.codiecon.models.entity.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails,String> {

  PaymentDetails findByEmail(String email);
}
