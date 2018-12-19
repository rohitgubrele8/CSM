package com.codiecon.codiecon.repository;

import com.codiecon.codiecon.models.entity.LoginDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDetailsRepository extends JpaRepository<LoginDetails,String> {

}
