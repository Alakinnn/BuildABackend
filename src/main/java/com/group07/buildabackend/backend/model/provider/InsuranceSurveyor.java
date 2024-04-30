package com.group07.buildabackend.backend.model.provider;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "insuranceSurveyor")
@DiscriminatorValue("SURVEYOR")
public class InsuranceSurveyor extends Provider{
}
