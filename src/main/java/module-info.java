module com.group07.buildabackend {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
//    requires cloudinary.taglib;
    requires cloudinary.core;
    requires dotenv.java;

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
    opens com.group07.buildabackend.gui.pages.surveyor to javafx.fxml;
    exports com.group07.buildabackend.gui.pages.surveyor;
    opens com.group07.buildabackend.gui.pages.holder to javafx.fxml;
    exports com.group07.buildabackend.gui.pages.holder;
    opens com.group07.buildabackend.gui.pages.manager to javafx.fxml;
    exports com.group07.buildabackend.gui.pages.manager;
    opens com.group07.buildabackend.gui.components.upload to javafx.fxml;
    exports com.group07.buildabackend.gui.components.upload;
    exports com.group07.buildabackend.gui.components;
    opens com.group07.buildabackend.gui.components to javafx.fxml;
    exports com.group07.buildabackend.gui.utils;
    opens com.group07.buildabackend.gui.utils to javafx.fxml;
    exports com.group07.buildabackend.gui.components.form;
    opens com.group07.buildabackend.gui.components.form to javafx.fxml;

    exports com.group07.buildabackend.backend.utils.idGenerator to org.hibernate.orm.core;
    opens com.group07.buildabackend.backend.model.provider to org.hibernate.orm.core;
    opens com.group07.buildabackend.backend.model.insuranceCard to org.hibernate.orm.core;
    exports com.group07.buildabackend.backend.utils.userType to org.hibernate.orm.core;
}