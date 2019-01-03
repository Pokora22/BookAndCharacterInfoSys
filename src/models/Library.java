package models;

import dataStructures.CustomHashList;
import java.io.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class Library {

    private CustomHashList<Book> books;
    private CustomHashList<BookCharacter> characters;
    private XStream xStream;

    public Library(){
        books = new CustomHashList<>();
        characters = new CustomHashList<>();
        xStream = new XStream(new StaxDriver());

        //loadLibrary();
    }

    public CustomHashList<Book> getBooks() {
        return books;
    }

    public CustomHashList<BookCharacter> getCharacters(){
        return characters;
    }


    public void addBook(Book book) {
        books.add(book);
    }

    public void addCharacter(BookCharacter character) {
        characters.add(character);
    }


    public void loadLibrary(){
        if (!new File("src/data/bookings.xml").exists()) {
            try {
                saveBooks();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (!new File("src/data/menu.xml").exists()) {
            try {
                saveCharacters();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        try {
            loadBooks();
            loadCharacters();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void saveLibrary(){
        try {
            saveBooks();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            saveCharacters();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadBooks() throws IOException {
        ObjectInputStream is = null;
        try {
            is = xStream.createObjectInputStream(new FileReader("src/db/books.xml"));
            books = (CustomHashList<Book>) is.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        is.close();
    }

    private void saveBooks() throws IOException {
        ObjectOutputStream out = xStream.createObjectOutputStream(new FileWriter("src/db/books.xml"));
        out.writeObject(books);
        out.close();
    }

    private void loadCharacters() throws IOException {
        ObjectInputStream is = null;
        try {
            is = xStream.createObjectInputStream(new FileReader("src/db/characters.xml"));
            characters = (CustomHashList<BookCharacter>) is.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        is.close();
    }

    private void saveCharacters() throws IOException {
        ObjectOutputStream out = xStream.createObjectOutputStream(new FileWriter("src/db/characters.xml"));
        out.writeObject(characters);
        out.close();
    }

}
