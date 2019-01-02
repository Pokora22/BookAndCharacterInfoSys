package tests;

import dataStructures.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    private Node<Object> object, empty,head,headNext;
    private Node<String> text;


    @BeforeEach
    void setUp(){
        text = new Node("Hey");
        empty = new Node(null);
        object = new Node(1);
        headNext = new Node("I am the next of head");
        head = new Node("I am the head",headNext);
    }

    @Test
    void getContent() {
        assertEquals("Hey",text.getContent());
        assertEquals(null,empty.getContent());
        assertEquals(1,object.getContent());
    }

    @Test
    void setContent() {
        text.setContent("Why");
        object.setContent(new Node<Integer>(2));
        assertEquals("Why",text.getContent());
        assertEquals("2",object.getContent().toString());
    }

    @Test
    void getNext() {
        assertEquals(headNext,head.getNext());
    }

    @Test
    void setPrevious() {
        headNext.setPrevious(head);
        assertEquals(head,headNext.getPrevious());
    }

    @Test
    void getPrevious() {
        headNext.setPrevious(head);
        assertEquals(head,headNext.getPrevious());
    }

    @Test
    void setNext() {
        text.setNext(object);
        assertEquals(object,text.getNext());
    }
}