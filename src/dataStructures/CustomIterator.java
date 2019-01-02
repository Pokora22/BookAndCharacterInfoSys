package dataStructures;

import dataStructures.Node;

import java.util.Iterator;

public class CustomIterator<T> implements Iterator {
    private Node<T> currPos;

    public CustomIterator(Node<T> currPos){
        this.currPos = currPos;
    }

    @Override
    public boolean hasNext() {
        return currPos != null;
    }

    @Override
    public T next() {
        Node<T> temp = currPos;
        currPos = currPos.getNext();
        return temp.getContent();
    }
}
