package com.tramita.api.repository;

import com.tramita.api.models.CompanyType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyTypeRepository extends JpaRepository<CompanyType, Long> {

    List<CompanyType> findByActiveTrue();
}
