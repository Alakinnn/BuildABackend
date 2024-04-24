module com.group07.buildabackend {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.group07.buildabackend to javafx.fxml;
    exports com.group07.buildabackend;
    exports com.group07.buildabackend.gui;
    opens com.group07.buildabackend.gui to javafx.fxml;

//    opens com.group07.buildabackend.gui to javafx.fxml;
//    exports com.group07.buildabackend.gui;
}