
package com.group07.buildabackend.backend.model.provider;

import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaimStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "insurance_manager")
@FilterDef(name = "proposedClaimFilter", parameters = @ParamDef(name = "status", type = InsuranceClaimStatus.class))
public class InsuranceManager extends Provider {
    @OneToMany
    @Filter(name = "proposedClaimFilter", condition = "status = 'PROPOSED'")
    private Set<InsuranceClaim> proposedClaims = new HashSet<>();

    @OneToMany(orphanRemoval = true, mappedBy = "insuranceManager",cascade = CascadeType.ALL)
    private Set<InsuranceSurveyor> insuranceSurveyors;

    public InsuranceManager() {
    }

    public Set<InsuranceClaim> getProposedClaims() {
        return proposedClaims;
    }

    public void setProposedClaims(Set<InsuranceClaim> proposedClaims) {
        this.proposedClaims = proposedClaims;
    }
}

