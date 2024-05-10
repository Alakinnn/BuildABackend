package com.group07.buildabackend.gui.pages.owner;

import com.group07.buildabackend.backend.controller.PolicyHolderController;
import com.group07.buildabackend.backend.controller.UserController;
import com.group07.buildabackend.backend.dto.queryDTO.UserQueryDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.repository.DependentRepository;
import com.group07.buildabackend.backend.repository.PolicyHolderRepository;
import com.group07.buildabackend.backend.repository.operations.ClaimRetrievable;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.claim.ClaimList;
import com.group07.buildabackend.gui.tasks.TaskRunner;
import com.group07.buildabackend.gui.utils.ChoiceField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PolicyOwnerClaimListController implements Initializable, ComponentController {
    @FXML
    private HBox customerClaimsContainer;
    @FXML
    private HBox dependentClaimsContainer;
    @FXML
    private ChoiceBox<ChoiceField<String>> customerChoice;

    private ClaimList customerClaims;
    private ClaimList dependentClaims;


    public PolicyOwnerClaimListController() {
        customerClaims = new ClaimList();
        dependentClaims = new ClaimList();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TaskRunner runner = new TaskRunner();
        runner.run(this::populateCustomerChoices);

        customerClaimsContainer.getChildren().add(customerClaims.getRoot());
        dependentClaimsContainer.getChildren().add(dependentClaims.getRoot());
    }

    public void onFind() {
        TaskRunner runner = new TaskRunner();
        runner.run(this::populateClaims);
    }

    private Object populateClaims() {
        // Refresh lists
        this.customerClaims.resetClaims();
        this.dependentClaims.resetClaims();

        String customerId = customerChoice.getValue().getValue();


        PolicyHolderRepository repo = new PolicyHolderRepository();
        List<InsuranceClaim> customerClaims = repo.retrieveAllClaimsByActorId(customerId);
        List<InsuranceClaim> dependentClaims = repo.retrieveAllDependentClaim(customerId);

        // TODO: Handle based on role, also use controllers
//        if (customer.role == blabla) {
//            blabla
//        }
        if (customerClaims.size() == 0 && dependentClaims.size() == 0) {
            customerClaims = new DependentRepository().retrieveAllClaimsByActorId(customerId);
        }

        // FIXME: Currently can only see policy holder claims, BE needs to implement role
        for (InsuranceClaim claim: customerClaims) {
            this.customerClaims.addClaim(claim);
        }

        for (InsuranceClaim claim: dependentClaims) {
            this.dependentClaims.addClaim(claim);
        }

        return null;
    }

    private List<SystemUser> populateCustomerChoices() {
        UserController controller = new UserController();
        UserQueryDTO dto = new UserQueryDTO();

        List<SystemUser> users = controller.queryUsers(dto).getData();

        if (users == null) return null;

        for (SystemUser user: users) {
            String id = user.getUserId();
            String label = user.getFullName() + " (" + id + ")";
            customerChoice.getItems().add(new ChoiceField<>(label, id));
        }

        return users;
    }

}
