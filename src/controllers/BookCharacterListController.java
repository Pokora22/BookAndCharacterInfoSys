package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class BookCharacterListController extends Controller {

    @FXML
    private BorderPane window;

    @FXML
    private void add() throws IOException {    //creates an empty object and
                            //prompts user to a new window to add parameters

        window.getScene().setRoot(FXMLLoader.load(getClass().getResource("../fxml/BookCharacter.fxml")));
    }

    @FXML
    private void delete() { //if item selected, delete it

    }

    @FXML
    private void view() {   //if item selected, view it
                            //(that window will allow editing)

    }

//    @FXML
//    private void goBack() { //go back to the previous window
//
//    }
    @FXML
    private void search() { //search for the item from the list

    }
}
