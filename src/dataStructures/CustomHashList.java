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
            if (list[index] == null){
                list[index] = new Node<>(item);
                break;
            }
            index = (index + i*i)%list.length;
        }

        list[index] = new Node<>(item);
        if(head == null) head = list[index];
        else{
            list[index].setNext(head);
            head = list[index];
        }
        return false;
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
            if(list[index].getContent().equals(item)){
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
        Node<T>[] tempList = new Node[list.length*2];
        for(T item : this){
            int index = hash(item)%tempList.length;
            for(int i = 1; i < Math.sqrt(Integer.MAX_VALUE); i++){// could probably do with smaller limit
                if (tempList[index] == null){
                    tempList[index] = new Node<>(item);
                    break;
                }
                index = (index + i*i)%tempList.length;
            }
        }
        this.list = tempList;
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
}
