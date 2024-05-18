package com.group07.buildabackend.gui.components.admin.controllers;

import com.group07.buildabackend.backend.controller.AdminController;
import com.group07.buildabackend.backend.controller.InsuranceClaimController;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.queryDTO.ClaimQueryDTO;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.claim.ClaimList;
import com.group07.buildabackend.gui.tasks.TaskRunner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SystemAdminClaimListViewController implements Initializable, ComponentController {
    @FXML
    private Text successAmount;
    @FXML
    private HBox claimsContainer;

    private ClaimList claims;

    public SystemAdminClaimListViewController() {
        claims = new ClaimList();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        claimsContainer.getChildren().add(claims.getRoot());

        TaskRunner<List<InsuranceClaim>> runner = new TaskRunner<>(this::fetchClaims, claims -> {
            this.claims.addAllClaims(claims);

            TaskRunner<Double> statsRunner = new TaskRunner<>(this::fetchSuccessAmount, successAmount -> {
                this.successAmount.setText(String.valueOf(successAmount));
            });
            statsRunner.run();
        });
        runner.run();
    }

    private List<InsuranceClaim> fetchClaims() {
        InsuranceClaimController controller = new InsuranceClaimController();
        Response<List<InsuranceClaim>> res = controller.retrieveAll();
        return res.getData();
    }

    private Double fetchSuccessAmount() {
        AdminController controller = new AdminController();
        return controller.calculateSuccessfulClaimsAmount().getData();
    }
}
