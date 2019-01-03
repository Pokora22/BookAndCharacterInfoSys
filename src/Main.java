import dataStructures.CustomHashList;
import dataStructures.CustomLinkedList;
import dataStructures.Node;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import models.Book;

import java.util.Comparator;
import java.util.Random;

public class Main extends Application {
    static Random rndm = new Random();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml/Main.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setResizable(false);
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
//            int booksNow = 0;
//            for(Book b : books) booksNow++;
//            System.out.println("Books now: " + booksNow);
        }


        System.out.println("Books list size: " + books.getList().length);
        System.out.println("Amount of books in: " + books.size());
        String myBookTitle = books.get(myBook) == null? "Book missing" : books.get(myBook).getTitle();
        System.out.println("Getting: " + myBookTitle);
//        Book myBookBinarySearched = books.binarySearch(0, books.size()-1, myBook, (a,b)->a.getTitle().compareTo(b.getTitle()));
//        String myBookBinarySearchTitle = myBookBinarySearched != null? "Book binary searched title: " + myBookBinarySearched.getTitle(): "Binary search returned empty";
//        System.out.println(myBookBinarySearchTitle);

        if(books.remove(myBook)) System.out.println("Book removed");
        else System.out.println("No such book");
        System.out.println("My book is now: " + books.get(myBook));


        Node<Book>[] sortedBooks;
//        sortedBooks = CustomHashList.quickSort(new CustomHashList<Book>(books), 0, books.size()-1, (a, b)->a.getTitle().compareTo(b.getTitle()));

//        for(Node n: sortedBooks) System.out.println(n.getContent());

//        System.out.println("\nUnsorted");
//        for(Book b : books) System.out.println(b);
//
//        System.out.println("\n-------------------------------\n\nSorted");
//        for(Book b : sortedBooks) System.out.println(b);
//
//        System.out.println("\n\n@@@@@@@@@@@@@@@@@@@@ By title");
//
//        System.out.println("Sorted");
//        for(Book b: CustomHashList.quickSort(books, 0, books.size()-1, (a, b)->a.getTitle().compareTo(b.getTitle()))){
//            System.out.println(b);
//        }
//        System.out.println("---------------------------------------------------------\nUnsorted");
//        for(Book b: books) System.out.println(b);

        launch(args);
    }

    public static String randomString(int length){
        char[] chars = "abcdefghijklmnopqrstvwxyz".toCharArray();
        StringBuilder randomString = new StringBuilder();
        for(int r = 0 ;r < rndm.nextInt(length); r++) randomString.append(chars[rndm.nextInt(chars.length)]);

        return randomString.toString();
    }

}
