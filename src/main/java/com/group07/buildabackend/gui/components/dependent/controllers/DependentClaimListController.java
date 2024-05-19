package com.group07.buildabackend.gui.components.dependent.controllers;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.controller.DependentController;
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
        try {
            DependentController controller = new DependentController();
            List<InsuranceClaim> claims = controller.retrieveAllClaimsById(dId).getData();

            for (InsuranceClaim claim: claims) {
                myClaims.addClaim(claim);
            }
        } catch (Exception e) {
            e.printStackTrace();
            AlertManager.showError(e.getMessage());
        }

    }
}
