package com.group07.buildabackend.backend.model.customer;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "policyHolder")
@DiscriminatorValue("HOLDER")
public class PolicyHolder extends Beneficiary {
    @OneToMany(mappedBy = "holder", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Dependent> dependents;
}
