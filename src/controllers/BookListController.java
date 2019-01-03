package controllers;

import com.sun.tools.javac.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import javax.swing.border.Border;
import java.io.IOException;

public class BookListController extends Controller {

    @FXML
    private BorderPane window;

    @FXML
    private void add(ActionEvent actionEvent) throws IOException {//creates an empty object and
                            //prompts user to a new window to add parameters

        changeScene(actionEvent,"../fxml/Book.fxml");
    }

    @FXML
    private void delete() { //if item selected, delete it

    }

    @FXML
    private void view() {   //if item selected, view it
                            //(that window will allow editing)

    }

    @FXML
    private void search() { //search for the item from the list

    }
}
