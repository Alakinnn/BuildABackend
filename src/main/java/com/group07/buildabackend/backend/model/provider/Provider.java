package com.group07.buildabackend.backend.model.provider;

import com.group07.buildabackend.backend.model.User;
import jakarta.persistence.*;

@Entity
@Table(name = "provider")
@DiscriminatorValue("PROVIDER")

@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "PROVIDER_TYPE")
public abstract class Provider extends User {
}
