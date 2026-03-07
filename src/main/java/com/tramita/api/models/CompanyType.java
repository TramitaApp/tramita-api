package com.tramita.api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class CompanyType extends Base {

    @Column(unique = true)
    private String name;

    private String description;

    @OneToMany(mappedBy = "companyType")
    private List<Company> companies;

}