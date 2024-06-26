package com.group07.buildabackend.backend.model.provider;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.model.SystemUserType;
import jakarta.persistence.*;

@Entity
@Table(name = "insurance_surveyor")
@NamedQuery(name = "find surveyor by id", query = "SELECT is FROM InsuranceSurveyor is WHERE is.id=:id")
public class InsuranceSurveyor extends Provider{

    @Override
    public SystemUserType getDefaultUserType() {
        return SystemUserType.insurance_surveyor;
    }
}