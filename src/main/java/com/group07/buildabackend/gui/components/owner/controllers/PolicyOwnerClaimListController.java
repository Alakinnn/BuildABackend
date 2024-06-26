package com.group07.buildabackend.gui.components.owner.controllers;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.controller.PolicyOwnerController;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.SystemUserType;
import com.group07.buildabackend.backend.model.customer.Beneficiary;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.repository.DependentRepository;
import com.group07.buildabackend.backend.repository.PolicyHolderRepository;
import com.group07.buildabackend.backend.repository.PolicyOwnerRepository;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.claim.ClaimList;
import com.group07.buildabackend.gui.tasks.TaskRunner;
import com.group07.buildabackend.gui.utils.ChoiceField;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class PolicyOwnerClaimListController implements ComponentController {
    @FXML
    private HBox customerClaimsContainer;
    @FXML
    private HBox dependentClaimsContainer;
    @FXML
    private ChoiceBox<ChoiceField<String>> beneficiaryChoice;

    private ClaimList customerClaims;
    private ClaimList dependentClaims;

    private String policyOwnerId;


    public PolicyOwnerClaimListController() {
        customerClaims = new ClaimList();
        dependentClaims = new ClaimList();
    }

    public void initPage(String policyOwnerId) {
        customerClaimsContainer.getChildren().add(customerClaims.getRoot());
        dependentClaimsContainer.getChildren().add(dependentClaims.getRoot());

        this.policyOwnerId = policyOwnerId;

        // Add beneficiary choices
        TaskRunner<List<Beneficiary>> runner = new TaskRunner<>(this::fetchBeneficiaries, beneficiaries -> {
            for (SystemUser user: beneficiaries) {
                String id = user.getUserId();
                String label = user.getFullName() + " (" + id + ")";
                beneficiaryChoice.getItems().add(new ChoiceField<>(label, id));
            }
        });

        runner.run();
    }

    public void onFind() {
        if (beneficiaryChoice.getValue() == null) return;

        customerClaims.resetClaims();
        dependentClaims.resetClaims();

        TaskRunner<List<List<InsuranceClaim>>> runner = new TaskRunner<>(this::fetchClaims, claims -> {
            if (claims == null) return;

            customerClaims.addAllClaims(claims.get(0));
            dependentClaims.addAllClaims(claims.get(1));
        });

        runner.run();
    }

    private List<List<InsuranceClaim>> fetchClaims() {
        String beneficiaryId = beneficiaryChoice.getValue().getValue();
        List<List<InsuranceClaim>> res = new ArrayList<>(2);
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());

        PolicyOwnerController controller = new PolicyOwnerController();
        Beneficiary beneficiary = controller.retrieveBeneficiary(beneficiaryId, policyOwnerId).getData();

        if (beneficiary == null) return null;

        if (beneficiary.getUserType() == SystemUserType.dependent) {
            DependentRepository depRepo = new DependentRepository();
            List<InsuranceClaim> claims = depRepo.retrieveAllClaimsByActorId(beneficiary.getUserId());

            res.set(0, claims);
        }

        if (beneficiary.getUserType() == SystemUserType.policy_holder) {
            PolicyHolderRepository phRepo = new PolicyHolderRepository();
            List<InsuranceClaim> phClaims = phRepo.retrieveAllClaimsByActorId(beneficiaryId);
            List<InsuranceClaim> depClaims = phRepo.retrieveAllDependentClaim(beneficiaryId);

            res.set(0, phClaims);
            res.add(1, depClaims);
        }

        return res;
    }

    private List<Beneficiary> fetchBeneficiaries() {
        PolicyOwnerController controller = new PolicyOwnerController();
        return controller.retrieveAllBeneficiaries(policyOwnerId).getData();
    }

}
