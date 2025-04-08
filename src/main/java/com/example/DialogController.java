package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DialogController {

    MainController mainController;

    
    @FXML
    public TextField plateField;

    @FXML
    void onClickSaveButton(ActionEvent event) {
        // Stage stage = (Stage) (((javafx.scene.Node) event.getSource()).getScene().getWindow());
        // stage.close();


        mainController.carList.getItems().add(plateField.getText());
        mainController.stage.close();

    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

}
