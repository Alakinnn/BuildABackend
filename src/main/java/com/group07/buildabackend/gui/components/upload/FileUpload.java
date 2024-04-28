package com.group07.buildabackend.gui.components.upload;

import com.group07.buildabackend.gui.components.Component;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileUpload extends Component {

    public FileUpload() {
        super(FileUpload.class.getResource("FileUpload.fxml"));
    }

    public FileUpload(FileFilter filter) {
        this();
        ((FileUploadController) controller).setFileFilter(filter);
    }

    public List<File> onUpload() {
        return ((FileUploadController) controller).onUpload();
    }

}
