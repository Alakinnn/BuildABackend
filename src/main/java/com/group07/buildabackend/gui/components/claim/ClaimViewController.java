package com.group07.buildabackend.gui.components.claim;

import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.repository.ClaimRepository;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.upload.UploadedDocs;
import com.group07.buildabackend.gui.components.user.UserHyperlink;
import com.group07.buildabackend.gui.tasks.TaskRunner;
import com.group07.buildabackend.gui.utils.AlertManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ClaimViewController implements ComponentController {
    @FXML
    private Text id;
    @FXML
    private AnchorPane customer;

    @FXML
    private Text status;
    @FXML
    private Text amount;
    @FXML
    private Text examDate;
    @FXML
    private Text claimDate;
    @FXML
    private Text bankName;
    @FXML
    private TextArea notes;
    @FXML
    private Text receiverName;
    @FXML
    private Text accountNumber;
    @FXML
    private HBox uploadedDocsContainer;
    @FXML
    private HBox actionFieldContainer;

    private String claimId;

    private InsuranceClaim fetchClaim() {
        // TODO: controller instead of repo

        ClaimRepository repo = new ClaimRepository();
        return repo.retrieveActorById(claimId);
    };

    public void initPage(String claimId) {
        this.claimId = claimId;

        TaskRunner<InsuranceClaim> runner = new TaskRunner<>();
        runner.run(this::fetchClaim, success -> {
            InsuranceClaim claim = runner.getResult();

            if (claim == null) return;

            SystemUser user = claim.getCustomer();

            id.setText(claim.getClaimId());
            customer.getChildren().add(new UserHyperlink(user).getRoot());
            status.setText(claim.getStatus().toString());
            amount.setText(Double.toString(claim.getAmount()));
            examDate.setText(claim.getExamDate().toString());
            claimDate.setText(claim.getClaimDate().toString());
            notes.setText(claim.getNote());
            bankName.setText(claim.getReceiverBankName());
            receiverName.setText(claim.getReceiverName());
            accountNumber.setText(claim.getReceiverBankNumber());

            uploadedDocsContainer.getChildren().add(new UploadedDocs(claim.getDocuments()).getRoot());
        });

    }

    public void setActionField(Node actionField) {
        actionFieldContainer.getChildren().add(actionField);
    }


}
