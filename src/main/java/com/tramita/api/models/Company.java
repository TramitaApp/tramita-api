package com.tramita.api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Company extends Base {

    @Column(unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "company_type_id")
    private CompanyType companyType;

}