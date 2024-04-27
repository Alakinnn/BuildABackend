package com.group07.buildabackend.gui.nav;

import com.group07.buildabackend.gui.pages.claim.CreateClaimPage;
import com.group07.buildabackend.gui.pages.surveyor.RequestClaimInfoPage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class NavBar implements Initializable {
    @FXML
    private VBox navBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        navBox.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        // TODO: add actual navigation
        List<Node> sampleNodes = new ArrayList<>();

        sampleNodes.add((new NavLink(new CreateClaimPage())).getNavButton());
        sampleNodes.add((new NavLink(new RequestClaimInfoPage())).getNavButton());

        navBox.getChildren().addAll(sampleNodes);
    }
}
