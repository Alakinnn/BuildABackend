package com.group07.buildabackend.backend.query.claim;

public class FilterExamDate extends FilterDate{
    public FilterExamDate(ClaimQuery claimQuery, String year, String month, String day) {
        super(claimQuery, year, month, day);
    }

    @Override
    public String toString() {
        String jpql = super.getClaimQuery().toString() + " WHERE 1 = 1";
        if(super.getYear() != null && !super.getYear().isEmpty()){
            jpql += " AND YEAR(ic.examDate) = " + super.getYear();
        }
        if(super.getMonth() != null && !super.getMonth().isEmpty()){
            jpql += " AND MONTH(ic.examDate) = " + super.getMonth();
        }
        if(super.getDay() != null && !super.getDay().isEmpty()){
            jpql += " AND DAY(ic.examDate) = " + super.getDay();
        }

        return jpql;
    }
}
