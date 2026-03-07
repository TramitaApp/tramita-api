package com.tramita.api.service.Company;

import com.tramita.api.DTO.CompanyDTO;

import java.util.List;

public interface CompanyService {

    CompanyDTO createCompany(CompanyDTO companyDTO);

    List<CompanyDTO> findAll();

    CompanyDTO findById(Long id);

    CompanyDTO update(Long id, CompanyDTO companyDTO);

    void delete(Long id);
}