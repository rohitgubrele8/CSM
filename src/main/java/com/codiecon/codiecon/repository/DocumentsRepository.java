package com.codiecon.codiecon.repository;

import com.codiecon.codiecon.models.entity.Documents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentsRepository extends JpaRepository<Documents, String> {
  Documents findByEmail(String email);
}
