package com.group07.buildabackend.backend.service.policyOwnerService;

import com.group07.buildabackend.backend.authentication.PasswordHashing;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.beneficiaryDTO.PolicyHolderDTO;
import com.group07.buildabackend.backend.model.Credentials;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.validation.SysUserValidator;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;
import org.hibernate.HibernateException;

public class CreatePolicyHolderService extends SysUserService {
    public static Response<PolicyHolder> createNewPolicyHolder(PolicyHolderDTO policyHolderDTO) {
        Response<PolicyHolder> response = new Response<>(null);
        try {
            SysUserValidator.validateInput(policyHolderDTO);

            PolicyHolder policyHolder = createPolicyHolderFromDTO(policyHolderDTO);

            Credentials credentials = createCredentials(policyHolderDTO.getPwd(), policyHolder);

            sysUserRepository.add(policyHolder);

            handleSuccess(response, "Successfully created new policy holder", 200, policyHolder);
        } catch (InvalidInputException e) {
            handleException(response, e.getMessage(), e.getErrorCode());
        } catch (HibernateException e) {
            handleException(response, e.getMessage(), 409);
        }
        return response;
    }

    private static PolicyHolder createPolicyHolderFromDTO(PolicyHolderDTO policyHolderDTO) {
        PolicyHolder policyHolder = new PolicyHolder();
        policyHolder.setEmail(policyHolderDTO.getEmail());
        policyHolder.setPhone(policyHolderDTO.getPhone());
        policyHolder.setLastName(policyHolderDTO.getLastName());
        policyHolder.setFirstName(policyHolderDTO.getFirstName());
        policyHolder.setAddress(policyHolderDTO.getAddress());
        return policyHolder;
    }

    private static Credentials createCredentials(String password, PolicyHolder policyHolder) {
            String salt = PasswordHashing.generateSalt();
            String hashedPwd = PasswordHashing.hashPassword(password, salt);

            Credentials credentials = new Credentials();
            credentials.setSalt(salt);
            credentials.setHashedPwd(hashedPwd);
            credentials.setUser(policyHolder);
            return credentials;
    }
}
