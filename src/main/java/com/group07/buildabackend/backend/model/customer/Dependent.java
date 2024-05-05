package com.group07.buildabackend.backend.model.customer;

import jakarta.persistence.*;

@Entity
@Table(name = "dependent", schema = "public")
public class Dependent extends Beneficiary {

    @ManyToOne
    @JoinColumn(name = "policy_holder_id", referencedColumnName = "user_id")
    private PolicyHolder policyHolder;

    public PolicyHolder getPolicyHolder() {
        return policyHolder;
    }

    public void setPolicyHolder(PolicyHolder policyHolder) {
        this.policyHolder = policyHolder;
    }
}
