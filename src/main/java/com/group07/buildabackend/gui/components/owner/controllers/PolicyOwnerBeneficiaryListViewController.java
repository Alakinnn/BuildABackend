package com.group07.buildabackend.gui.components.owner.controllers;

import com.group07.buildabackend.backend.controller.PolicyOwnerController;
import com.group07.buildabackend.backend.controller.UserController;
import com.group07.buildabackend.backend.dto.InsuranceCostDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.customer.Beneficiary;
import com.group07.buildabackend.backend.repository.PolicyOwnerRepository;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.user.UserList;
import com.group07.buildabackend.gui.tasks.TaskRunner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PolicyOwnerBeneficiaryListViewController implements ComponentController, Initializable {
    @FXML
    private HBox beneficiariesContainer;

    @FXML
    private Text yearlyRate;
    @FXML
    private Text totalCost;

    private UserList beneficiaries;
    private String poId;

    public PolicyOwnerBeneficiaryListViewController() {
        beneficiaries = new UserList();
    }

    private List<Beneficiary> fetchUsers() {
        PolicyOwnerController controller = new PolicyOwnerController();
        return controller.retrieveAllBeneficiaries(poId).getData();
    }

    private List<Double> fetchYearlyCost() {
        InsuranceCostDTO dto = new InsuranceCostDTO();
        dto.setId(poId);
        PolicyOwnerController controller = new PolicyOwnerController();

        List<Double> res = new ArrayList<>(2);

        res.add(controller.getYearlyRate(dto).getData());
        res.add(controller.calculateAnnualCost(dto).getData());

        return res;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        beneficiariesContainer.getChildren().add(beneficiaries.getRoot());
    }

    public void initPage(String poId) {
        this.poId = poId;

        TaskRunner<List<Beneficiary>> runner = new TaskRunner<>(this::fetchUsers, beneficiaries -> {
            if (beneficiaries == null) return;

            for (Beneficiary beneficiary: beneficiaries){
                this.beneficiaries.addUser(beneficiary);
            }

            TaskRunner<List<Double>> costRunner = new TaskRunner<>(this::fetchYearlyCost, cost -> {
                yearlyRate.setText(String.valueOf(cost.get(0)));
                totalCost.setText(String.valueOf(cost.get(1)));
            }) ;
            costRunner.run();
        });
        runner.run();
    }
}
