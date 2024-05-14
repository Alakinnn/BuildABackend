package com.group07.buildabackend.gui.pages.factories;

import com.group07.buildabackend.gui.pages.Page;

public interface PageFactory {
    Page createDefaultPage();
    Page createClaimViewPage(String claimId);
}
