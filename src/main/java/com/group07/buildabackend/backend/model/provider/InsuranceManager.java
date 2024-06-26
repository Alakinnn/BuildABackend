package com.group07.buildabackend.backend.model.provider;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.model.SystemUserType;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import jakarta.persistence.*;
import org.hibernate.annotations.Where;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "insurance_manager")
public class InsuranceManager extends Provider {
    @OneToMany
    @Where(clause = "status = 'PROPOSED'")
    private Set<InsuranceClaim> proposedClaims = new HashSet<>();

    public InsuranceManager() {
    }

    public Set<InsuranceClaim> getProposedClaims() {
        return proposedClaims;
    }

    public void setProposedClaims(Set<InsuranceClaim> proposedClaims) {
        this.proposedClaims = proposedClaims;
    }

    // Updated method name and references to InsuranceSurveyor

    @Override
    public SystemUserType getDefaultUserType() {
        return SystemUserType.insurance_manager;
    }
}

