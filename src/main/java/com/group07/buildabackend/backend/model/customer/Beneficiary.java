package com.group07.buildabackend.backend.model.customer;

import com.group07.buildabackend.backend.model.insuranceCard.InsuranceCard;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "beneficiary", schema = "public")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Beneficiary extends Customer {
    @ManyToOne
    @JoinColumn(name = "policy_owner_id", referencedColumnName = "user_id")
    private PolicyOwner policyOwner;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_number", referencedColumnName = "card_number")
    private InsuranceCard insuranceCard;

    @Column(name = "beneficiary_type")
    private String beneficiary_type;

    // Other properties, getters, setters, etc.

    public PolicyOwner getPolicyOwner() {
        return policyOwner;
    }
    public String getBeneficiary_type() {
        return beneficiary_type;
    }

    public void setBeneficiary_type(String beneficiary_type) {
        this.beneficiary_type = beneficiary_type;
    }

    public InsuranceCard getInsuranceCard() {
        return insuranceCard;
    }

    public void setInsuranceCard(InsuranceCard insuranceCard) {
        this.insuranceCard = insuranceCard;
    }

    public void setPolicyOwner(PolicyOwner policyOwner) {
        if (sameAsFormer(policyOwner))
            return ;
        PolicyOwner oldPolicyOwner = this.policyOwner;
        this.policyOwner = policyOwner;
        if (oldPolicyOwner!=null)
            oldPolicyOwner.removeBeneficiary(this);
        if (policyOwner!=null)
            policyOwner.addBeneficiary(this);
    }

    private boolean sameAsFormer(PolicyOwner newPolicyOwner) {
        return Objects.equals(policyOwner, newPolicyOwner);
    }
}