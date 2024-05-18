package com.group07.buildabackend.backend.model.systemAdmin;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.SystemUserType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "system_admin")
public class SystemAdmin extends SystemUser {
    public SystemAdmin() {
    }
    @Override
    protected SystemUserType getDefaultUserType() {
        return SystemUserType.system_admin;
    }
}
