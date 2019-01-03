package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import models.BookCharacter;

import java.io.IOException;

import static main.Main.library;
public class BookCharacterController extends Controller {

    @FXML
    private void initialize(){
        String[] genders = {"Male", "Female", "Undefined"};
        genderSelection.getItems().addAll(genders);
        genderSelection.getSelectionModel().selectFirst();
    }

    @FXML
    private ChoiceBox genderSelection;
    @FXML
    private TextField weight, height, age, nickname, sName, fName;
    @FXML
    private BorderPane window;

    @FXML
    private void searchBooks() { //searches for books associated to the character

    }

    @FXML
    private void addBook() throws IOException {     //if character is not being edited:
                                                    // -> opens book list to select a book to associate to a character
    }

    @FXML
    private void delete() {     //if book selected, removes the book

    }

    @FXML
    private void view() {       //if character is not being edited:
                                // -> opens the details of the selected book

    }

//    @FXML
//    private void goBack() {     //goes back to the previous window
//
//    }

    @FXML
    private void applyChangesToBookCharacter() { //apply changes to the edited character
        double weightDbl;
        int ageInt, heightInt;
        try {
            weightDbl = Double.parseDouble(weight.getText());
        } catch (NumberFormatException e) {
            alert("Weight must be numeric.");
            return;
        }
        try {
            heightInt = Integer.parseInt(height.getText());
        } catch (NumberFormatException e) {
            alert("Height must be a whole number.");
            return;
        }
        try {
            ageInt = Integer.parseInt(age.getText());
        } catch (NumberFormatException e) {
            alert("Age must be a whole number.");
            return;
        }

        if (library.getCharacters().add(new BookCharacter(fName.getText(), sName.getText(), nickname.getText(),
                genderSelection.getSelectionModel().getSelectedItem().toString(), ageInt, heightInt, weightDbl))){
            library.saveLibrary();
            clearTextFields();
        }
        else
            alert("Something went wrong. Try again.");
    }

    private void clearTextFields() {
        genderSelection.setValue(1);
        weight.clear();
        height.clear();
        age.clear();
        nickname.clear();
        sName.clear();
        fName.clear();
    }
}
