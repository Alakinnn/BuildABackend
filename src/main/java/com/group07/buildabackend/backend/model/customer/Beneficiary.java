package com.group07.buildabackend.backend.model.customer;

import com.group07.buildabackend.backend.model.User;
import jakarta.persistence.*;

@Entity
@Table(name = "beneficiary")
@DiscriminatorValue("BENEFICIARY")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "BENECIARY_TYPE")
public abstract class Beneficiary extends Customer {

}
