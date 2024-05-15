package com.group07.buildabackend.gui.components.upload;

import com.group07.buildabackend.gui.components.ControlledComponent;
import com.group07.buildabackend.gui.components.upload.filters.FileFilter;

import java.io.File;
import java.util.List;

public class FileUpload extends ControlledComponent<FileUploadController> {

    public FileUpload() {
        super(FileUpload.class.getResource("FileUpload.fxml"));
    }

    public FileUpload(FileFilter filter) {
        this();
        controller.setFileFilter(filter);
    }

    public List<File> onUpload() {
        return controller.onUpload();
    }

    public List<File> getUploadedFiles() {
        return controller.getUploadedFiles();
    }

}
