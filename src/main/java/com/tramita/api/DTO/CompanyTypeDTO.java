package com.tramita.api.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class CompanyTypeDTO {

    private Long id;
    private String name;
    private String description;
    private Instant createdAt;
    private Instant updatedAt;
    private boolean active;
}
