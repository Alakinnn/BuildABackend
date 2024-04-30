package com.group07.buildabackend.backend.model.customer;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "policyOwner")
@DiscriminatorValue("OWNER")
public class PolicyOwner extends Customer {
    @OneToMany(mappedBy = "owner", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PolicyHolder> holders;
}
