package com.group07.buildabackend.gui.pages.owner;

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
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

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

    public void onFind() {
        TaskRunner runner = new TaskRunner();
        runner.run(this::populateClaims);
    }

    public void initPage(String policyOwnerId) {
        this.policyOwnerId = policyOwnerId;

        TaskRunner<List<Beneficiary>> runner = new TaskRunner();
        runner.run(this::populateBeneficiaryChoices);

        customerClaimsContainer.getChildren().add(customerClaims.getRoot());
        dependentClaimsContainer.getChildren().add(dependentClaims.getRoot());

    }

    private Object populateClaims() {
        // Refresh lists
        this.customerClaims.resetClaims();
        this.dependentClaims.resetClaims();

        String beneficiaryId = beneficiaryChoice.getValue().getValue();

        // TODO: Use controllers instead
        PolicyOwnerRepository repo = new PolicyOwnerRepository();
        Beneficiary beneficiary = repo.retrieveOneBeneficiary(beneficiaryId, policyOwnerId);

        if (beneficiary.getUserType() == SystemUserType.dependent) {
            DependentRepository depRepo = new DependentRepository();
            List<InsuranceClaim> claims = depRepo.retrieveAllClaimsByActorId(beneficiary.getUserId());

            this.customerClaims.addAllClaims(claims);
        }

        if (beneficiary.getUserType() == SystemUserType.policy_holder) {
            PolicyHolderRepository phRepo = new PolicyHolderRepository();
            List<InsuranceClaim> phClaims = phRepo.retrieveAllClaimsByActorId(beneficiaryId);
            List<InsuranceClaim> depClaims = phRepo.retrieveAllDependentClaim(beneficiaryId);

            this.customerClaims.addAllClaims(phClaims);
            this.dependentClaims.addAllClaims(depClaims);
        }

        return null;
    }

    private List<Beneficiary> populateBeneficiaryChoices() {
        PolicyOwnerRepository repo = new PolicyOwnerRepository();
        List<Beneficiary> beneficiaries = repo.retrieveAllBeneficiary(policyOwnerId);

        if (beneficiaries == null) return null;

        for (SystemUser user: beneficiaries) {
            String id = user.getUserId();
            String label = user.getFullName() + " (" + id + ")";
            beneficiaryChoice.getItems().add(new ChoiceField<>(label, id));
        }

        return beneficiaries;
    }

}
