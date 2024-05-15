module com.group07.buildabackend {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    // requires cloudinary.taglib;
    requires cloudinary.core;
    requires dotenv.java;
    requires java.desktop;

    opens com.group07.buildabackend.backend.model to org.hibernate.orm.core;
    opens com.group07.buildabackend.backend.model.customer;
    opens com.group07.buildabackend.backend.model.insuranceClaim;

    opens com.group07.buildabackend to javafx.fxml;

    exports com.group07.buildabackend;
    exports com.group07.buildabackend.gui;

    opens com.group07.buildabackend.gui to javafx.fxml;

    exports com.group07.buildabackend.gui.components.nav;

    opens com.group07.buildabackend.gui.components.nav to javafx.fxml;

    exports com.group07.buildabackend.gui.components.header;

    opens com.group07.buildabackend.gui.components.header to javafx.fxml;

    exports com.group07.buildabackend.gui.pages;

    opens com.group07.buildabackend.gui.pages to javafx.fxml;

    exports com.group07.buildabackend.gui.pages.claim;

    opens com.group07.buildabackend.gui.pages.claim to javafx.fxml;

    exports com.group07.buildabackend.gui.pages.owner;

    opens com.group07.buildabackend.gui.pages.owner to javafx.fxml;

    exports com.group07.buildabackend.gui.pages.auth;

    opens com.group07.buildabackend.gui.pages.auth to javafx.fxml;
    opens com.group07.buildabackend.gui.pages.surveyor to javafx.fxml;

    exports com.group07.buildabackend.gui.pages.surveyor;

    opens com.group07.buildabackend.gui.pages.holder to javafx.fxml;

    exports com.group07.buildabackend.gui.pages.holder;

    opens com.group07.buildabackend.gui.pages.manager to javafx.fxml;

    exports com.group07.buildabackend.gui.pages.manager;

    opens com.group07.buildabackend.gui.components.upload to javafx.fxml;

    exports com.group07.buildabackend.gui.pages.dependent;

    opens com.group07.buildabackend.gui.pages.dependent to javafx.fxml;

    exports com.group07.buildabackend.gui.components.upload;
    exports com.group07.buildabackend.gui.components;

    opens com.group07.buildabackend.gui.components to javafx.fxml;

    exports com.group07.buildabackend.gui.utils;

    opens com.group07.buildabackend.gui.utils to javafx.fxml;

    exports com.group07.buildabackend.gui.components.form;

    opens com.group07.buildabackend.gui.components.form to javafx.fxml;

    exports com.group07.buildabackend.gui.components.claim;

    opens com.group07.buildabackend.gui.components.claim to javafx.fxml;

    exports com.group07.buildabackend.gui.components.user;

    opens com.group07.buildabackend.gui.components.user to javafx.fxml;

    exports com.group07.buildabackend.gui.components.card;

    opens com.group07.buildabackend.gui.components.card to javafx.fxml;

    exports com.group07.buildabackend.gui.components.auth;

    opens com.group07.buildabackend.gui.components.auth to javafx.fxml;

    exports com.group07.buildabackend.gui.components.dependent;
    exports com.group07.buildabackend.gui.components.holder;

    opens com.group07.buildabackend.gui.components.holder to javafx.fxml;
    opens com.group07.buildabackend.gui.components.dependent to javafx.fxml;

    exports com.group07.buildabackend.gui.components.owner;

    opens com.group07.buildabackend.gui.components.owner to javafx.fxml;

    exports com.group07.buildabackend.gui.components.surveyor;

    opens com.group07.buildabackend.gui.components.surveyor to javafx.fxml;

    exports com.group07.buildabackend.gui.pages.user;

    opens com.group07.buildabackend.gui.pages.user to javafx.fxml;

    exports com.group07.buildabackend.backend.utils.idGenerator to org.hibernate.orm.core;

    opens com.group07.buildabackend.backend.model.provider to org.hibernate.orm.core;
    opens com.group07.buildabackend.backend.model.insuranceCard to org.hibernate.orm.core;

    exports com.group07.buildabackend.gui.components.claim.btn;

    opens com.group07.buildabackend.gui.components.claim.btn to javafx.fxml;
    opens com.group07.buildabackend.backend.model.userAction to org.hibernate.orm.core;

    exports com.group07.buildabackend.gui.components.nav.factories;

    opens com.group07.buildabackend.gui.components.nav.factories to javafx.fxml;
    opens com.group07.buildabackend.backend.model.systemAdmin to org.hibernate.orm.core;

    exports com.group07.buildabackend.gui.components.user.controllers;

    opens com.group07.buildabackend.gui.components.user.controllers to javafx.fxml;

    exports com.group07.buildabackend.gui.components.upload.filters;

    opens com.group07.buildabackend.gui.components.upload.filters to javafx.fxml;

    exports com.group07.buildabackend.gui.components.surveyor.controllers;

    opens com.group07.buildabackend.gui.components.surveyor.controllers to javafx.fxml;

    exports com.group07.buildabackend.gui.components.surveyor.actionFields;

    opens com.group07.buildabackend.gui.components.surveyor.actionFields to javafx.fxml;

    exports com.group07.buildabackend.gui.components.owner.actionFields;

    opens com.group07.buildabackend.gui.components.owner.actionFields to javafx.fxml;

    exports com.group07.buildabackend.gui.components.owner.controllers;

    opens com.group07.buildabackend.gui.components.owner.controllers to javafx.fxml;

    exports com.group07.buildabackend.gui.components.nav.controllers;

    opens com.group07.buildabackend.gui.components.nav.controllers to javafx.fxml;

    exports com.group07.buildabackend.gui.components.holder.controllers;

    opens com.group07.buildabackend.gui.components.holder.controllers to javafx.fxml;

    exports com.group07.buildabackend.gui.components.holder.actionFields;

    opens com.group07.buildabackend.gui.components.holder.actionFields to javafx.fxml;

    exports com.group07.buildabackend.gui.components.dependent.controllers;

    opens com.group07.buildabackend.gui.components.dependent.controllers to javafx.fxml;

    exports com.group07.buildabackend.gui.components.claim.controllers;

    opens com.group07.buildabackend.gui.components.claim.controllers to javafx.fxml;

    exports com.group07.buildabackend.gui.components.card.controllers;

    opens com.group07.buildabackend.gui.components.card.controllers to javafx.fxml;

    exports com.group07.buildabackend.gui.components.auth.controllers;

    opens com.group07.buildabackend.gui.components.auth.controllers to javafx.fxml;
}