package com.codiecon.codiecon.repository;

import com.codiecon.codiecon.models.entity.LoginDetails;
import com.codiecon.codiecon.models.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDetailsRepository extends JpaRepository<LoginDetails, String> {

  LoginDetails findByEmailAndPassword(String userName, String password);

  LoginDetails findByEmail(String email);

}
