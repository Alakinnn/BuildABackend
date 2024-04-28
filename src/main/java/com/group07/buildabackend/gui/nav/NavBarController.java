package com.group07.buildabackend.gui.nav;

import com.group07.buildabackend.gui.pages.claim.CreateClaimPage;
import com.group07.buildabackend.gui.pages.surveyor.RequestClaimInfoPage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class NavBarController implements Initializable {
    @FXML
    private VBox navBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        navBox.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        // TODO: add actual navigation
        List<Node> sampleNodes = new ArrayList<>();

        // TODO: generalize adding links & add labels to links

        sampleNodes.add((new NavLink(new CreateClaimPage())).getRoot());
        sampleNodes.add(new NavLink(new RequestClaimInfoPage()).getRoot());

        navBox.getChildren().addAll(sampleNodes);
    }

}
