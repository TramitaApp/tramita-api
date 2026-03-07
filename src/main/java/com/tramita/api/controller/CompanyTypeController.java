package com.tramita.api.controller;

import com.tramita.api.DTO.CompanyTypeDTO;
import com.tramita.api.service.CompanyType.CompanyTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/company-types")
public class CompanyTypeController {

    private final CompanyTypeService companyTypeService;

    public CompanyTypeController(CompanyTypeService companyTypeService) {
        this.companyTypeService = companyTypeService;
    }

    @PostMapping
    public ResponseEntity<CompanyTypeDTO> createCompanyType(@RequestBody CompanyTypeDTO companyTypeDTO) {
        CompanyTypeDTO createdCompanyType = companyTypeService.createCompanyType(companyTypeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCompanyType);
    }

    @GetMapping
    public ResponseEntity<List<CompanyTypeDTO>> findAll() {
        List<CompanyTypeDTO> companyTypes = companyTypeService.findAll();
        return ResponseEntity.ok(companyTypes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyTypeDTO> findById(@PathVariable Long id) {
        CompanyTypeDTO companyType = companyTypeService.findById(id);
        return ResponseEntity.ok(companyType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyTypeDTO> update(@PathVariable Long id, @RequestBody CompanyTypeDTO companyTypeDTO) {
        CompanyTypeDTO updatedCompanyType = companyTypeService.update(id, companyTypeDTO);
        return ResponseEntity.ok(updatedCompanyType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        companyTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
