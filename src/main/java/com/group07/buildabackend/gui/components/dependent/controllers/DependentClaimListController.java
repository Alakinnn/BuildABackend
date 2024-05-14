package com.group07.buildabackend.gui.components.dependent.controllers;

import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.repository.DependentRepository;
import com.group07.buildabackend.backend.repository.PolicyHolderRepository;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.claim.ClaimList;
import com.group07.buildabackend.gui.utils.AlertManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DependentClaimListController implements Initializable, ComponentController {
    @FXML
    private HBox myClaimsContainer;

    ClaimList myClaims;

    public DependentClaimListController() {
        myClaims = new ClaimList();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myClaimsContainer.getChildren().add(myClaims.getRoot());
    }

    public void innitPage(String dId) {
        // TODO: Change this to controller instead of Repository
        try {

            DependentRepository repo = new DependentRepository();
            List<InsuranceClaim> claims = repo.retrieveAllClaimsByActorId(dId);

            for (InsuranceClaim claim: claims) {
                myClaims.addClaim(claim);
            }
        } catch (Exception e) {
            e.printStackTrace();
            AlertManager.showError(e.getMessage());
        }

    }
}
