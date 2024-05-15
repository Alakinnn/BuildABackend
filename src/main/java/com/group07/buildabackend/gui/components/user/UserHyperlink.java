package com.group07.buildabackend.gui.components.user;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.authentication.service.LoginService;
import com.group07.buildabackend.backend.controller.AdminController;
import com.group07.buildabackend.backend.controller.Controller;
import com.group07.buildabackend.backend.dto.authenticationDTO.LoginInfoDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO.PolicyOwnerDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.provider.InsuranceManagerDTO;
import com.group07.buildabackend.backend.dto.systemUserDTO.provider.InsuranceSurveyorDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.provider.InsuranceSurveyor;
import com.group07.buildabackend.gui.SceneManager;
import com.group07.buildabackend.gui.components.Component;
import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.pages.factories.PageFactoryManager;
import com.group07.buildabackend.gui.pages.user.UserProfilePage;
import com.group07.buildabackend.gui.tasks.TaskRunner;
import javafx.scene.control.Hyperlink;

public class UserHyperlink extends Component {
    public String targetUserId;



    public UserHyperlink(SystemUser user) {
        targetUserId = user.getUserId();
        Hyperlink link = new Hyperlink(user.getFullName() + " (" + user.getUserId() + ")");
        link.setOnAction(event -> {
            Page page;
            SystemUser currentUser = CurrentUserManager.getCurrentUser();

            if (user.getUserId().equals(currentUser.getUserId())) {
                page =  PageFactoryManager.getFactory().createMyProfilePage();
                SceneManager.getInstance().switchToPage(page);
            } else {
                PageFactoryManager.getFactory().createPublicProfilePage(targetUserId,
                        publicPage -> SceneManager.getInstance().switchToPage(publicPage));
            }
        });

        root = link;
    }
}
