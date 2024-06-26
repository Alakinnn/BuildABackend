package com.group07.buildabackend.backend.model;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.model.userAction.UserAction;
import com.group07.buildabackend.backend.utils.idGenerator.CustomIDGenerator;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "system_user", schema = "public")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class SystemUser {
    @Id
    @GenericGenerator(
            name = CustomIDGenerator.GENERATOR_NAME,
            strategy = "com.group07.buildabackend.backend.utils.idGenerator.CustomIDGenerator",
            parameters = {@org.hibernate.annotations.Parameter(name = CustomIDGenerator.PREFIX_PARAM, value = "u_")})
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = CustomIDGenerator.GENERATOR_NAME)
    @Column(name = "user_id")
    private String userId;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Credentials credentials;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type", nullable = false)
    private SystemUserType userType;

    @OneToMany(mappedBy = "systemUser", cascade = CascadeType.ALL, orphanRemoval = true) private List<UserAction> userActions = new ArrayList<>();

    // Getters and setters, constructors, other methods

    public SystemUser() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;

    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public SystemUserType getUserType() {
        return userType;
    }

    public void setUserType(SystemUserType userType) {
        this.userType = userType;
    }

    @PrePersist
    public void prePersist() {
        if (this.userType == null) {
            this.userType = getDefaultUserType();
        }
    }

    protected abstract SystemUserType getDefaultUserType();

    @Override
    public String toString() {
        return "\nSystemUser{" +
                "userId='" + userId + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", credentials=" + credentials +
                "}\n";
    }

    //    Reference for bidirectional, "One" side's setter: https://github.com/SomMeri/org.meri.jpa.tutorial/blob/master/src/main/java/org/meri/jpa/relationships/entities/bestpractice/SafePerson.java

    public void addAction(UserAction userAction) {
        if (this.userActions == null) {
            this.userActions = new ArrayList<>();
        }
        if (this.userActions.contains(userAction)) {
            return;
        }
        userActions.add(userAction);
        userAction.setSystemUser(this);
    }

    public void removeAction(UserAction userAction) {
        if (!userActions.contains(userAction)) {
            return;
        }
        userActions.remove(userAction);
        userAction.setSystemUser(null);
    }
}


