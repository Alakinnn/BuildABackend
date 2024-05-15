package com.group07.buildabackend.gui.components.user.controllers;

import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.insuranceCard.InsuranceCard;
import com.group07.buildabackend.backend.repository.SystemUserRepository;
import com.group07.buildabackend.gui.components.ComponentController;
import com.group07.buildabackend.gui.components.card.InsuranceCardView;
import com.group07.buildabackend.gui.components.user.UserActionList;
import com.group07.buildabackend.gui.components.utils.ActionField;
import com.group07.buildabackend.gui.tasks.TaskRunner;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class UserProfileController implements ComponentController {
    @FXML
    private Text id;
    @FXML
    private Text fullName;
    @FXML
    private Text email;
    @FXML
    private Text address;
    @FXML
    private Text phone;
    @FXML
    private Text role;
    @FXML
    private HBox insuranceCardContainer;
    @FXML
    private HBox actionHistoryContainer;
    @FXML
    private HBox actionFieldContainer;

    private String userId;

    private SystemUser fetchUser() {
        // TODO: Use controller
        SystemUserRepository repo = new SystemUserRepository();
        return repo.retrieveActorById(userId);
    }

    private InsuranceCard fetchCard() {
        // TODO: BE implement fetch card;
        return null;
    }

    public void initPage(String userId) {
        this.userId = userId;

        TaskRunner<SystemUser> runner = new TaskRunner<>(this::fetchUser, user -> {
            if (user == null) return;

            id.setText(user.getUserId());
            fullName.setText(user.getFullName());
            email.setText(user.getEmail());
            address.setText(user.getAddress());
            phone.setText(user.getPhone());
            role.setText(user.getUserType().toString());

            actionHistoryContainer.getChildren().add(new UserActionList(userId).getRoot());

            TaskRunner<InsuranceCard> cardRunner = new TaskRunner<>(this::fetchCard, card -> {
                if (card == null) return;
                insuranceCardContainer.getChildren().add(new InsuranceCardView(card).getRoot());
            });

            cardRunner.run();
        });

        runner.run();

    }

    public void setActionField(ActionField actionField) {
        actionFieldContainer.getChildren().add(actionField.getRoot());
    }

}
