package com.group07.buildabackend.backend.model.provider;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "InsuranceSurveyor")
@NamedQuery(name = "find surveyor by id", query = "SELECT is FROM InsuranceSurveyor is WHERE is.id=:id")
public class InsuranceSurveyor extends Provider{
}
