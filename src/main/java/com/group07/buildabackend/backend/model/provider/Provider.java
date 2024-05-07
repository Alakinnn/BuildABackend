
package com.group07.buildabackend.backend.model.provider;

import com.group07.buildabackend.backend.model.SysUser;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "provider")
public abstract class Provider extends SysUser {
    @Column(name = "provider_type")
    private String providerType;

    public String getProviderType() {
        return providerType;
    }

    public void setProviderType(String providerType) {
        this.providerType = providerType;
    }
}