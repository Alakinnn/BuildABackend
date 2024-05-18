package com.group07.buildabackend.backend.query.claim;
/**
 * @author Group_7
 */

public class FilterAmount extends ClaimQuery{
    private ClaimQuery claimQuery;
    private double amount;

    public FilterAmount(ClaimQuery claimQuery, double amount) {
        this.claimQuery = claimQuery;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return claimQuery + " WHERE ic.amount = " + amount;
    }
}
