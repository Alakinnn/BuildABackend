package com.group07.buildabackend.gui.pages.holder;

import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.repository.PolicyHolderRepository;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.claim.ClaimList;
import com.group07.buildabackend.gui.tasks.TaskRunner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PolicyHolderClaimListController implements Initializable, ComponentController {
    @FXML
    private HBox myDependentClaimsContainer;
    @FXML
    private HBox myClaimsContainer;

    private ClaimList myClaims;
    private ClaimList myDependentClaims;

    private String phId;

    public PolicyHolderClaimListController() {
        myClaims = new ClaimList();
        myDependentClaims = new ClaimList();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myDependentClaimsContainer.getChildren().add(myDependentClaims.getRoot());
        myClaimsContainer.getChildren().add(myClaims.getRoot());
    }

    private List<List<InsuranceClaim>> fetchClaims() {
        // TODO: Change this to controller instead of Repository
        PolicyHolderRepository repo = new PolicyHolderRepository();
        List<InsuranceClaim> holderClaims = repo.retrieveAllClaimsByActorId(phId);
        List<InsuranceClaim> dependentClaims = repo.retrieveAllDependentClaim(phId);

        List<List<InsuranceClaim>> res = new ArrayList<>(2);
        res.add(holderClaims);
        res.add(dependentClaims);

        return res;
    }

    public void innitPage(String phId) {
        this.phId = phId;

        TaskRunner<List<List<InsuranceClaim>>> runner = new TaskRunner<>(this::fetchClaims, claims -> {
            myClaims.addAllClaims(claims.get(0));
            myDependentClaims.addAllClaims(claims.get(1));
        });

        runner.run();
    }
}
