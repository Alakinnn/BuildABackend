package com.group07.buildabackend.backend.model.userAction;

import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.utils.idGenerator.CustomIDGenerator;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "user_action")
public class UserAction {
    @Id
    @GenericGenerator(
            name = CustomIDGenerator.GENERATOR_NAME,
            strategy = "com.group07.buildabackend.backend.utils.idGenerator.CustomIDGenerator",
            parameters = {@org.hibernate.annotations.Parameter(name = CustomIDGenerator.PREFIX_PARAM, value = "act_")})
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = CustomIDGenerator.GENERATOR_NAME)
    @Column(name = "action_id")
    private String actionId;

    @Column(name = "action_type")
    private String actionType;

    @Column(name = "status_code")
    private int statusCode;

    @Column(name = "timestamp")
    private LocalDateTime timeStamp;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private SystemUser systemUser;

    public UserAction() {
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    //    Reference for bidirectional, "Many" side's setter: https://github.com/SomMeri/org.meri.jpa.tutorial/blob/master/src/main/java/org/meri/jpa/relationships/entities/bestpractice/SafePerson.java
    public void setSystemUser(SystemUser systemUser) {
        if (sameAsFormer(systemUser))
            return ;
        SystemUser oldSystemUser = this.systemUser;
        this.systemUser = systemUser;
        if (oldSystemUser!=null) {
            oldSystemUser.removeAction(this);
        }
        if (systemUser!=null) {
            systemUser.addAction(this);
        }

    }

    private boolean sameAsFormer(SystemUser newSystemUser) {
        return Objects.equals(systemUser, newSystemUser);
    }

}
