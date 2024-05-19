package com.group07.buildabackend.backend.model;

/**
 * @author Group_7
 */

import jakarta.persistence.*;

@Entity
@Table(name = "credentials")
public class Credentials {
    @Id
    private String userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private SystemUser user;

    @Column(name = "salt")
    private String salt;

    @Column(name = "hashed_pwd")
    private String hashedPwd;

    public Credentials() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public SystemUser getUser() {
        return user;
    }

    public void setUser(SystemUser user) {
        this.user = user;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHashedPwd() {
        return hashedPwd;
    }

    public void setHashedPwd(String hashedPwd) {
        this.hashedPwd = hashedPwd;
    }


}
