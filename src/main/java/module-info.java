module com.group07.buildabackend {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.group07.buildabackend to javafx.fxml;
    exports com.group07.buildabackend;
    exports com.group07.buildabackend.gui;
    opens com.group07.buildabackend.gui to javafx.fxml;
    exports com.group07.buildabackend.gui.nav;
    opens com.group07.buildabackend.gui.nav to javafx.fxml;
    exports com.group07.buildabackend.gui.header;
    opens com.group07.buildabackend.gui.header to javafx.fxml;
    exports com.group07.buildabackend.gui.pages;
    opens com.group07.buildabackend.gui.pages to javafx.fxml;
    exports com.group07.buildabackend.gui.pages.claim;
    opens com.group07.buildabackend.gui.pages.claim to javafx.fxml;
    opens com.group07.buildabackend.gui.pages.surveyor to javafx.fxml;
    exports com.group07.buildabackend.gui.pages.surveyor;
    opens com.group07.buildabackend.gui.pages.holder to javafx.fxml;
    exports com.group07.buildabackend.gui.pages.holder;

}