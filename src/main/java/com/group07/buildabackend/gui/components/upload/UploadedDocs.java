package com.group07.buildabackend.gui.components.upload;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.model.insuranceClaim.Document;
import com.group07.buildabackend.gui.components.Component;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;

import java.util.List;

public class UploadedDocs extends Component {
    public UploadedDocs(List<Document> docs) {
        VBox vBox = new VBox();

        for (Document doc: docs) {
            vBox.getChildren().add(new DocumentHyperlink(doc).getRoot());
        }

        root = vBox;
    }
}
