package com.group07.buildabackend.gui.pages.owner;

import com.group07.buildabackend.backend.controller.PolicyOwnerController;
import com.group07.buildabackend.backend.model.customer.Beneficiary;
import com.group07.buildabackend.backend.model.customer.Dependent;
import com.group07.buildabackend.backend.repository.PolicyOwnerRepository;
import com.group07.buildabackend.gui.components.claim.CreateClaimForm;
import com.group07.buildabackend.gui.components.header.HeaderDecorator;
import com.group07.buildabackend.gui.components.nav.NavDecorator;
import com.group07.buildabackend.gui.pages.Page;
import com.group07.buildabackend.gui.tasks.TaskRunner;
import com.group07.buildabackend.gui.utils.ChoiceField;
import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

public class PolicyOwnerCreateClaimPage extends Page {
    private String poId;

    public PolicyOwnerCreateClaimPage(String poId) {
        this.poId = poId;
    }

    private List<Beneficiary> retrieveBeneficiaries() {
        PolicyOwnerController controller = new PolicyOwnerController();

        return controller.retrieveAllBeneficiaries(poId).getData();
    }

    @Override
    public Node getRoot() {
        CreateClaimForm form = new CreateClaimForm();

        TaskRunner<List<Beneficiary>> runner = new TaskRunner<>(this::retrieveBeneficiaries, beneficiaries -> {
            List<ChoiceField<String>> choices = new ArrayList<>();

            for (Beneficiary beneficiary : beneficiaries) {
                String label = beneficiary.getFullName() + " (" + beneficiary.getUserId() + ")";
                choices.add(new ChoiceField<>(label, beneficiary.getUserId()));
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
