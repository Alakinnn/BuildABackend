package com.group07.buildabackend.gui.pages.holder;

import com.group07.buildabackend.backend.controller.PolicyHolderController;
import com.group07.buildabackend.backend.controller.Response;
import com.group07.buildabackend.backend.dto.insuranceClaimDTO.AddClaimInfoDTO;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.repository.ClaimRepository;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.form.FormController;
import com.group07.buildabackend.gui.components.form.fields.FormFileUpload;
import com.group07.buildabackend.gui.components.upload.FileFilter;
import com.group07.buildabackend.gui.components.upload.FileUpload;
import com.group07.buildabackend.gui.components.upload.PDFFilterDecorator;
import com.group07.buildabackend.gui.tasks.TaskRunner;
import com.group07.buildabackend.gui.utils.AlertManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class AddClaimInfoFormController extends FormController<InsuranceClaim> implements Initializable, ComponentController {
    @FXML
    private Text claimIdLabel;
    @FXML
    private TextArea notes;
    @FXML
    private AnchorPane uploadedDocContainer;
    private FileUpload docUploader;
    private String claimId;


    public AddClaimInfoFormController() {
        docUploader = new FileUpload(new PDFFilterDecorator(new FileFilter()));
    }

    @Override
    public Response<InsuranceClaim> sendRequest() {
        AddClaimInfoDTO request = new AddClaimInfoDTO();
        request.setId(claimIdLabel.getText());
        request.setDocuments(docUploader.getUploadedFiles());

        PolicyHolderController controller = new PolicyHolderController();
        return controller.addClaimInfo(request);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        uploadedDocContainer.getChildren().add(docUploader.getRoot());
        addRequiredField(new FormFileUpload(docUploader, "Documents"));
    }

    public void onUploadDoc(ActionEvent event) {
        docUploader.onUpload();
    }

    private InsuranceClaim fetchClaim() {
        // TODO: controllers instead of repo
        ClaimRepository repo = new ClaimRepository();
        return repo.retrieveActorById(claimId);
    }

    public void initPage(String claimId) {
        this.claimId = claimId;

        TaskRunner<InsuranceClaim> runner = new TaskRunner<>();
        runner.run(this::fetchClaim, success -> {
            InsuranceClaim claim = runner.getResult();

            if (claim == null) return;

            claimIdLabel.setText(claimId);
            notes.setText(claim.getNote());
        });
    }
}
