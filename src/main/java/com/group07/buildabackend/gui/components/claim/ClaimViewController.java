package com.group07.buildabackend.gui.components.claim;

import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.repository.ClaimRepository;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.upload.UploadedDocs;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ClaimViewController implements ComponentController {
    @FXML
    private Text id;

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
    private Text receiverName;
    @FXML
    private Text accountNumber;
    @FXML
    private HBox uploadedDocsContainer;
    @FXML
    private HBox actionFieldContainer;

    public void initPage(String claimId) {
        ClaimRepository repo = new ClaimRepository();
        InsuranceClaim claim = repo.retrieveActorById(claimId);

        if (claim == null) return;

        id.setText(claim.getClaimId());
        status.setText(claim.getStatus().toString());
        amount.setText(Double.toString(claim.getAmount()));
        examDate.setText(claim.getExamDate().toString());
        claimDate.setText(claim.getClaimDate().toString());
        bankName.setText(claim.getReceiverBankName());
        receiverName.setText(claim.getReceiverName());
        accountNumber.setText(claim.getReceiverBankNumber());

        uploadedDocsContainer.getChildren().add(new UploadedDocs(claim.getDocuments()).getRoot());
    }

    public void setActionField(Node actionField) {
        actionFieldContainer.getChildren().add(actionField);
    }


}
