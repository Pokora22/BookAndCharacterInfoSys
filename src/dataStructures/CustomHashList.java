package dataStructures;

import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.Iterator;

public class CustomHashList<T> extends AbstractList<T> implements Iterable<T>{
    private static final int DEFAULT_SIZE = 10;
    private double loadFactorLimit = .7;
    private Node<T>[] list;
    private Node<T> head; //placeholder to get iterator first item for now

    CustomHashList(int startSize){ //Starting size
        if(startSize<0)
            list = new Node[DEFAULT_SIZE];
        else
            list = new Node[startSize];
    }

    public CustomHashList(){
        list = new Node[DEFAULT_SIZE];
    } //With item at head and default size(10)

    CustomHashList(double loadFactorLimit) {
        list = new Node[DEFAULT_SIZE];
        this.loadFactorLimit = loadFactorLimit;
    }


    public boolean add(T item){
        if (loadFactor() > loadFactorLimit) expand();

        int index = hash(item)%list.length;
        for(int i = 1; i < Math.sqrt(Integer.MAX_VALUE); i++){// could probably do with smaller limit
            if (list[index] == null)break; //found empty spot

            index = (index + i*i)%list.length;
        }

        list[index] = new Node<>(item);
        if(head == null){
            head = list[index];
            head.setNext(null);
            head.setPrevious(null);
        }
        else{
            list[index].setNext(head);
            head.setPrevious(list[index]);
            head = list[index];
            head.setPrevious(null);
        }
        return true;
    }

    public boolean addAll(AbstractCollection<T> collection){
        for(T elem : collection){
            this.add(elem);
        }
        return true;
    }

    public boolean remove(Object item){
        if (item == null) return false;
        int index = hash((T)item)%list.length;
        for(int i = 1; i < Math.sqrt(Integer.MAX_VALUE); i++) {
            if(list[index] == null) return false;
            if(list[index].getContent().equals(item)){
                Node<T> prevNode, nextNode; //Hold the references temporarily - otherwise would come up null after overwriting first one.
                prevNode = list[index].getPrevious();
                nextNode = list[index].getNext();
                if(nextNode != null) nextNode.setPrevious(prevNode);
                if(prevNode != null) prevNode.setNext(nextNode);
                list[index] = null;
                return true;
            }
            index = (index + i*i)%list.length;
        }
        return false;
    }

    @Override
    public T get(int index) {
        return list[index].getContent();
    }

    private int hash(T item){
        return Math.abs(item.hashCode());
    }

    private void expand(){
        CustomHashList<T> expandedList = new CustomHashList<>(size()*2);
        expandedList.addAll(this);
        this.list = expandedList.getList();
    }

    public T get(T item){
        int index = hash(item)%list.length;
        for(int i = 1; i < Math.sqrt(Integer.MAX_VALUE); i++){// could probably do with smaller limit
            if(list[index] != null && list[index].getContent().equals(item)) return list[index].getContent();
            index = (index + i*i)%list.length;
        }
        return head.getContent(); //TODO: What to return if fails? / Create head in each list to be an empty 'Such a thing does not exist in database' instance
    }

    public void clear(){
        head = null;
        /*for(Object o : this){
            o = null;
        }*/
    }

    public int size() {
        return list.length;
    }

    public double loadFactor(){
        int used = 0;
        if(head != null){
            for(T item : this) used++;
        }
        return (double)used/list.length;
    }

    public void setLoadFactorLimit(double loadFactorLimit) {
        if(loadFactorLimit > 0) this.loadFactorLimit = loadFactorLimit;
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomIterator<T>(head);
    }

    public String toString(){
        StringBuilder toString = new StringBuilder();

        for(T item: this){
            toString.append(item.toString() + "\n");
        }
        return toString.toString();
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T>[] getList() {
        return list;
    }
}
