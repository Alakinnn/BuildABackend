
package com.group07.buildabackend.backend.model.provider;

import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import jakarta.persistence.*;

@Entity
@Table(name = "insurance_surveyor")
@NamedQuery(name = "find surveyor by id", query = "SELECT is FROM InsuranceSurveyor is WHERE is.id=:id")
public class InsuranceSurveyor extends Provider{
    @ManyToOne
    @JoinColumn(name = "insurance_manager_id", referencedColumnName = "user_id")
    private InsuranceManager insuranceManager;
}