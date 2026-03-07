package com.tramita.api.repository;

import com.tramita.api.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findByActiveTrue();
}
