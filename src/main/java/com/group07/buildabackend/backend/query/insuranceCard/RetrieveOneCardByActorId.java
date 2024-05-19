package com.group07.buildabackend.backend.query.insuranceCard;
/**
 * @author Group_7
 */
public class RetrieveOneCardByActorId extends InsuranceCardQuery{
    private InsuranceCardQuery insuranceCardQuery;
    private final String systemUserId;

    public RetrieveOneCardByActorId(InsuranceCardQuery insuranceCardQuery, String systemUserId) {
        this.insuranceCardQuery = insuranceCardQuery;
        this.systemUserId = systemUserId;
    }

    @Override
    public String toString() {
        return insuranceCardQuery + "JOIN beneficiary b WHERE b.userId LIKE '%" + systemUserId + "%'";
    }
}
