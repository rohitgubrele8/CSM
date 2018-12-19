package com.codiecon.codiecon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codiecon.codiecon.models.entity.LoginDetails;

public interface SignUpRepository extends JpaRepository<LoginDetails, String> {
}
