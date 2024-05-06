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
    private Set<InsuranceClaim> insuranceClaims = new HashSet<>();

    @Column(name = "customer_type")
    private String customerType;

    public Set<InsuranceClaim> getInsuranceClaim() {
        return insuranceClaims;
    }

//    Reference for bidirectional, "One" side's setter & remove: https://github.com/SomMeri/org.meri.jpa.tutorial/blob/master/src/main/java/org/meri/jpa/relationships/entities/bestpractice/SafePerson.java
    public void addInsuranceClaim(InsuranceClaim insuranceClaim) {
        if (this.insuranceClaims.contains(insuranceClaim)) {
            return;
        }
        insuranceClaims.add(insuranceClaim);
        insuranceClaim.setCustomer(this);
    }

    public void removeInsuranceClaim(InsuranceClaim insuranceClaim) {
        if (!insuranceClaims.contains(insuranceClaim))
            return ;
        insuranceClaims.remove(insuranceClaim);
        insuranceClaim.setCustomer(null);
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
}
