package dataStructures;

public class Node <T> {
    private T content;
    private Node next, previous;

    public Node(T item){
        this.content = item;
        this.next = null;
        this.previous = null;
    }

    public Node(T item, Node next){
        this.content = item;
        this.next = next;
    }


    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public String toString(){
        return content.toString();
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
