package com.group07.buildabackend.backend.model.provider;

import com.group07.buildabackend.backend.model.SysUser;
import jakarta.persistence.*;

@Entity
@Table(name = "provider")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Provider extends SysUser {
}
