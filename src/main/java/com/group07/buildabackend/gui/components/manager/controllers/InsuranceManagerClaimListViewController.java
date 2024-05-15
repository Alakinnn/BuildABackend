package com.group07.buildabackend.gui.components.manager.controllers;

import com.group07.buildabackend.backend.controller.InsuranceClaimController;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.claim.ClaimList;
import com.group07.buildabackend.gui.tasks.TaskRunner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class InsuranceManagerClaimListViewController implements Initializable, ComponentController {
    @FXML
    private HBox claimsContainer;

    private ClaimList claims;

    public InsuranceManagerClaimListViewController() {
        claims = new ClaimList();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        claimsContainer.getChildren().add(claims.getRoot());

        TaskRunner<List<InsuranceClaim>> runner = new TaskRunner<>(this::fetchClaims, claims -> {
            this.claims.addAllClaims(claims);
        });
        runner.run();
    }

    private List<InsuranceClaim> fetchClaims() {
        InsuranceClaimController controller = new InsuranceClaimController();
        Response<List<InsuranceClaim>> res = controller.retrieveAll();
        return res.getData();
    }
}
