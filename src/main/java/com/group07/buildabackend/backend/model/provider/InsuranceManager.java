
package com.group07.buildabackend.backend.model.provider;

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

    // Updated method name and references to InsuranceSurveyor
    public void addInsuranceSurveyor(InsuranceSurveyor insuranceSurveyor) {
        if (this.insuranceSurveyors == null) {
            this.insuranceSurveyors = new HashSet<>();
        }
        if (this.insuranceSurveyors.contains(insuranceSurveyor)) {
            return;
        }
        insuranceSurveyors.add(insuranceSurveyor);
        insuranceSurveyor.setInsuranceManager(this);
    }

    // Updated method name and references to InsuranceSurveyor
    public void removeInsuranceSurveyor(InsuranceSurveyor insuranceSurveyor) {
        if (!insuranceSurveyors.contains(insuranceSurveyor))
            return ;
        insuranceSurveyors.remove(insuranceSurveyor);
        insuranceSurveyor.setInsuranceManager(null);
    }


    @Override
    public SystemUserType getDefaultUserType() {
        return SystemUserType.insurance_manager;
    }
}

