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
import models.Library;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BookListController extends Controller implements Initializable {

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


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set up the columns into the table
        table = new TableView<>();

        table.getColumns().add(title);
        table.getColumns().add(author);

        title.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getTitle()));
        author.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getAuthor()));

        table.getItems().addAll(getBooks());
        System.out.println("and here");
    }


    //dummy to see if tableview FINALLY works...
    public ObservableList<Book> getBooks() {
        ObservableList<Book> books = FXCollections.observableArrayList();
        books.add(new Book("a","b","c","d","e","f", 123, 1,2));
        books.add(new Book("asddsa","asdff","fff","dsasdf","ezxvc","fr", 12333, 14,211));
        System.out.println("im here");
        return books;
    }

    public void setList() { //updates the list

    }
}
