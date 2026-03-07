package com.tramita.api.service.CompanyType;

import com.tramita.api.DTO.CompanyTypeDTO;
import com.tramita.api.exception.ResourceNotFoundException;
import com.tramita.api.models.CompanyType;
import com.tramita.api.repository.CompanyTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyTypeServiceImpl implements CompanyTypeService {

    private final CompanyTypeRepository companyTypeRepository;

    @Override
    public CompanyTypeDTO createCompanyType(CompanyTypeDTO companyTypeDTO) {
        CompanyType companyType = new CompanyType();
        companyType.setName(companyTypeDTO.getName());
        companyType.setDescription(companyTypeDTO.getDescription());
        companyType.setActive(true);
        CompanyType savedCompanyType = companyTypeRepository.save(companyType);
        return entityToDTO(savedCompanyType);
    }

    @Override
    public List<CompanyTypeDTO> findAll() {
        return companyTypeRepository.findByActiveTrue().stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyTypeDTO findById(Long id) {
        CompanyType companyType = companyTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company type not found with id: " + id));
        return entityToDTO(companyType);
    }

    @Override
    public CompanyTypeDTO update(Long id, CompanyTypeDTO companyTypeDTO) {
        CompanyType companyType = companyTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company type not found with id: " + id));
        companyType.setName(companyTypeDTO.getName());
        companyType.setDescription(companyTypeDTO.getDescription());
        CompanyType savedCompanyType = companyTypeRepository.save(companyType);
        return entityToDTO(savedCompanyType);
    }

    @Override
    public void delete(Long id) {
        CompanyType companyType = companyTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company type not found with id: " + id));
        companyType.setActive(false);
        companyTypeRepository.save(companyType);
    }

    private CompanyTypeDTO entityToDTO(CompanyType companyType) {
        CompanyTypeDTO dto = new CompanyTypeDTO();
        dto.setId(companyType.getId());
        dto.setName(companyType.getName());
        dto.setDescription(companyType.getDescription());
        dto.setCreatedAt(companyType.getCreatedAt());
        dto.setUpdatedAt(companyType.getUpdatedAt());
        dto.setActive(companyType.isActive());
        return dto;
    }
}
