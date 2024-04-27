package com.group07.buildabackend.gui;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {
    private static SceneManager instance;
    private Scene currentScene;
    private Stage currentStage;


    public static SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }

        return instance;
    }

    public void switchRoot(Parent root) {
        currentScene = new Scene(root);

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
