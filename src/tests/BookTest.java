package tests;


import static org.junit.jupiter.api.Assertions.*;

import models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {

    private Book test, testUnder;

    @BeforeEach
    void setUp() {
        test = new Book("Harry Potter and the Chamber of Secrets","J. K. Rowling", "Fantasy", 
        		"United Kingdom", "United Kingdom", "Bloomsbury", 1998, 18, 360);
    
        testUnder = new Book("", "", "", "", "", "", -121, -122, -123);
    }

    @Test
    void getTitle() {
        assertEquals("Harry Potter and the Chamber of Secrets",test.getTitle());
        assertEquals("NOT GIVEN", testUnder.getTitle());
    }

    @Test
    void setTitle() {
        test.setTitle("Harry Potter and the Sorcerer's stone");
        assertEquals("Harry Potter and the Sorcerer's stone",test.getTitle());
        testUnder.setTitle("");
        assertEquals("NOT GIVEN",testUnder.getTitle());
    }

    @Test
    void getAuthor() {
    	assertEquals("J. K. Rowling",test.getAuthor());
    	assertEquals("NOT GIVEN", testUnder.getAuthor());
    }

    @Test
    void setAuthor() {
        test.setAuthor("Hello");
        assertEquals("Hello",test.getAuthor());
        testUnder.setAuthor("");
        assertEquals("NOT GIVEN",testUnder.getAuthor());
    }

    @Test
    void getGenre() {
    	assertEquals("Fantasy",test.getGenre());
        assertEquals("NOT GIVEN",testUnder.getGenre());
    }

    @Test
    void setGenre() {
    	test.setGenre("Children's");
    	assertEquals("Children's",test.getGenre());
        testUnder.setGenre("");
        assertEquals("NOT GIVEN",testUnder.getGenre());
    }

    @Test
    void getCountryOfSetting() {
    	assertEquals("United Kingdom",test.getCountryOfSetting());
        assertEquals("NOT GIVEN",testUnder.getCountryOfSetting());
    }

    @Test
    void setCountryOfSetting() {
    	test.setCountryOfSetting("England");
    	assertEquals("England",test.getCountryOfSetting());
        testUnder.setCountryOfSetting("");
        assertEquals("NOT GIVEN",testUnder.getCountryOfSetting());
    }

    @Test
    void getCountryOfOrigin() {
    	assertEquals("United Kingdom", test.getCountryOfOrigin());
        assertEquals("NOT GIVEN", testUnder.getCountryOfOrigin());
    }

    @Test
    void setCountryOfOrigin() {
    	test.setCountryOfOrigin("England");
    	assertEquals("England", test.getCountryOfOrigin());
    	testUnder.setCountryOfOrigin("");
        assertEquals("NOT GIVEN", testUnder.getCountryOfOrigin());
    }

    @Test
    void getPublisher() {
    	assertEquals("Bloomsbury", test.getPublisher());
        assertEquals("NOT GIVEN", testUnder.getPublisher());
    }

    @Test
    void setPublisher() {
    	test.setPublisher("Sample Publisher");
    	assertEquals("Sample Publisher", test.getPublisher());
    	testUnder.setPublisher("");
        assertEquals("NOT GIVEN", testUnder.getPublisher());
    }

    @Test
    void getPublicationYear() {
    	assertEquals(1998, test.getPublicationYear());
        assertEquals(0, testUnder.getPublicationYear());
    }

    @Test
    void setPublicationYear() {
    	test.setPublicationYear(1999);
    	assertEquals(1999, test.getPublicationYear());
    	testUnder.setPublicationYear(0);
        assertEquals(0, testUnder.getPublicationYear());
        testUnder.setPublicationYear(-123);
        assertEquals(0, testUnder.getPublicationYear());
    }

    @Test
    void getNumberOfChapters() {
    	assertEquals(18, test.getNumberOfChapters());
    	assertEquals(0,testUnder.getNumberOfChapters());
    }

    @Test
    void setNumberOfChapters() {
    	test.setNumberOfChapters(32);
    	assertEquals(32,test.getNumberOfChapters());
    	testUnder.setNumberOfChapters(0);
        assertEquals(0,testUnder.getNumberOfChapters());
        testUnder.setNumberOfChapters(-432);
        assertEquals(0,testUnder.getNumberOfChapters());
    }

    @Test
    void getNumberOfPages() {
    	assertEquals(360,test.getNumberOfPages());
    	assertEquals(0,testUnder.getNumberOfPages());
    }

    @Test
    void setNumberOfPages() {
    	test.setNumberOfPages(333);
    	assertEquals(333,test.getNumberOfPages());
    	testUnder.setNumberOfPages(0);
    	assertEquals(0,testUnder.getNumberOfPages());
        testUnder.setNumberOfPages(-1234);
        assertEquals(0,testUnder.getNumberOfPages());
    }
}