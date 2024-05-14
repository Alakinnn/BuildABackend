
package com.group07.buildabackend.backend.model.provider;

import com.group07.buildabackend.backend.model.SystemUserType;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "insurance_surveyor")
@NamedQuery(name = "find surveyor by id", query = "SELECT is FROM InsuranceSurveyor is WHERE is.id=:id")
public class InsuranceSurveyor extends Provider{
    @ManyToOne
    @JoinColumn(name = "insurance_manager_id", referencedColumnName = "user_id")
    private InsuranceManager insuranceManager;

    public void setInsuranceManager(InsuranceManager insuranceManager) {
        if (sameAsFormer(insuranceManager))
            return;
        InsuranceManager oldInsuranceManager = this.insuranceManager;
        this.insuranceManager = insuranceManager;
        if (oldInsuranceManager != null)
            oldInsuranceManager.removeInsuranceSurveyor(this);
        if (insuranceManager != null)
            insuranceManager.addInsuranceSurveyor(this);
    }

    private boolean sameAsFormer(InsuranceManager newInsuranceManager) {
        return Objects.equals(insuranceManager, newInsuranceManager);
    }

    @Override
    public SystemUserType getDefaultUserType() {
        return SystemUserType.insurance_surveyor;
    }
}