package com.group07.buildabackend.backend.query.user;

public class SortName extends UserQuery{
    private UserQuery query;

    public SortName(UserQuery query){
        this.query = query;
    }

    @Override
    public String toString() {
        return query + " ORDER BY su.first_name;";
    }
}
