package com.tramita.api.service.Company;

import com.tramita.api.DTO.CompanyDTO;
import com.tramita.api.exception.ResourceNotFoundException;
import com.tramita.api.models.Company;
import com.tramita.api.models.CompanyType;
import com.tramita.api.repository.CompanyRepository;
import com.tramita.api.repository.CompanyTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyTypeRepository companyTypeRepository;

    @Override
    public CompanyDTO createCompany(CompanyDTO companyDTO) {
        Company company = new Company();
        company.setName(companyDTO.getName());
        company.setActive(true);
        if (companyDTO.getCompanyTypeId() != null) {
            CompanyType companyType = companyTypeRepository.findById(companyDTO.getCompanyTypeId())
                    .orElseThrow(() -> new ResourceNotFoundException("Company type not found with id: " + companyDTO.getCompanyTypeId()));
            company.setCompanyType(companyType);
        }
        Company savedCompany = companyRepository.save(company);
        return entityToDTO(savedCompany);
    }

    @Override
    public List<CompanyDTO> findAll() {
        return companyRepository.findByActiveTrue().stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyDTO findById(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found with id: " + id));
        return entityToDTO(company);
    }

    @Override
    public CompanyDTO update(Long id, CompanyDTO companyDTO) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found with id: " + id));
        company.setName(companyDTO.getName());
        if (companyDTO.getCompanyTypeId() != null) {
            CompanyType companyType = companyTypeRepository.findById(companyDTO.getCompanyTypeId())
                    .orElseThrow(() -> new ResourceNotFoundException("Company type not found with id: " + companyDTO.getCompanyTypeId()));
            company.setCompanyType(companyType);
        }
        Company savedCompany = companyRepository.save(company);
        return entityToDTO(savedCompany);
    }

    @Override
    public void delete(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found with id: " + id));
        company.setActive(false);
        companyRepository.save(company);
    }

    private CompanyDTO entityToDTO(Company company) {
        CompanyDTO dto = new CompanyDTO();
        dto.setId(company.getId());
        dto.setName(company.getName());
        dto.setCreatedAt(company.getCreatedAt());
        dto.setUpdatedAt(company.getUpdatedAt());
        dto.setActive(company.isActive());
        if (company.getCompanyType() != null) {
            dto.setCompanyTypeId(company.getCompanyType().getId());
            dto.setCompanyType(company.getCompanyType());
        }
        return dto;
    }
}
