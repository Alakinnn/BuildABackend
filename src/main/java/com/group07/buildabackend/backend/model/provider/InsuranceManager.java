package com.group07.buildabackend.backend.model.provider;

import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "InsuranceManager")
public class InsuranceManager extends Provider {
    @OneToMany(targetEntity = InsuranceClaim.class)
    private Set<InsuranceClaim> proposedClaims = new HashSet<>();

    public InsuranceManager() {
    }

    public Set<InsuranceClaim> getProposedClaims() {
        return proposedClaims;
    }

    public void setProposedClaims(Set<InsuranceClaim> proposedClaims) {
        this.proposedClaims = proposedClaims;
    }
}
