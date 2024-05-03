package com.group07.buildabackend.backend.model.customer;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "policy_owner", schema = "public")
public class PolicyOwner extends Customer{
    @Column(name = "yearly_rate", nullable = false)
    private double yearlyRate;

    @OneToMany(orphanRemoval = true, mappedBy = "policyOwner", cascade = CascadeType.ALL)
    private Set<Beneficiary> beneficiaries = new HashSet<>();

    // Constructors, getters, setters, etc.

    public Set<Beneficiary> getBeneficiaries() {
        return beneficiaries;
    }

    public void addBeneficiaries(Beneficiary beneficiary) {
        this.beneficiaries.add(beneficiary);
        beneficiary.setPolicyOwner(this);
    }

    public double getYearlyRate() {
        return yearlyRate;
    }

    public void setYearlyRate(double yearlyRate) {
        this.yearlyRate = yearlyRate;
    }


}