package com.group07.buildabackend;

import com.group07.buildabackend.gui.CreateClaimPage;
import com.group07.buildabackend.gui.Page;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("gui/CreateClaimForm.fxml"));
        Parent root = (Parent) (new CreateClaimPage()).getRoot();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
}
