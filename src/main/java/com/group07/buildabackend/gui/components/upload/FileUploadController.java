package com.group07.buildabackend.gui.components.upload;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.upload.filters.FileFilter;
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

public class FileUploadController implements Initializable, ComponentController {
    @FXML
    public FlowPane uploadedFileContainer;
    private List<File> uploadedFiles;
    private FileFilter fileFilter;

    public FileUploadController() {
        this.uploadedFiles = new ArrayList<>();
    }

    public List<File> onUpload() {
        // Source: https://stackoverflow.com/questions/60184035/java-fx-image-upload-from-file
        try {

            FileChooser fileChooser = fileFilter.getChooser();
            File file = fileChooser.showOpenDialog(null);

            if (file == null) return uploadedFiles;

            uploadedFiles.add(file);
            uploadedFileContainer.getChildren().add(new Text(file.getName()));

            return uploadedFiles;
        } catch (Exception e) {
            return uploadedFiles;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        uploadedFileContainer.setHgap(10);
    }

    public List<File> getUploadedFiles() {
        return uploadedFiles;
    }

    public void setFileFilter(FileFilter fileFilter) {
        this.fileFilter = fileFilter;
    }
}
