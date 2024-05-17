package com.group07.buildabackend.gui.components.claim.controllers;

import com.group07.buildabackend.backend.controller.InsuranceClaimController;
import com.group07.buildabackend.backend.dto.queryDTO.ClaimQueryDTO;
import com.group07.buildabackend.backend.model.customer.Customer;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaimStatus;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.claim.ClaimHyperlink;
import com.group07.buildabackend.gui.components.user.UserHyperlink;
import com.group07.buildabackend.gui.tasks.TaskRunner;
import jakarta.persistence.Table;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ClaimListController implements Initializable, ComponentController {
    @FXML
    private TableView<InsuranceClaim> table;
    @FXML
    private TableColumn<InsuranceClaim, Hyperlink> claimIdCol;
    @FXML
    private TableColumn<InsuranceClaim, Hyperlink> customerCol;
    @FXML
    private TableColumn<InsuranceClaim, Double> amountCol;
    @FXML
    private TableColumn<InsuranceClaim, InsuranceClaimStatus> statusCol;
    @FXML
    private TableColumn<InsuranceClaim, LocalDate> claimDateCol;
    @FXML
    private TextField filterValField;
    @FXML
    private ChoiceBox<String> filterChoice;


    private enum ClaimFilterOption {
        STATUS,
        AMOUNT,
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initTable();
        initFilter();
    }


    private void initFilter() {
        filterChoice.getItems().add(ClaimFilterOption.STATUS.toString());
        filterChoice.getItems().add(ClaimFilterOption.AMOUNT.toString());
    }

    private void initTable() {
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        claimDateCol.setCellValueFactory(new PropertyValueFactory<>("claimDate"));

        claimIdCol.setCellValueFactory(cellData -> {
            // Get the current InsuranceClaim
            InsuranceClaim claim = cellData.getValue();
            Hyperlink link = (Hyperlink) new ClaimHyperlink(claim).getRoot();
            // Return the hyperlink to the claim as the cell value
            return new javafx.beans.property.ReadOnlyObjectWrapper<>(link);
        });


        customerCol.setCellValueFactory(cellData -> {
            // Get the customer object from the current InsuranceClaim
            Customer customer = cellData.getValue().getCustomer();
            Hyperlink link = (Hyperlink) new UserHyperlink(customer).getRoot();
            // Return the hyperlink to the customer as the cell value
            return new javafx.beans.property.ReadOnlyObjectWrapper<>(link);
        });
    }

    private List<InsuranceClaim> fetchClaims() {
        ClaimFilterOption filter = ClaimFilterOption.valueOf(filterChoice.getValue());
        String filterVal = filterValField.getText();

        InsuranceClaimController controller = new InsuranceClaimController();

        ClaimQueryDTO dto = new ClaimQueryDTO();

        return switch (filter) {
            case AMOUNT:
                dto.setAmount(Double.valueOf(filterVal));
                yield controller.fetchClaimsByAmount(dto).getData();
            case STATUS:
                dto.setStatus(filterVal);
                yield controller.fetchClaimsByStatus(dto).getData();
        };
    }

    public void onFilter() {
        if (filterValField.getText() == null || filterChoice.getValue() == null) return;

        table.getItems().clear();

        TaskRunner<List<InsuranceClaim>> runner = new TaskRunner<>(this::fetchClaims, this::addAllClaims);

        runner.run();
    }

    public void addClaim(InsuranceClaim claim) {
        table.getItems().add(claim);
    }

    public void addAllClaims(List<InsuranceClaim> claims) {
        table.getItems().addAll(claims);
    }
    public void resetClaims() {
        table.getItems().clear();
    }

}
