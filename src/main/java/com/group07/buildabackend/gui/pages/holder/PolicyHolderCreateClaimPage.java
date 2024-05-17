package com.group07.buildabackend.gui.pages.holder;

import com.group07.buildabackend.backend.controller.PolicyHolderController;
import com.group07.buildabackend.backend.dto.systemUserDTO.customerDTO.beneficiaryDTO.DependentDTO;
import com.group07.buildabackend.backend.model.customer.Dependent;
import com.group07.buildabackend.backend.repository.PolicyHolderRepository;
import com.group07.buildabackend.gui.components.claim.CreateClaimForm;
import com.group07.buildabackend.gui.components.header.HeaderDecorator;
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

    private List<Dependent> retrieveDependents() {
        // TODO: Use controllers instead
        PolicyHolderRepository repo = new PolicyHolderRepository();
        List<Dependent> dependents = repo.retrieveAllDependent(phId);

        return dependents;
    }

    @Override
    public Node getRoot() {
        CreateClaimForm form = new CreateClaimForm();

        TaskRunner<List<Dependent>> runner = new TaskRunner<>(this::retrieveDependents, dependents -> {
            List<ChoiceField<String>> choices = new ArrayList<>();

            choices.add(new ChoiceField<>("Myself", phId));
            for (Dependent dependent : dependents) {
                String label = dependent.getFullName() + " (" + dependent.getUserId() + ")";
                choices.add(new ChoiceField<>(label, dependent.getUserId()));
            }
            form.setCustomerChoices(choices);
        });

        runner.run();

        root = form.getRoot();
        Page page = new HeaderDecorator(new Page(root), "File New Claim");
        page = new NavDecorator(page);

        return page.getRoot();
    }
}
