package com.group07.buildabackend.gui.nav;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class NavBar implements Initializable {
    @FXML
    private VBox navBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        navBox.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        // TODO: add actual navigation
        Node[] sampleNodes = {new Text("Nav 1"), new Text("Nav 2"), new Text("Nav 3")};
        navBox.getChildren().addAll(sampleNodes);
    }
}
