package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {

    Book test, testUnder;

    @BeforeEach
    void setUp() throws Exception {
        test = new Book("Harry Potter and the Chamber of Secrets","J. K. Rowling", "Fantasy", 
        		"United Kingdom", "United Kingdom", "Bloomsbury", 1998, 18, 360, 
        		"On Harry Potter's twelfth birthday, the Dursley family—Harry's uncle Vernon, "
        		+ "aunt Petunia, and cousin Dudley—hold a dinner party for a potential client "
        		+ "of Vernon's drill-manufacturing company. Harry is not invited, but is content "
        		+ "to spend the evening quietly in his bedroom, although he is confused why his "
        		+ "school friends have not sent cards or presents. However, when he goes to his room, "
        		+ "a house-elf named Dobby warns him not to return to Hogwarts and admits to intercepting "
        		+ "Harry's post from his friends. Having failed to persuade Harry to voluntarily give up "
        		+ "his place at Hogwarts, Dobby then attempts to get him expelled by using magic to smash "
        		+ "Petunia's dessert on a dinner party guest and framing it on Harry, who is not allowed "
        		+ "to use magic out of school. Uncle Vernon's business deal falls through, but Harry is "
        		+ "given a second chance from the Ministry of Magic, and allowed to return at the start "
        		+ "of the school year.", 
        		"https://en.wikipedia.org/wiki/Harry_Potter_and_the_Chamber_of_Secrets#/media/File:Harry_Potter_and_the_Chamber_of_Secrets.jpg");
    
        testUnder = new Book("", "", "", "", "", "", -121, -122, -123, "", "" );
    }

    @Test
    void getTitle() {
        assertEquals("Harry Potter and the Chamber of Secrets",test.getTitle());
    }

    @Test
    void setTitle() {
        assertEquals("Harry Potter and the Chamber of Secrets",test.getTitle());
        test.setTitle("Harry Potter and the Sorcerer's stone");
        assertEquals("Harry Potter and the Sorcerer's stone",test.getTitle());
    }

    @Test
    void getAuthor() {
    	assertEquals("J.K. Rowling",test.getAuthor());
    }

    @Test
    void setAuthor() {
    	assertEquals("J.K. Rowling",test.getAuthor());
        test.setAuthor("Hello");
        assertEquals("Hello",test.getAuthor());
    }

    @Test
    void getGenre() {
    	assertEquals("Fantasy",test.getGenre());
    }

    @Test
    void setGenre() {
    	assertEquals("Fantasy", test.getGenre());
    	test.setGenre("Children's");
    	assertEquals("Children's",test.getGenre());
    }

    @Test
    void getCountryOfSetting() {
    	assertEquals("United Kingdom",test.getCountryOfSetting());
    }

    @Test
    void setCountryOfSetting() {
    	assertEquals("United Kingdmom",test.getCountryOfSetting());
    	test.setCountryOfSetting("England");
    	assertEquals("England",test.getCountryOfSetting());
    }

    @Test
    void getCountryOfOrigin() {
    	assertEquals("United Kingdom", test.getCountryOfOrigin());
    }

    @Test
    void setCountryOfOrigin() {
    	assertEquals("United Kingdom", test.getCountryOfOrigin());
    	test.setCountryOfOrigin("England");
    	assertEquals("England", test.getCountryOfOrigin());
    }

    @Test
    void getPublisher() {
    	assertEquals("Bloomsbury", test.getPublisher());
    }

    @Test
    void setPublisher() {
    	assertEquals("Bloomsbury", test.getPublisher());
    	test.setPublisher("Sample Publisher");
    	assertEquals("Sample Publisher", test.getPublisher());
    }

    @Test
    void getPublicationYear() {
    	assertEquals(1998, test.getPublicationYear());
    }

    @Test
    void setPublicationYear() {
    	assertEquals(1998, test.getPublicationYear());
    	test.setPublicationYear(1999);
    	assertEquals(1999, test.getPublicationYear());
    }

    @Test
    void getNumberOfChapters() {
    	assertEquals(18, test.getNumberOfChapters());
    }

    @Test
    void setNumberOfChapters() {
    	assertEquals(18, test.getNumberOfChapters());
    	test.setNumberOfChapters(32);
    	assertEquals(32,test.getNumberOfChapters());
    }

    @Test
    void getNumberOfPages() {
    	assertEquals(360,test.getNumberOfPages());
    }

    @Test
    void setNumberOfPages() {
    	assertEquals(360, test.getNumberOfPages());
    	test.setNumberOfPages(333);
    	assertEquals(333,test.getNumberOfPages());
    }

    @Test
    void getDescription() {
    	assertEquals("On Harry Potter's twelfth birthday, the Dursley family—Harry's uncle Vernon, "
        		+ "aunt Petunia, and cousin Dudley—hold a dinner party for a potential client "
        		+ "of Vernon's drill-manufacturing company. Harry is not invited, but is content "
        		+ "to spend the evening quietly in his bedroom, although he is confused why his "
        		+ "school friends have not sent cards or presents. However, when he goes to his room, "
        		+ "a house-elf named Dobby warns him not to return to Hogwarts and admits to intercepting "
        		+ "Harry's post from his friends. Having failed to persuade Harry to voluntarily give up "
        		+ "his place at Hogwarts, Dobby then attempts to get him expelled by using magic to smash "
        		+ "Petunia's dessert on a dinner party guest and framing it on Harry, who is not allowed "
        		+ "to use magic out of school. Uncle Vernon's business deal falls through, but Harry is "
        		+ "given a second chance from the Ministry of Magic, and allowed to return at the start "
        		+ "of the school year.", test.getDescription());
    }

    @Test
    void setDescription() {
    	test.setDescription("aaa");
    	assertEquals("aaa",test.getDescription());
    }

    @Test
    void getImage() {
    	assertEquals("https://en.wikipedia.org/wiki/Harry_Potter_and_the_Chamber_of_Secrets#/media/File:Harry_Potter_and_the_Chamber_of_Secrets.jpg",test.getImage());
    }

    @Test
    void setImage() {
    	test.setImage("sampleImage.png");
    	assertEquals("sampleImage.png",test.getImage());
    }
}