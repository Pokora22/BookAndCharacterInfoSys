package dataStructures;

import jdk.nashorn.api.tree.LiteralTree;

import javax.xml.stream.events.StartDocument;
import java.util.*;

public class CustomHashList<T> extends AbstractList<T> implements Iterable<T>{
    private static final int DEFAULT_SIZE = 10;
    private double loadFactorLimit = .7;
    private Node<T>[] list;
    private Node<T> head; //placeholder to get iterator first item for now

    public CustomHashList(int startSize){ //Starting size
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

    public CustomHashList(CustomHashList<T> sourceCollection){
        list = new Node[sourceCollection.size()];
        addAll(sourceCollection);
    }


    public boolean add(T item){
        if (loadFactor() == 1) return false;

        int index = findEmptyIndex(item);
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

    public int findEmptyIndex(Object item){
        if(loadFactor() <= .7){
            int index = Math.abs(item.hashCode())%list.length;
            for(int i = 1; i < Math.sqrt(Integer.MAX_VALUE); i++){// could probably do with smaller limit
                if (list[index] == null)break; //found empty spot

                index = (index + i*i)%list.length;
            }
            return index;
        }

        for(int i = 0; i < list.length; i++)
            if(list[i] == null) return i;
        return -1; //safe cause checked before in loadfactor?
    }

    private int getIndex(Object item){
        if(loadFactor()<= 0.7) {
            int index = Math.abs(item.hashCode())%list.length;
            for (int i = 1; i < Math.sqrt(Integer.MAX_VALUE); i++) {
                if (list[index] != null && list[index].equals(item)) return index;

                index = (index + i * i) % list.length;
            }
        }

        for(int i = 0; i < list.length; i++) {
            if (list[i] != null)
                if(list[i].getContent().equals(item)) return i;
        }

        return -1;
    }

    public boolean remove(Object item) {
        int index = getIndex(item);
        if (index < 0) return false;

        Node<T> prevNode, nextNode; //Hold the references temporarily - otherwise would come up null after overwriting first one.
        prevNode = list[index].getPrevious();
        nextNode = list[index].getNext();
        if (nextNode != null) nextNode.setPrevious(prevNode);
        if (prevNode != null) prevNode.setNext(nextNode);
        list[index] = null;
        return true;
    }

    @Override
    public T get(int index) {
        return list[index] != null? list[index].getContent() : null;
    }

    private void expand(){ //Stuff breaks because of order added? Different head etc. Would need to replace this whole instance somehow
        CustomHashList<T> expandedList = new CustomHashList<>(size()*2);
        expandedList.addAll(this);
        this.list = expandedList.getList();
    }

    public T get(T item){
        int index = getIndex(item);
        return (index < 0) ? null : list[index].getContent(); //TODO: What to return if fails?
    }

    public void clear(){
        head = null;
        /*for(Object o : this){
            o = null;
        }*/
    }

    public static <T> CustomHashList<T> quickSort(CustomHashList<T> sourceList, int begin, int end, Comparator<T> comparator) {
        CustomHashList<T> list = new CustomHashList<>(sourceList);
        int left = begin;
        int right = end;
        if(right>left) {
            T pivot = list.get(list.size()/2);
            if(pivot == null) return list; //if pivot is null, list is empty - return empty as it's sorted

            while (left <= right) {
                while (left < end && comparator.compare(list.get(left), pivot) < 0) left++;
                while (right > begin && comparator.compare(list.get(right), pivot) > 0) right--;

                if(left <= right)
                {
                    list.swap(left, right);
                    left++;
                    right--;
                }
                if(begin<right) quickSort(list, begin, right, comparator);
                if(left<end) quickSort(list, left, end, comparator);
            }
        }
        return list;
    }

    private void swap(int left, int right) {
        Node temp = list[left];
        list[left] = list[right];
        list[right] = temp;
    }

    /*
    public T binarySearch(int left, int right, int searchItem, Comparator<T> comparator)
    {
        T[] arr = new CustomHashList<T>(this).quickSort(0,size()-1,comparator);
        if (right >= left) {
            int midIndex = left + (right - left) / 2;

            if (arr[midIndex] == searchItem)
                return midIndex;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[midIndex] > searchItem)
                return binarySearch(arr, left, midIndex - 1, searchItem);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, midIndex + 1, right, searchItem);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }
    */

    public int size() {
        int size = 0;
        for(T e: this) size++;
        return size;
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
