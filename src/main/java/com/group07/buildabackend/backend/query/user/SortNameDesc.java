package com.group07.buildabackend.backend.query.user;

public class SortNameDesc extends UserQuery{
    private UserQuery query;

    public SortNameDesc(UserQuery query){
        this.query = query;
    }

    @Override
    public String toString() {
        return query + " ORDER BY first_name DESC";
    }
}
