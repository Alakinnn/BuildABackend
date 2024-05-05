
package com.group07.buildabackend.backend.model.provider;

import com.group07.buildabackend.backend.model.SysUser;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "provider")
public abstract class Provider extends SysUser {
    @Id
    private String id;

    @Column(name = "provider_type")
    private String provider_type;
}