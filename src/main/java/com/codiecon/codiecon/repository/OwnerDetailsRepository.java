package com.codiecon.codiecon.repository;

import com.codiecon.codiecon.models.entity.OwnerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerDetailsRepository extends JpaRepository<OwnerDetails,String> {
}
