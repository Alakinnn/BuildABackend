package com.group07.buildabackend.backend.dto.queryDTO;

/**
 * @author Group_7
 */

public class UserQueryDTO {
    private String nameVal;
    private String systemUserId;
    private String email;
    private String userType;
    private boolean isAsc;
    private boolean isDesc;

    public UserQueryDTO() {
    }

    public String getNameVal() {
        return nameVal;
    }

    public void setNameVal(String nameVal) {
        this.nameVal = nameVal;
    }

    public String getSystemUserId() {
        return systemUserId;
    }

    public void setSystemUserId(String systemUserId) {
        this.systemUserId = systemUserId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public boolean isAsc() {
        return isAsc;
    }

    public void setAsc(boolean asc) {
        isAsc = asc;
    }

    public boolean isDesc() {
        return isDesc;
    }

    public void setDesc(boolean desc) {
        isDesc = desc;
    }
}
