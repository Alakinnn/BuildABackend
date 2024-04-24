package com.group07.buildabackend;

import com.group07.buildabackend.gui.HelloApplication;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        HelloApplication application = new HelloApplication();
        application.start(stage);
    }
}
