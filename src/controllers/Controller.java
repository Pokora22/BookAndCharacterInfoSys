package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    private Scene sourceScene;

    public void setSourceScene(Scene sourceScene) {
        if (sourceScene != null) {
            this.sourceScene = sourceScene;
        }
        else{
            Pane pane = new Pane();
            Label labelGoofed = new Label("Done goofed. This should point to previous scene");
            pane.getChildren().add(labelGoofed);
            this.sourceScene = new Scene(pane);
        }
    }

    @FXML
    protected void goBack(ActionEvent actionEvent){
        Stage sourceStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

        sourceStage.setTitle("Restaurant Management");
        sourceStage.setScene(sourceScene);
    }

    protected void changeScene(ActionEvent actionEvent, String fxmlLocation) throws IOException {
        Stage sourceStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlLocation));
        Parent root = loader.load();
        Controller controller = loader.getController();
        controller.setSourceScene(sourceStage.getScene());
        sourceStage.setScene(new Scene(root));
    }
}
