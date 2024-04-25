package com.group07.buildabackend.gui.nav;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class NavBar implements Initializable {
    @FXML
    private VBox navBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // TODO: add actual navigation
        Node[] sampleNodes = {new Text("Nav 1"), new Text("Nav 2"), new Text("Nav 3")};
        navBox.getChildren().addAll(sampleNodes);
    }
}
