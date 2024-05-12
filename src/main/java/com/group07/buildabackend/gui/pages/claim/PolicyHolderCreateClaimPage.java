package com.group07.buildabackend.gui.pages.claim;

import com.group07.buildabackend.backend.authentication.CurrentUserManager;
import com.group07.buildabackend.backend.controller.PolicyHolderController;
import com.group07.buildabackend.backend.dto.beneficiaryDTO.DependentDTO;
import com.group07.buildabackend.backend.model.SystemUser;
import com.group07.buildabackend.backend.model.customer.Dependent;
import com.group07.buildabackend.backend.repository.DependentRepository;
import com.group07.buildabackend.backend.repository.PolicyHolderRepository;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.tasks.TaskRunner;
import com.group07.buildabackend.gui.utils.ChoiceField;
import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

public class PolicyHolderCreateClaimPage extends Page {
    private String phId;
    public PolicyHolderCreateClaimPage(String phId) {
        this.phId = phId;
    }


    @Override
    public Node getRoot() {
        CreateClaimForm form = new CreateClaimForm();

        // Use controllers instead
        PolicyHolderRepository repo = new PolicyHolderRepository();
        List<Dependent> dependents = repo.retrieveAllDependent(phId);

        TaskRunner<SystemUser> runner = new TaskRunner<>();
        List<ChoiceField<String>> choices = new ArrayList<>();

        choices.add(new ChoiceField<>("Myself", phId));
        form.setCustomerChoices(choices);

        root = form.getRoot();

        Page page = new NavDecorator(new Page(root));

        return page.getRoot();
    }

    public static void main(String[] args) {
        PolicyHolderController controller = new PolicyHolderController();
        DependentDTO dto = new DependentDTO();
        dto.setPolicyHolderId("u_bc7abc35");
        dto.setFirstName("Khoa");
        dto.setLastName("Bui");
        dto.setEmail("khoa@gaymail.com");
        dto.setPwd("12345");
        dto.setPhone("4242355235");
        dto.setAddress("312 Gay Str.");
        controller.createNewDependent(dto);
    }
}
