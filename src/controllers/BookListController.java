package controllers;

import dataStructures.CustomHashList;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import models.Book;
import static main.Main.library;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

        if(table.getSelectionModel().getSelectedItem()!=null) {
            library.getBooks().remove(table.getSelectionModel().getSelectedItem());
        }
        initialize();
    }

    @FXML
    private void view() {   //if item selected, view it
                            //(that window will allow editing)
        initialize();
    }

    @FXML
    private void search() { //search for the item from the list


    }


    @FXML
    private void initialize() {
        table.getItems().clear();
        table.getItems().addAll(library.getBooks());

        title.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getTitle()));
        author.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getAuthor()));
    }

    public void setList() { //updates the list

    }
}
