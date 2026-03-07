package com.tramita.api.DTO;

import com.tramita.api.models.CompanyType;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class CompanyDTO {

    private Long id;
    private String name;
    private Long companyTypeId;
    private CompanyType companyType;
    private Instant createdAt;
    private Instant updatedAt;
    private boolean active;
}
