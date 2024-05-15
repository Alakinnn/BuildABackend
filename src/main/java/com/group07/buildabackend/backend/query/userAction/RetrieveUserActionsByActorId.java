package com.group07.buildabackend.backend.query.userAction;

public class RetrieveUserActionsByActorId extends UserActionQuery{
    private UserActionQuery userActionQuery;
    private String systemUserId;

    public RetrieveUserActionsByActorId(UserActionQuery userActionQuery, String systemUserId) {
        this.userActionQuery = userActionQuery;
        this.systemUserId = systemUserId;
    }

    @Override
    public String toString() {
        return userActionQuery + "WHERE ua.systemUser.userId LIKE '%" + systemUserId + "%'";
    }
}
