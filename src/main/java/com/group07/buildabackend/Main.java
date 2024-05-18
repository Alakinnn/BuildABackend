package com.group07.buildabackend;

/**
 * @author Group_7
 */

import com.group07.buildabackend.backend.connectionManager.DatabaseFactoryManager;
import com.group07.buildabackend.backend.dto.authenticationDTO.LoginInfoDTO;
import com.group07.buildabackend.gui.SceneManager;
import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.pages.claim.CreateClaimPage;
import com.group07.buildabackend.gui.pages.surveyor.RequestClaimInfoPage;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        DatabaseFactoryManager.connectDB();
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Stage currentStage = SceneManager.getInstance().getCurrentStage();

        currentStage.show();
    }
}
