package com.group07.buildabackend.backend.service.systemAdminService;

import com.group07.buildabackend.backend.controller.InsuranceClaimController;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.queryDTO.ClaimQueryDTO;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaimStatus;
import com.group07.buildabackend.backend.model.userAction.actions.ApprovedClaimAction;
import com.group07.buildabackend.backend.model.userAction.operations.CalculateOperation;
import com.group07.buildabackend.backend.model.userAction.operations.OperationType;
import com.group07.buildabackend.backend.service.user.SystemUserService;

import java.util.List;

public class CalculateService extends SystemUserService {
    public static Response<Integer> calculateSuccessfulClaims(ClaimQueryDTO dto) {
        Response<Integer> response = new Response<>(null);
        OperationType userAction = new ApprovedClaimAction(new CalculateOperation());
        String actionDescription = userAction.getDescription();
        response.setAction(actionDescription);

        dto.setStatus(InsuranceClaimStatus.APPROVED.toString());

        try{
            InsuranceClaimController controller = new InsuranceClaimController();
            int successfulClaims = controller.fetchClaimsByStatus(dto).getData().size();

            handleSuccess(response, "Query Success", 200, successfulClaims);
        } catch (Exception e){
            handleException(response, e.getMessage(), 400);
        }

        return response;
    }
}
