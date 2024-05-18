package com.group07.buildabackend.backend.dto.queryDTO;

/**
 * @author Group_7
 */

public class ClaimQueryDTO{
    private String status;
    private String year;
    private String month;
    private String day;
    private Double amount;

    public ClaimQueryDTO() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}


