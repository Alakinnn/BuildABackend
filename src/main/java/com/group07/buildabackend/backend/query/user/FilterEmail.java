package com.group07.buildabackend.backend.query.user;

public class FilterEmail extends UserQuery{
    private UserQuery userQuery;
    private String emailVal;

    public FilterEmail(UserQuery userQuery, String emailVal) {
        this.userQuery = userQuery;
        this.emailVal = emailVal;
    }

    @Override
    public String toString() {
        return userQuery + " WHERE su.email LIKE '%" + emailVal + "%'";
    }
}
