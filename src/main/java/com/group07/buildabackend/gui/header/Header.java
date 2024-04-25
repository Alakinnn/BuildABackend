package com.group07.buildabackend.gui.header;

import com.group07.buildabackend.gui.Page;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class Header {
    @FXML
    private Text title;

    public Header() {
    }


    public void setTitle(String s) {
        title.setText(s);
    }
}
