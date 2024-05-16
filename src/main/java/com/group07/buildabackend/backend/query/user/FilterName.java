package com.group07.buildabackend.backend.query.user;

public class FilterName extends UserQuery {
    private UserQuery query;
    private final String nameVal;

    public FilterName(UserQuery userQuery, String nameVal) {
        this.query = userQuery;
        this.nameVal = nameVal;
    }

    @Override
    public String toString() {
        return query + " WHERE su.firstName LIKE '%" + nameVal + "%' " +
                "OR su.lastName LIKE '%" + nameVal + "%'";
    }
}
