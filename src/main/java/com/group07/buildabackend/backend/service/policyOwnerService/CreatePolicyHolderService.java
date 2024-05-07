package com.group07.buildabackend.backend.service.policyOwnerService;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.beneficiaryDTO.PolicyHolderDTO;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.validation.PolicyHolderValidator;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;
import org.hibernate.HibernateException;

public class CreatePolicyHolderService {
    public static Response<PolicyHolder> createNewPolicyHolder(PolicyHolderDTO policyHolderDTO) {
        Response<PolicyHolder> response = new Response<>(null);
        try {
            PolicyHolderValidator.validateInput(policyHolderDTO);

        } catch (InvalidInputException e) {
            response.setResponseMsg(e.getMessage());
            response.setStatusCode(e.getErrorCode());
            response.setData(null);
        } catch (HibernateException e) {
            response.setResponseMsg(e.getMessage());
            response.setStatusCode(409);
            response.setData(null);
        }
        return response;
    }
}
