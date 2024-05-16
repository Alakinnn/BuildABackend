package com.group07.buildabackend.gui;

import com.group07.buildabackend.backend.authentication.service.LoginService;
import com.group07.buildabackend.backend.controller.AdminController;
import com.group07.buildabackend.backend.dto.authenticationDTO.LoginInfoDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO.PolicyOwnerDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.provider.InsuranceSurveyorDTO;
import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.pages.auth.LoginPage;
import com.group07.buildabackend.gui.pages.claim.CreateClaimPage;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SceneManager {
    private static SceneManager instance;
    private StackPane currentRoot;
    private Scene currentScene;
    private Stage currentStage;

    private SceneManager() {
        Page defaultPage = new LoginPage();
        currentRoot = new StackPane();
        currentRoot.getChildren().add(defaultPage.getRoot());

        currentScene = new Scene(currentRoot);
        currentStage = new Stage();
        currentStage.setScene(currentScene);
    }

    public static SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }

        return instance;
    }

    public void switchToPage(Page page) {
        currentRoot.getChildren().set(0, page.getRoot());
    }

    public Stage getCurrentStage() {
        return currentStage;
    }

    public void startLoading() {
        ProgressIndicator indicator = new ProgressIndicator();
        currentRoot.getChildren().add(indicator);
    }

    public void endLoading() {
        if (currentRoot.getChildren().size() <= 1) {
            // Avoid deleting root page if called wrongly
            return;
        }
        currentRoot.getChildren().remove(1);
    }

}
