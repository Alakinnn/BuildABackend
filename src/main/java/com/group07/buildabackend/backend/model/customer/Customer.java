package com.group07.buildabackend.backend.model.customer;

import com.group07.buildabackend.backend.model.User;
import jakarta.persistence.*;

@Entity
@Table(name="Customer")
@DiscriminatorValue("CUSTOMER")

@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "CUSTOMER_TYPE")
public abstract class Customer extends User {
    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

}
