package com.group07.buildabackend.backend.query.claim;

public abstract class FilterDate extends ClaimQuery{
    private ClaimQuery claimQuery;
    private String year;
    private String month;
    private String day;

    public FilterDate(ClaimQuery claimQuery, String year, String month, String day) {
        this.claimQuery = claimQuery;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public ClaimQuery getClaimQuery() {
        return claimQuery;
    }

    public void setClaimQuery(ClaimQuery claimQuery) {
        this.claimQuery = claimQuery;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
