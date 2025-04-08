package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class DialogController {

    @FXML
    void onClickCloseButton(ActionEvent event) {
        Stage stage = (Stage) (((javafx.scene.Node) event.getSource()).getScene().getWindow());
        stage.close();
        //((Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow()).close();
    }

}
