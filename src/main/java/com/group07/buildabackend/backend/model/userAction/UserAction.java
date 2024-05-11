package com.group07.buildabackend.backend.model.userAction;

import com.group07.buildabackend.backend.utils.idGenerator.CustomIDGenerator;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @Column(name = "user_id")
    private String userId;

    @Column(name = "action_type")
    private String actionType;

    @Column(name = "status_code")
    private int statusCode;

    @Column(name = "timestamp")
    private LocalDateTime timeStamp;
    public UserAction() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
}
