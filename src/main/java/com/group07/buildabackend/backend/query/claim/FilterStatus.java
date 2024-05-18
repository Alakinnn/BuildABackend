package com.group07.buildabackend.backend.query.claim;
/**
 * @author Group_7
 */

public class FilterStatus extends ClaimQuery{
    private ClaimQuery claimQuery;
    private String status;

    public FilterStatus(ClaimQuery claimQuery, String status) {
        this.claimQuery = claimQuery;
        this.status = status;
    }

    @Override
    public String toString() {
        return claimQuery + " WHERE ic.status LIKE UPPER('%" + status + "%')";
    }
}
