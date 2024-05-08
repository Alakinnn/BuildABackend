package com.group07.buildabackend.backend.dto.queryDTO;

public class UserQueryDTO {
    private String nameVal;
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
