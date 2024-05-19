package com.group07.buildabackend.backend.model.customer;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.model.SystemUserType;
import jakarta.persistence.*;

import java.util.HashSet;
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

    public void addBeneficiary(Beneficiary beneficiary) {
        if (this.beneficiaries == null) {
            this.beneficiaries = new HashSet<>();
        }
        if (this.beneficiaries.contains(beneficiary)) {
            return;
        }
        beneficiaries.add(beneficiary);
        beneficiary.setPolicyOwner(this);
    }

    public void removeBeneficiary(Beneficiary beneficiary) {
        if (!beneficiaries.contains(beneficiary))
            return ;
        beneficiaries.remove(beneficiary);
        beneficiary.setPolicyOwner(null);
    }

    public double getYearlyRate() {
        return yearlyRate;
    }

    public void setYearlyRate(double yearlyRate) {
        this.yearlyRate = yearlyRate;
    }

    @Override
    public SystemUserType getDefaultUserType() {
        return SystemUserType.policy_owner;
    }
}