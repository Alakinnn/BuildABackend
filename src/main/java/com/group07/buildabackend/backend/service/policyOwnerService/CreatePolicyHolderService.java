package com.group07.buildabackend.backend.service.policyOwnerService;

import com.group07.buildabackend.backend.authentication.PasswordHashing;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.beneficiaryDTO.PolicyHolderDTO;
import com.group07.buildabackend.backend.dto.beneficiaryDTO.PolicyHolderMapper;
import com.group07.buildabackend.backend.model.Credentials;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.customer.PolicyOwner;
import com.group07.buildabackend.backend.model.insuranceCard.InsuranceCard;
import com.group07.buildabackend.backend.validation.SysUserValidator;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;
import org.hibernate.HibernateException;

public class CreatePolicyHolderService extends SystemUserService {
    public static Response<PolicyHolder> createNewPolicyHolder(PolicyHolderDTO policyHolderDTO) {
        Response<PolicyHolder> response = new Response<>(null);
        try {
            SysUserValidator.validateInput(policyHolderDTO);

            PolicyHolder policyHolder = PolicyHolderMapper.toEntity(policyHolderDTO);
            PolicyOwner policyOwner = policyOwnerRepository.retrieveActorById(policyHolderDTO.getPolicyOwnerId());

            InsuranceCard insuranceCard = new InsuranceCard();
            Credentials credentials = createCredentials(policyHolderDTO.getPwd(), policyHolder);

            policyHolder.setPolicyOwner(policyOwner);
//            policyHolder.setCustomerType("policy_holder");
            policyHolder.setInsuranceCard(insuranceCard);
            policyHolder.setCredentials(credentials);

            systemUserRepository.add(policyHolder);


            handleSuccess(response, "Successfully created new policy holder", 200, policyHolder);
        } catch (InvalidInputException e) {
            handleException(response, e.getMessage(), e.getErrorCode());
        } catch (HibernateException e) {
            handleException(response, e.getMessage(), 409);
        }
        return response;
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
