package com.group07.buildabackend.gui.pages.holder;

import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.repository.PolicyHolderRepository;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.claim.ClaimList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PolicyHolderClaimListViewController implements Initializable, ComponentController {
    @FXML
    private HBox myDependentClaimsContainer;
    @FXML
    private HBox myClaimsContainer;

    ClaimList myClaims;
    ClaimList myDependentClaims;

    public PolicyHolderClaimListViewController() {
        myClaims = new ClaimList();
        myDependentClaims = new ClaimList();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myDependentClaimsContainer.getChildren().add(myClaims.getRoot());
        myClaimsContainer.getChildren().add(myDependentClaims.getRoot());
    }

    public void innitPage(String phId) {
        PolicyHolderRepository<PolicyHolder> repo = new PolicyHolderRepository<>();
        // FIXME: Implement fetching when BE is finished
//        List<InsuranceClaim> holderClaims = repo.retrieveClaimsByUserId(phId);
//        List<InsuranceClaim> dependentClaims = repo.retrieveDepedentClaim(phId);
//
//        for (InsuranceClaim claim: holderClaims) {
//            myClaims.addClaim(claim);
//        }
//
//        for (InsuranceClaim claim: dependentClaims) {
//            myDependentClaims.addClaim(claim);
//        }
    }
}
