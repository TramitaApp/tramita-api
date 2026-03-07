package com.tramita.api.service.CompanyType;

import com.tramita.api.DTO.CompanyTypeDTO;

import java.util.List;

public interface CompanyTypeService {

    CompanyTypeDTO createCompanyType(CompanyTypeDTO companyTypeDTO);

    List<CompanyTypeDTO> findAll();

    CompanyTypeDTO findById(Long id);

    CompanyTypeDTO update(Long id, CompanyTypeDTO companyTypeDTO);

    void delete(Long id);
}
