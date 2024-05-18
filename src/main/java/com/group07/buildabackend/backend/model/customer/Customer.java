package com.group07.buildabackend.backend.model.customer;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer", schema = "public")
@PrimaryKeyJoinColumn(referencedColumnName = "user_id")
public abstract class Customer extends SystemUser {
    @OneToMany(orphanRemoval = true, mappedBy = "customer", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<InsuranceClaim> insuranceClaims = new HashSet<>();

    public Set<InsuranceClaim> getInsuranceClaim() {
        return insuranceClaims;
    }

//    Reference for bidirectional, "One" side's setter & remove: https://github.com/SomMeri/org.meri.jpa.tutorial/blob/master/src/main/java/org/meri/jpa/relationships/entities/bestpractice/SafePerson.java
    public void addInsuranceClaim(InsuranceClaim insuranceClaim) {
        if (this.insuranceClaims.contains(insuranceClaim)) {
            return;
        }
        insuranceClaims.add(insuranceClaim);
        insuranceClaim.setCustomer(this);
    }

    public void removeInsuranceClaim(InsuranceClaim insuranceClaim) {
        if (!insuranceClaims.contains(insuranceClaim))
            return ;
        insuranceClaims.remove(insuranceClaim);
        insuranceClaim.setCustomer(null);
    }
}
