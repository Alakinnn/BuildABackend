package com.group07.buildabackend.gui.components.upload.filters;

import javafx.stage.FileChooser;

public class PDFFilterDecorator extends FileFilter {
    private FileFilter filter;
    public PDFFilterDecorator(FileFilter filter) {
        this.filter = filter;
    }

    @Override
    public FileChooser getChooser() {
        FileChooser.ExtensionFilter pdfFilter = new FileChooser.ExtensionFilter("pdf files (*.pdf)", "*.pdf");

        FileChooser chooser = filter.getChooser();
        chooser.getExtensionFilters().add(pdfFilter);

        return chooser;
    }
}
