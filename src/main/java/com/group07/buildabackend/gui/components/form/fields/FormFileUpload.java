package com.group07.buildabackend.gui.components.form.fields;

/**
 * @author Group_7
 */

import com.group07.buildabackend.gui.components.upload.FileUpload;

import java.io.File;
import java.util.List;

public class FormFileUpload extends FormField<FileUpload, List<File>> {

    public FormFileUpload(FileUpload control, String label) {
        super(control, label);
    }

    @Override
    public List<File> getValue() {
        return control.getUploadedFiles();
    }

    @Override
    public boolean isEmpty() {
        return control.getUploadedFiles().size() == 0;
    }
}
