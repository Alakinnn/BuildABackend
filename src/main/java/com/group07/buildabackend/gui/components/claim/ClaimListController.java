package com.group07.buildabackend.gui.components.claim;

import com.group07.buildabackend.backend.model.customer.Customer;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaimStatus;
import com.group07.buildabackend.gui.components.ComponentController;
import jakarta.persistence.Table;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    private TableColumn<InsuranceClaim, String> claimIdCol;
    @FXML
    public TableColumn<InsuranceClaim, String> customerCol;
    @FXML
    public TableColumn<InsuranceClaim, Double> amountCol;
    @FXML
    public TableColumn<InsuranceClaim, InsuranceClaimStatus> statusCol;
    @FXML
    public TableColumn<InsuranceClaim, LocalDate> claimDateCol;

    private List<InsuranceClaim> claims;

    public ClaimListController() {
        claims = new ArrayList<>();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        claimIdCol.setCellValueFactory(new PropertyValueFactory<>("claimId"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        claimDateCol.setCellValueFactory(new PropertyValueFactory<>("claimDate"));

        customerCol.setCellValueFactory(cellData -> {
            // Get the customer object from the current InsuranceClaim
            Customer customer = cellData.getValue().getCustomer();
            // Return the name of the customer as the cell value
            return new SimpleStringProperty(customer != null ? customer.getFullName() : "");
        });
    }

    public void addClaim(InsuranceClaim claim) {
        table.getItems().add(claim);
    }

}
