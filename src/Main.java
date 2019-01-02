import dataStructures.CustomHashList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import models.Book;

import java.util.Random;

public class Main extends Application {
    static Random rndm = new Random();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        CustomHashList<Book> books = new CustomHashList<>(120);
        Book myBook = new Book("My title",
                randomString(10),
                randomString(10),
                randomString(10),
                randomString(10),
                randomString(10),
                rndm.nextInt(),
                rndm.nextInt(),
                rndm.nextInt(),
                randomString(10),
                randomString(10));

        books.add(myBook);

        for(int i = 0; i < 100; i++){
            books.add(new Book(randomString(10),
                    randomString(10),
                    randomString(10),
                    randomString(10),
                    randomString(10),
                    randomString(10),
                    rndm.nextInt(),
                    rndm.nextInt(),
                    i,
                    randomString(10),
                    randomString(10)));
            int booksNow = 0;
            for(Book b : books) booksNow++;
            System.out.println("Books now: " + booksNow);
        }


        int booksTotal = 0;
        for (Book b: books){
            System.out.println(b.getNumberOfPages());
            booksTotal++;
        }

        System.out.println("Books list size: " + books.size());
        System.out.println("Amount of books in: " + booksTotal);
        String myBookTitle = books.get(myBook) == null? "Book missing" : books.get(myBook).getTitle();
        System.out.println("Getting: " + myBookTitle);

        if(books.remove(myBook)) System.out.println("Book removed");
        if(books.remove(myBook)) System.out.println("Book removed");
        else System.out.println("No such book");
        myBookTitle = books.get(myBook) == null? "Book missing" : books.get(myBook).getTitle();
        System.out.println("My book is now: " + myBookTitle);
        System.out.println("Head of books is: " + books.getHead().getContent().getTitle());

        booksTotal = 0;
        for (Book b: books){
            booksTotal++;
        }
        System.out.println("Books list size: " + books.size());
        System.out.println("Amount of books in: " + booksTotal);

        /*
        CustomHashList<Book> newBookList = new CustomHashList<>();
        newBookList.addAll(books);
        System.out.println("New list size: " + newBookList.size());
        booksTotal = 0;
        for (Book b:newBookList){
            booksTotal++;
        }
        System.out.println("New list amount of books: " + booksTotal);
        */

        launch(args);
    }

    public static String randomString(int length){
        char[] chars = "abcdefghijklmnopqrstvwxyz".toCharArray();
        StringBuilder randomString = new StringBuilder();
        for(int r = 0 ;r < rndm.nextInt(length); r++) randomString.append(chars[rndm.nextInt(chars.length)]);

        return randomString.toString();
    }

}
