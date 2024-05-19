package com.group07.buildabackend.backend.service.systemAdminService;
/**
 * @author Group_7
 */

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
    public static Response<Double> calculateSuccessfulClaimsAmount() {
        Response<Double> response = new Response<>(null);
        OperationType userAction = new ApprovedClaimAction(new CalculateOperation());
        String actionDescription = userAction.getDescription();
        response.setAction(actionDescription);

        ClaimQueryDTO dto = new ClaimQueryDTO();
        dto.setStatus(InsuranceClaimStatus.APPROVED.toString());
        double claimedAmount = 0;

        try{
            InsuranceClaimController controller = new InsuranceClaimController();
            Response<List<InsuranceClaim>> data = controller.fetchClaimsByStatus(dto);
            List<InsuranceClaim> claims = data.getData();

            for(InsuranceClaim claim: claims){
                claimedAmount += claim.getAmount();
            }

            handleSuccess(response, "Query Success", 200, claimedAmount);
        } catch (Exception e){
            handleException(response, e.getMessage(), 400);
        }

        return response;
    }
}
