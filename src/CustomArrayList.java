import java.util.Iterator;

public class CustomArrayList <T> implements Iterable<T>{
    private static final int DEFAULT_SIZE = 10;
    private Node<T>[] list;
    private Node<T> head; //placeholder to get iterator first item for now

    CustomArrayList(int startSize){
        if(startSize<0)
            list = new Node[DEFAULT_SIZE];
        else
            list = new Node[startSize];
    }

    CustomArrayList(){
        list = new Node[DEFAULT_SIZE];
    }

    public void append(T item){
        for(int i = 0; i < list.length; i++){
            if(list[i]==null){
                list[i] = new Node<T>(item);
                return;
            }
        }

        int nextFreeIndex = list.length;
        expand();
        list[nextFreeIndex] = new Node<T>(item);
    }

    public void add(T item){ //TODO: Doesn't expand
        if (loadFactor() > .7) expand();

        int index = hash(item)%list.length;
        for(int i = 1; i < Math.sqrt(Integer.MAX_VALUE); i++){// could probably do with smaller limit
            if (list[index] == null){
                list[index] = new Node<>(item);
                return;
            }
            index = (index + i*i)%list.length;
        }

        list[index] = new Node<>(item);
        if(head == null) head = list[index];
        else{
            list[index].next = head;
            head = list[index];
        }
    }

    private int hash(T item){
        return Math.abs(item.hashCode()); //TODO: Create custom hash function
    }

    private void expand(){
        Node<T>[] tempList = new Node[list.length*2];
        for(T item : this){
            int index = hash(item)%list.length;
            for(int i = 1; i < Math.sqrt(Integer.MAX_VALUE); i++){// could probably do with smaller limit
                if (tempList[index] == null){
                    tempList[index] = new Node<>(item);
                    return;
                }
                index = (index + i*i)%list.length;
            }
        }
        this.list = tempList;
    }

    public void clear(){
        for(Object o : this){
            o = null;
        }
    }

    public Node getNode(int index){
        if (index >=0 && index < list.length)
            return list[index];
        else
            throw new IndexOutOfBoundsException("No element with such index");
    }

    public void setNode(int index, T item){
        if (index >=0 && index < list.length)
            list[index] = new Node<T>(item);
        else
            throw new IndexOutOfBoundsException("No element with such index");
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

    public Node<T>[] getList() {
        return list;
    }
}
