package com.group07.buildabackend.backend.model.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "PolicyHolder")
public class PolicyHolder extends Customer implements Beneficiary {
}
