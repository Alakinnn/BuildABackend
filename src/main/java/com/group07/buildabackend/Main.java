package com.group07.buildabackend;

import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.pages.claim.CreateClaimPage;
import com.group07.buildabackend.gui.pages.surveyor.RequestClaimInfoPage;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Page page = new RequestClaimInfoPage();
        Parent root = (Parent)(page).getRoot();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
}
