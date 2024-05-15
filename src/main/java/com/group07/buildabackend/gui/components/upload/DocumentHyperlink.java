package com.group07.buildabackend.gui.components.upload;

import com.group07.buildabackend.backend.model.insuranceClaim.Document;
import com.group07.buildabackend.gui.components.Component;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import java.awt.Desktop;
import java.net.URI;

public class DocumentHyperlink extends Component {

    public DocumentHyperlink(Document doc) {
        // Source: https://www.reddit.com/r/javahelp/comments/4bqcci/how_to_make_a_link_hyperlink_in_javafx/
        Hyperlink link = new Hyperlink(doc.getTitle());
        link.setOnAction(event -> {
            if(Desktop.isDesktopSupported())
            {
                try {
                    Desktop.getDesktop().browse(new URI(doc.getUrl()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        root = link;
    }

}
