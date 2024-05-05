package com.group07.buildabackend.backend.model.customer;

import jakarta.persistence.*;

@Entity
@Table(name = "beneficiary", schema = "public")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Beneficiary extends Customer {
    @ManyToOne
    @JoinColumn(name = "policy_owner_id", referencedColumnName = "user_id")
    private PolicyOwner policyOwner;

    @Column(name = "beneficiary_type")
    private String beneficiary_type;

    // Other properties, getters, setters, etc.

    public PolicyOwner getPolicyOwner() {
        return policyOwner;
    }

    public void setPolicyOwner(PolicyOwner policyOwner) {
        this.policyOwner = policyOwner;
    }

    public String getBeneficiary_type() {
        return beneficiary_type;
    }

    public void setBeneficiary_type(String beneficiary_type) {
        this.beneficiary_type = beneficiary_type;
    }
}