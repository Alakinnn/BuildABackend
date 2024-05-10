package com.group07.buildabackend.gui.components.claim;

import com.group07.buildabackend.backend.model.customer.Customer;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaimStatus;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.user.UserHyperlink;
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
    private ChoiceBox<ClaimFilterOption> filterChoice;

    private List<InsuranceClaim> claims;

    private enum ClaimFilterOption {
        STATUS,
        AMOUNT
    }

    public ClaimListController() {
        claims = new ArrayList<>();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initTable();
        initFilter();
    }


    private void initFilter() {
        filterChoice.getItems().add(ClaimFilterOption.STATUS);
        filterChoice.getItems().add(ClaimFilterOption.AMOUNT);
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

    public void onFilter() {
        // TODO: implement backend
        System.out.println(filterValField.getText());
        System.out.println(filterChoice.getValue());
    }

    public void addClaim(InsuranceClaim claim) {
        table.getItems().add(claim);
    }

    public void resetClaims() {
        table.getItems().clear();
    }

}
