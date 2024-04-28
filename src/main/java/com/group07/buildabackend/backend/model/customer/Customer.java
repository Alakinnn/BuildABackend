package com.group07.buildabackend.backend.model.customer;

import com.group07.buildabackend.backend.model.User;
import jakarta.persistence.*;

@Entity
@Table(name="Customer")
public abstract class Customer extends User {

    @Id
    private String id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

}
