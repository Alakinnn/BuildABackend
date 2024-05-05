package com.group07.buildabackend.backend.model.customer;

import com.group07.buildabackend.backend.model.insuranceClaim.Document;
import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "policy_holder", schema = "public")
public class PolicyHolder extends Beneficiary {

    public PolicyHolder() {
    }

    @OneToMany(orphanRemoval = true, mappedBy = "policyHolder",cascade = CascadeType.ALL)
    private Set<Dependent> dependents;

    public Set<Dependent> getDependents() {
        return dependents;
    }

    public void setDependents(Set<Dependent> dependents) {
        this.dependents = dependents;
    }

    //    Reference for bidirectional, "One" side's setter: https://github.com/SomMeri/org.meri.jpa.tutorial/blob/master/src/main/java/org/meri/jpa/relationships/entities/bestpractice/SafePerson.java

    public void addDependent(Dependent dependent) {
        if (this.dependents == null) {
            this.dependents = new HashSet<>();
        }
        if (this.dependents.contains(dependent)) {
            return;
        }
        dependents.add(dependent);
        dependent.setPolicyHolder(this);
    }

    public void removeDependent(Dependent dependent) {
        if (!dependents.contains(dependent))
            return ;
        dependents.remove(dependent);
        dependent.setPolicyHolder(null);
    }


}