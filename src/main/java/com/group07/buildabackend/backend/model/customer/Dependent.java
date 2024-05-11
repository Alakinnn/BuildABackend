package com.group07.buildabackend.backend.model.customer;

import com.group07.buildabackend.backend.model.SystemUserType;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "dependent", schema = "public")
public class Dependent extends Beneficiary {

    @ManyToOne
    @JoinColumn(name = "policy_holder_id", referencedColumnName = "user_id")
    private PolicyHolder policyHolder;

    public PolicyHolder getPolicyHolder() {
        return policyHolder;
    }


    //    Reference for bidirectional, "Many" side's setter: https://github.com/SomMeri/org.meri.jpa.tutorial/blob/master/src/main/java/org/meri/jpa/relationships/entities/bestpractice/SafePerson.java
    public void setPolicyHolder(PolicyHolder policyHolder) {
        if (sameAsFormer(policyHolder))
            return ;
        PolicyHolder oldPolicyHolder = this.policyHolder;
        this.policyHolder = policyHolder;
        if (oldPolicyHolder!=null)
            oldPolicyHolder.removeDependent(this);
        if (policyHolder!=null)
            policyHolder.addDependent(this);
    }

    private boolean sameAsFormer(PolicyHolder newPolicyHolder) {
        return Objects.equals(policyHolder, newPolicyHolder);
    }

    @Override
    public SystemUserType getDefaultUserType() {
        return SystemUserType.dependent;
    }
}
