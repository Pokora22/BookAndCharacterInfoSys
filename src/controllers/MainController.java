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
import static main.Main.library;
import models.Book;
import models.Library;

import java.io.IOException;


public class MainController extends Controller {


    @FXML
    private TextField searchField;

    @FXML
    private BorderPane window;

    public Scene sourceScene;

    @FXML
    private void openBooks(ActionEvent actionEvent) throws IOException { //opens the book list
        changeScene(actionEvent, "../fxml/BookList.fxml");
    }

    @FXML
    private void openCharacters(ActionEvent actionEvent) throws IOException { //opens the character list
        changeScene(actionEvent, "../fxml/BookCharacterList.fxml");

    }

    @FXML
    private void search(){ //takes the searched input and lists both books and characters


    }

    @FXML
    private void deleteDatabase() {
        library.getCharacters().clear();
        library.getBooks().clear();
        System.out.println("size now"+library.getCharacters().size());
    }


}
