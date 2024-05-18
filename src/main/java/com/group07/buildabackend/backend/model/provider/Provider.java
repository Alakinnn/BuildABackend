package com.group07.buildabackend.backend.model.provider;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.model.SystemUser;
import jakarta.persistence.*;

@Entity
@Table(name = "provider")
public abstract class Provider extends SystemUser {
}