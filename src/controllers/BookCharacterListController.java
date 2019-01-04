package controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import models.BookCharacter;

import java.io.IOException;

import static main.Main.library;

public class BookCharacterListController extends Controller {

    @FXML
    private BorderPane window;

    @FXML
    private TableView<BookCharacter> table;

    @FXML
    private TableColumn<BookCharacter,String> fName,sName;

    @FXML
    private void add(ActionEvent actionEvent) throws IOException {    //creates an empty object and
                            //prompts user to a new window to add parameters

        changeScene(actionEvent,"../fxml/BookCharacter.fxml");
    }

    @FXML
    private void delete() { //if item selected, delete it
        if(table.getSelectionModel().getSelectedItem()!=null) {
            library.getCharacters().remove(table.getSelectionModel().getSelectedItem());

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
        table.getItems().addAll(library.getCharacters());

        fName.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getFname()));
        sName.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getSname()));
    }
}
