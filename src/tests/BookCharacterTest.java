package tests;


import static org.junit.jupiter.api.Assertions.*;

import models.BookCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookCharacterTest {

    private BookCharacter test, testUnder;

    @BeforeEach
    void setUp() {
        test = new BookCharacter("Sonic the Hedgehog","","","Male",
                "Sonic is a blue anthropomorphic hedgehog who can run at supersonic speeds and " +
                        "curl into a ball, primarily to attack enemies",15,100,35);

        testUnder = new BookCharacter("", "test1", "test2", "", "", -2, -121, -122.23);
    }

    @Test
    void getFname() {
        assertEquals("Sonic the Hedgehog",test.getFname());
        assertEquals("NOT GIVEN", testUnder.getFname());
    }

    @Test
    void setFname() {
        test.setFname("");
        assertEquals("Sonic the Hedgehog",test.getFname());
        testUnder.setFname("Shadow the Hedgehog");
        assertEquals("Shadow the Hedgehog",testUnder.getFname());
    }

    @Test
    void getSname() {
        assertEquals("",test.getSname());
        assertEquals("test1", testUnder.getSname());
    }

    @Test
    void setSname() {
        test.setSname("test1");
        assertEquals("test1",test.getSname());
        testUnder.setSname("");
        assertEquals("",testUnder.getSname());
    }

    @Test
    void getNickname() {
        assertEquals("",test.getNickname());
        assertEquals("test2",testUnder.getNickname());
    }

    @Test
    void setNickname() {
        test.setNickname("test2");
        assertEquals("test2",test.getNickname());
        testUnder.setNickname("");
        assertEquals("",testUnder.getNickname());
    }

    @Test
    void getGender() {
        assertEquals("Male",test.getGender());
        assertEquals("UNKNOWN",testUnder.getGender());
    }

    @Test
    void setGender() {
        test.setGender("");
        assertEquals("UNKNOWN",test.getGender());
        testUnder.setGender("Female");
        assertEquals("Female",testUnder.getGender());
    }

    @Test
    void getDescription() {
        assertEquals("Sonic is a blue anthropomorphic hedgehog who can run at supersonic speeds and " +
                "curl into a ball, primarily to attack enemies", test.getDescription());
        assertEquals("This bio is empty...", testUnder.getDescription());
    }

    @Test
    void setDescription() {
        test.setDescription("");
        assertEquals("This bio is empty...", test.getDescription());
        testUnder.setDescription("Shadow the Hedge Edge is an edgy hedgehog");
        assertEquals("Shadow the Hedge Edge is an edgy hedgehog", testUnder.getDescription());
    }

    @Test
    void getAge() {
        assertEquals(15, test.getAge());
        assertEquals(0, testUnder.getAge());
    }

    @Test
    void setAge() {
        test.setAge(16);
        assertEquals(16, test.getAge());
        testUnder.setAge(0);
        assertEquals(0, testUnder.getAge());
        testUnder.setAge(-123);
        assertEquals(0, testUnder.getAge());
    }

    @Test
    void getHeight() {
        assertEquals(100, test.getHeight());
        assertEquals(0, testUnder.getHeight());
    }

    @Test
    void setHeight() {
        test.setHeight(101);
        assertEquals(101, test.getHeight());
        testUnder.setHeight(0);
        assertEquals(0, testUnder.getHeight());
        testUnder.setHeight(-123);
        assertEquals(0, testUnder.getHeight());
    }

    @Test
    void getWeight() {
        assertEquals(35, test.getWeight());
        assertEquals(0,testUnder.getWeight());
    }

    @Test
    void setWeight() {
        test.setWeight(32);
        assertEquals(32,test.getWeight());
        testUnder.setWeight(0);
        assertEquals(0,testUnder.getWeight());
        testUnder.setWeight(-432);
        assertEquals(0,testUnder.getWeight());
    }
}