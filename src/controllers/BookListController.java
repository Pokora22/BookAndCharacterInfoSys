package controllers;

import dataStructures.CustomHashList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import models.Book;
import models.Library;

import java.io.IOException;

public class BookListController extends Controller {

    @FXML
    private BorderPane window;

    @FXML
    private TableView<Book> table;

    @FXML
    private TableColumn<Book,String> title, author;

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

    public void setList() { //updates the list

    }
}
