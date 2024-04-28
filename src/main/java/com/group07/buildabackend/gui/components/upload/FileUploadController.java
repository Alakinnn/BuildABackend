package com.group07.buildabackend.gui.components.upload;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FileUploadController implements Initializable, ComponentController{
    // TODO: add a remove feature for uploaded files? (be careful with DB persistence tho)
    // TODO: display file as a hyperlink that can be downloaded?

    @FXML
    public FlowPane uploadedFileContainer;
    private List<File> uploadedFile;
    private FileFilter fileFilter;

    public FileUploadController() {
        this.uploadedFile = new ArrayList<>();
    }

    public List<File> onUpload() {
        // Source: https://stackoverflow.com/questions/60184035/java-fx-image-upload-from-file
        try {

            FileChooser fileChooser = fileFilter.getChooser();
            File file = fileChooser.showOpenDialog(null);

            uploadedFile.add(file);
            uploadedFileContainer.getChildren().add(new Text(file.getName()));

            return uploadedFile;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        uploadedFileContainer.setHgap(10);
    }

    public void setFileFilter(FileFilter fileFilter) {
        this.fileFilter = fileFilter;
    }
}
