package com.group07.buildabackend.gui.pages.claim;

import com.group07.buildabackend.backend.model.SysUser;
import com.group07.buildabackend.backend.model.customer.Customer;
import com.group07.buildabackend.backend.model.customer.PolicyHolder;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaim;
import com.group07.buildabackend.backend.model.insuranceClaim.InsuranceClaimStatus;
import com.group07.buildabackend.gui.components.claim.ClaimList;
import com.group07.buildabackend.gui.components.claim.ClaimListController;
import com.group07.buildabackend.gui.pages.Page;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

import java.io.IOException;
import java.time.LocalDate;

public class ClaimListPage extends Page {
    @Override
    public Node getRoot() {
        Customer user = new PolicyHolder();
        user.setFirstName("Khoa");
        user.setLastName("Bui");

        ClaimList claimList = new ClaimList();
        InsuranceClaim i1 = new InsuranceClaim();
        i1.setClaimId("123");
        i1.setStatus(InsuranceClaimStatus.NEW);
        i1.setClaimDate(LocalDate.now());
        i1.setAmount(43200);
        i1.setCustomer(user);

        InsuranceClaim i2 = new InsuranceClaim();
        i2.setClaimId("456");
        i2.setStatus(InsuranceClaimStatus.PROPOSED);
        i2.setClaimDate(LocalDate.now());
        i2.setAmount(96500);
        i2.setCustomer(user);

        claimList.addClaim(i1);
        claimList.addClaim(i2);

        return claimList.getRoot();
    }
}
