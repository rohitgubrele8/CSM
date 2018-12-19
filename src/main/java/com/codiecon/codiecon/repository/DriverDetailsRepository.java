package com.codiecon.codiecon.repository;

import com.codiecon.codiecon.models.entity.DriverDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverDetailsRepository extends JpaRepository<DriverDetails,String> {

}
