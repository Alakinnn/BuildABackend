package com.group07.buildabackend.gui.components.utils;

import com.group07.buildabackend.gui.components.Component;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.List;

public class ActionField extends Component {
    public ActionField() {
        HBox hBox = new HBox();

        hBox.setAlignment(Pos.CENTER_RIGHT);
        hBox.setSpacing(20);

        root = hBox;
    }

    public void addButton(Node button) {
        ((HBox) root).getChildren().add(button);
    }

}
