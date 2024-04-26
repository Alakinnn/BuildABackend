package com.group07.buildabackend.gui.header;

import com.group07.buildabackend.gui.Page;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Header implements Initializable {
    @FXML
    private Text title;
    @FXML
    private HBox headerContainer;

    public Header() {
    }


    public void setTitle(String s) {
        title.setText(s);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        headerContainer.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
