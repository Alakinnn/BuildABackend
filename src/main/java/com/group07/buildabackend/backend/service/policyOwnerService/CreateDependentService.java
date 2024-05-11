package com.group07.buildabackend.backend.service.policyOwnerService;

import com.group07.buildabackend.backend.validation.customExceptions.InvalidCredentialsException;
import org.hibernate.HibernateException;

import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.beneficiaryDTO.DependentDTO;
import com.group07.buildabackend.backend.dto.beneficiaryDTO.DependentMapper;
import com.group07.buildabackend.backend.model.Credentials;
import com.group07.buildabackend.backend.model.customer.Dependent;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.customer.PolicyOwner;
import com.group07.buildabackend.backend.model.insuranceCard.InsuranceCard;
import com.group07.buildabackend.backend.validation.SystemUserValidator;
import com.group07.buildabackend.backend.validation.customExceptions.InvalidInputException;

public class CreateDependentService extends CreatePolicyHolderService {
    public static Response<Dependent> createNewDependent(DependentDTO dependentDTO) {
        Response<Dependent> response = new Response<>(null);
        try {
            SystemUserValidator.validateInput(dependentDTO);

            Dependent dependent = DependentMapper.toEntity(dependentDTO);
            PolicyOwner policyOwner = policyOwnerRepository.retrieveActorById(dependentDTO.getPolicyOwnerId());

            if (policyOwner == null) {
                throw new InvalidInputException("Policy owner not found", 400);
            }

            PolicyHolder policyHolder = policyHolderRepository.retrieveActorById(dependentDTO.getPolicyHolderId());

            if (policyHolder == null) {
                throw new InvalidInputException("Policy holder not found", 400);
            }

            InsuranceCard insuranceCard = new InsuranceCard();
            Credentials credentials = createCredentials(dependentDTO.getPwd(), dependent);

            if (credentials == null) {
                throw new InvalidCredentialsException("Password is required!", 400);
            }


            dependent.setPolicyOwner(policyOwner);
            dependent.setInsuranceCard(insuranceCard);
            dependent.setPolicyHolder(policyHolder);
            dependent.setCredentials(credentials);

            systemUserRepository.add(dependent);

            handleSuccess(response, "Successfully created new policy holder", 200, dependent);
        } catch (InvalidInputException e) {
            handleException(response, e.getMessage(), e.getErrorCode());
        } catch (HibernateException e) {
            handleException(response, e.getMessage(), 409);
        } catch (InvalidCredentialsException e) {
            handleException(response, e.getMessage(), e.getErrorCode());
        }
        return response;
    }
}
