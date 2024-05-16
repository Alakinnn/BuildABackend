package com.group07.buildabackend.backend.query.user;

public class FilterUserType extends UserQuery{
    private UserQuery userQuery;
    private String userTypeVal;

    public FilterUserType(UserQuery userQuery, String userTypeVal) {
        this.userQuery = userQuery;
        this.userTypeVal = userTypeVal.toLowerCase();
    }

    @Override
    public String toString() {
        return userQuery + " WHERE su.userType LIKE LOWER('%" + userTypeVal + "%') ESCAPE '_'";
    }}
