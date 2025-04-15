package com.example;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MainController {

    Stage stage = new Stage();

    @FXML
    public void initialize() {
        System.out.println("initialize");
        App._stage.setOnCloseRequest(event -> {
            System.out.println("onCloseRequest...");

            StringBuilder content = new StringBuilder();
            for (String car : carList.getItems()) {
                content.append(car);
                content.append(",");
            }
            Store.writeCars(content.toString());
        });
    }

    @FXML
    public ListView<String> carList;


    
    @FXML
    void onClickDelButton(ActionEvent event) {
        System.out.println("Deletion in progress...");
        int index = this.carList.getSelectionModel().getSelectedIndex();
        if(index == -1) {
            System.err.println("Hiba! Jelölj ki először valamit!");
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Kiválasztás");
            alert.setTitle("Hiba!");
            alert.setContentText("Hiba! Jelölj ki elöször egy rendszámot!");
            alert.showAndWait();
            return;
        }
        String res = this.carList.getItems().remove(index);
 
        System.out.println("Törölve: " + res);

    }

    @FXML
    void onClickExitButton(ActionEvent event) {

    }

    @FXML
    void onClickModifyButton(ActionEvent event) {
        System.out.println("Modification in progress...");
        int index = this.carList.getSelectionModel().getSelectedIndex();
        if(index == -1) {
            System.err.println("Hiba! Jelölj ki először valamit!");
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Kiválasztás");
            alert.setTitle("Hiba!");
            alert.setContentText("Hiba! Jelölj ki elöször egy rendszámot!");
            alert.showAndWait();
            return;
        }
        String old = this.carList.getItems().remove(index);
        TextInputDialog dialog = new TextInputDialog(old);
        dialog.setTitle("Módosítás");
        dialog.setHeaderText("Módosítsa a rendszámot!");
        dialog.setContentText("Rendszám: ");
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            this.carList.getItems().add(index, result.get());
            System.out.println("Módosítva: " + old + " -> " + result.get());
        } else {
            this.carList.getItems().add(index, old);
            System.out.println("Módosítás megszakítva!");
        }

    }

    @FXML
    void onClickAddButton(ActionEvent event) { 
        showDialog();
    }

    void showDialog() {
        try {
            tryShowDialog();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    void tryShowDialog() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dialogScene.fxml"));
        Scene scene = new Scene(loader.load());
       
        stage.setScene(scene);
        stage.show();

        DialogController dialogController = loader.getController();
        dialogController.setMainController(this);
    }

}
