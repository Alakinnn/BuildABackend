
package com.group07.buildabackend.backend.model.provider;

import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.utils.userType.AssignUserType;
import jakarta.persistence.*;

@Entity
@Table(name = "provider")
@EntityListeners(AssignUserType.class)
public abstract class Provider extends SystemUser {
    @Column(name = "provider_type")
    private String providerType;

    public String getProviderType() {
        return providerType;
    }

    public void setProviderType(String providerType) {
        this.providerType = providerType;
    }
}