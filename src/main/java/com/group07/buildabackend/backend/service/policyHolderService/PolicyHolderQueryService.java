package com.group07.buildabackend.backend.service.policyHolderService;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.InsuranceClaimMapper;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.customer.Customer;
import com.group07.buildabackend.backend.model.insuranceClaim.Document;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.model.userAction.actions.ClaimAction;
import com.group07.buildabackend.backend.model.userAction.operations.CreateOperation;
import com.group07.buildabackend.backend.model.userAction.operations.OperationType;
import com.group07.buildabackend.backend.repository.PolicyHolderRepository;
import com.group07.buildabackend.backend.validation.InsuranceClaimValidator;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

import java.util.List;

import static com.group07.buildabackend.backend.utils.fileUtils.FileListMapper.mapToDocumentList;

public class PolicyHolderQueryService extends PolicyHolderService {
    public static Response<List<SystemUser>> retrieveAll() {
        Response<List<SystemUser>> response = new Response<>(null);

        try {
            PolicyHolderRepository repo = new PolicyHolderRepository();
            List<SystemUser> data = repo.retrieveAll();
            handleSuccess(response, "Query Success", 200, data);
        } catch (Exception e) {
            handleException(response, e.getMessage(), 400);
        }

        return response;

    }
}
