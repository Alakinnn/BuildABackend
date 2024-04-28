package com.group07.buildabackend.gui.pages.holder;

import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.upload.FileFilter;
import com.group07.buildabackend.gui.components.upload.FileUpload;
import com.group07.buildabackend.gui.components.upload.PDFFilterDecorator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddClaimInfoFormController implements Initializable, ComponentController {
    @FXML
    public Text claimId;
    @FXML
    public TextArea notes;

    @FXML
    private AnchorPane uploadedDocContainer;

    private FileUpload fileUpload;
    // TODO: add persistence for uploadedDocs when retrieving from DB
    private List<File> uploadedDocs;
    public AddClaimInfoFormController() {
        uploadedDocs = new ArrayList<>();
        fileUpload = new FileUpload(new PDFFilterDecorator(new FileFilter()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        uploadedDocContainer.getChildren().add(fileUpload.getRoot());
    }

    public void onUploadDoc(ActionEvent event) {
        uploadedDocs = fileUpload.onUpload();
    }

    public void setClaimId(String newId) {
        claimId.setText(newId);
    }
}
