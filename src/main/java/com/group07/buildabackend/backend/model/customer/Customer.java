package com.group07.buildabackend.backend.model.customer;
import com.group07.buildabackend.backend.model.SysUser;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "customer", schema = "public")
@PrimaryKeyJoinColumn(referencedColumnName = "user_id")
public abstract class Customer extends SysUser {
    @OneToMany(orphanRemoval = true, mappedBy = "customer", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<InsuranceClaim> insuranceClaim = new HashSet<>();
}
