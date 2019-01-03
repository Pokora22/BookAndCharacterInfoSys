package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import models.Book;

import static main.Main.library;



public class BookController extends Controller {


    @FXML private TextField pageNumber, chapterNumber, year, publisher, origin,
                            setting, genre, author, title;

    @FXML
    private void searchCharacters() { //searches for characters associated to the book

    }
    @FXML
    private void addCharacter(){    //if book is not being edited:
                                    // -> opens character list to select a character to associate to the book

    }

    @FXML
    private void delete() {         //if character selected, removes the character

    }

    @FXML
    private void view() {           //if book is not being edited:
                                    // -> opens the details of the selected character

    }

//    @FXML
//    private void goBack() {         //goes back to the previous window
//
//
//    }

    @FXML
    private void applyChangesToBook(){  //apply changes to the edited book
        int yearInt, pageNumberInt, chapterNumberInt;
        try{
            yearInt = Integer.parseInt(year.getText());
        }
        catch (Exception e){
            alert("Year must be a whole number.");
            return;
        }
        try{
            pageNumberInt = Integer.parseInt(pageNumber.getText());
        }
        catch (Exception e){
            alert("Number of pages must be a whole number.");
            return;
        }
        try{
            chapterNumberInt = Integer.parseInt(chapterNumber.getText());
        }
        catch (Exception e){
            alert("Number of chapters must be a whole number.");
            return;
        }

        if(library.getBooks().add(new Book(title.getText(), author.getText(), genre.getText(), setting.getText(), origin.getText(),
            publisher.getText(), yearInt,chapterNumberInt,pageNumberInt))) {
            library.saveLibrary();
            clearTextFields();
        }
        else alert("Something went wrong adding the book. Try again.");
    }

    private void clearTextFields() {
        pageNumber.clear();
        chapterNumber.clear();
        year.clear();
        publisher.clear();
        origin.clear();
        setting.clear();
        genre.clear();
        author.clear();
        title.clear();
    }
}
