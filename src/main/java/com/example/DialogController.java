package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class DialogController {

    MainController mainController;

    
    @FXML
    public TextField plateField;

    @FXML
    void onClickSaveButton(ActionEvent event) {
        // Stage stage = (Stage) (((javafx.scene.Node) event.getSource()).getScene().getWindow());
        // stage.close();

        if(plateField.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Hiba!");
            alert.setTitle("Hiba!");
            alert.setContentText("A rendszám nem lehet üres!");
            alert.showAndWait();
            return;
        }

        mainController.carList.getItems().add(plateField.getText());
        mainController.stage.close();

    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    private void startClose(){
        mainController.carList.getItems().add(plateField.getText());
        mainController.stage.close();

    }


    
    // @FXML
    // void onTextChangedPlateField(InputMethodEvent event) {
    //     System.out.println("Button pressed");
    // }


    
    @FXML
    void onKeyReleasedPlateField(KeyEvent event) {

        if(event.getCode() == KeyCode.ENTER) {
            startClose();
        }
        


    }

}
