package com.group07.buildabackend.backend.model.customer;

import jakarta.persistence.*;

@Entity
@Table(name = "dependent")
@DiscriminatorValue("DEPENDENT")
public class Dependent extends Beneficiary {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HOLDER_ID")
    private PolicyHolder policyHolder;
}
