package com.group07.buildabackend.gui;

import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.pages.claim.CreateClaimPage;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SceneManager {
    private static SceneManager instance;
    private BorderPane currentRoot;
    private Scene currentScene;
    private Stage currentStage;

    public SceneManager() {
        Page defaultPage = new CreateClaimPage();
        currentRoot = new BorderPane(defaultPage.getRoot());

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
        currentRoot.setCenter(page.getRoot());
    }

    public Stage getCurrentStage() {
        return currentStage;
    }

    public void setCursorLoading() {
        currentScene.setCursor(Cursor.WAIT);
    }

    public void setCursorDefault() {
        currentScene.setCursor(Cursor.DEFAULT);
    }

}
