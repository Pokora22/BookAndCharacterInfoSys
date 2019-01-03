package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;


public class MainController {

    @FXML
    private TextField searchField;

    @FXML
    private BorderPane window;

    public Scene sourceScene;

    @FXML
    private void openBooks() throws IOException { //opens the book list
        setSourceScene(sourceScene);
        window.getScene().setRoot(FXMLLoader.load(getClass().getResource("../fxml/BookList.fxml")));
    }

    @FXML
    private void openCharacters() throws IOException { //opens the character list
        setSourceScene(sourceScene);
        window.getScene().setRoot(FXMLLoader.load(getClass().getResource("../fxml/BookCharacterList.fxml")));

    }

    @FXML
    private void search(){ //takes the searched input and lists both books and characters


    }

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
}
