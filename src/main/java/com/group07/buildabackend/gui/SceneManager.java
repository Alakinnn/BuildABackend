package com.group07.buildabackend.gui;

import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.pages.claim.CreateClaimPage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {
    private static SceneManager instance;
    private Scene currentScene;
    private Stage currentStage;

    public SceneManager() {
        Page defaultPage = new CreateClaimPage();
        Parent root = (Parent) defaultPage.getRoot();

        currentScene = new Scene(root);
        currentStage = new Stage();
        currentStage.setScene(currentScene);
    }

    public static SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }

        return instance;
    }

    public void switchToScene(Scene scene) {
        // FIXME: screen size changes when switching scene??
        currentScene = scene;

        currentStage.setScene(currentScene);
        currentStage.show();
    }

    public void switchToPage(Page page) {
        currentScene = new Scene((Parent) page.getRoot());

        currentStage.setScene(currentScene);
        currentStage.show();
    }

    public Scene getCurrentScene() {
        return currentScene;
    }

    public Stage getCurrentStage() {
        return currentStage;
    }

}
