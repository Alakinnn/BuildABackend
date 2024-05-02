package com.group07.buildabackend.backend.model.customer;

import jakarta.persistence.*;


import java.util.Set;

@Entity
@Table(name = "policy_holder", schema = "public")
public class PolicyHolder extends Beneficiary {

    public PolicyHolder() {
    }

    @OneToMany(orphanRemoval = true, mappedBy = "policyHolder",cascade = CascadeType.ALL)
    private Set<Dependent> dependents;

    public Set<Dependent> getDependents() {
        return dependents;
    }

    public void setDependents(Set<Dependent> dependents) {
        this.dependents = dependents;
    }

}