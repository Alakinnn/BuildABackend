package com.group07.buildabackend.gui.pages.holder;

import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.form.FormController;
import com.group07.buildabackend.gui.components.form.fields.FormFileUpload;
import com.group07.buildabackend.gui.components.upload.FileFilter;
import com.group07.buildabackend.gui.components.upload.FileUpload;
import com.group07.buildabackend.gui.components.upload.PDFFilterDecorator;
import com.group07.buildabackend.gui.exceptions.MissingRequiredFieldException;
import com.group07.buildabackend.gui.sample.ClaimAddInfoRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class AddClaimInfoFormController extends FormController implements Initializable, ComponentController {
    @FXML
    public Text claimId;
    @FXML
    public TextArea notes;
    @FXML
    private AnchorPane uploadedDocContainer;
    private FileUpload docUploader;

    // TODO: add persistence for uploadedDocs when retrieving from DB
    public AddClaimInfoFormController() {
        docUploader = new FileUpload(new PDFFilterDecorator(new FileFilter()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        uploadedDocContainer.getChildren().add(docUploader.getRoot());
        addRequiredField(new FormFileUpload(docUploader, "Documents"));
    }

    public void onSubmit(ActionEvent event) {
        try {
            checkRequiredFields();
            ClaimAddInfoRequest request = new ClaimAddInfoRequest();
            request.setClaimId(claimId.getText());
            request.setDocuments(docUploader.getUploadedFiles());
            // TODO: pass to controller

        } catch (MissingRequiredFieldException e) {
            System.out.println(e.getMessage());
        }


    }

    public void onUploadDoc(ActionEvent event) {
        docUploader.onUpload();
    }

    public void setClaimId(String newId) {
        claimId.setText(newId);
    }
}
