import java.util.AbstractList;
import java.util.Iterator;

public class CustomLinkedList<T> implements Iterable<T> {

	private Node<T> head = null;
	private Node<T> tail = null;
	private int length = 0;
	
	
	public void add(T obj) { //add element to the head
		Node<T> j = new Node<>(obj);
		j.setNext(head); //next item in the list is the head of..
		head = j; //..this item
		j.setPrevious(null);
		if(tail!=null) head.getNext().setPrevious(j);
		else tail = j;
		length++;
	}
	
	public void addLast(T obj) { //add element to the end
		if(head!=null) {
			Node<T> temp = head;
			while(temp.getNext()!=null) {
				temp = temp.getNext(); //iterating through the list until the end is reached	
			}
			Node<T> j = new Node<>(obj);
			temp.setNext(j);
			j.setPrevious(temp);
			tail = j; // this element is the new tail
			length++;
		}
		else add(obj);
	}
	
	public void addBetween(T obj, int index) { //TODO '''Working title''' insert an element at a specific index, between two elements
		if(head!=null) {
			if(index<length) {
				Node<T> temp = head;
				for(int i=0;i<index;i++) {
					temp = temp.getNext(); //iterating through the list until at the required index	
				}
				Node<T> j = new Node<>(obj);
				j.setPrevious(temp.getPrevious());
				temp.getPrevious().setNext(j);
				temp.setPrevious(j);
				j.setNext(temp);
			}
			else {}
		}
		else add(obj);
	}



	public boolean remove(int index) { //remove at a specific index
		if(head!=null) {
			if(index<=length) {
				Node<T> temp = head;
				for(int i=0;i<index;i++) {
					temp = temp.getNext(); //iterating through the list until at the required index	
				}
				if(temp.getPrevious()==null) { //for a first that doesn't have a previous
					if(temp.getNext()==null) { //if it's the only one in the list then clear it
						clear();
						return true;
					}
					else {
						System.out.println(temp.getNext());
						head = temp.getNext();
						temp.getNext().setPrevious(null);
						length--;
						return true;
					}
				}
				else if(temp.getNext()!=null) { //for non-first that has a next
					temp.getPrevious().setNext(temp.getNext());
					temp.getNext().setPrevious(temp.getPrevious());
					length--;
					return true;
				}
				else { //deleting the last one
					tail = temp.getPrevious();
					temp.getPrevious().setNext(null);
					length--;
					return true;
				}
			}
			else return false;
		}
		else return false;
	}
	
	public T getFirst() { //get the first element in the list
		return head.getContent();
	}
	
	public T getLast() { //get the last element in the list
		return tail.getContent();
	}

	public T get(int index) { //get the contents of an element
		if(head!=null) {
            if (index <= length) {
                Node<T> temp = head;
                for (int i = 0; i < index; i++) {
                    temp = temp.getNext(); //iterating through the list until at the required index
                }
                return temp.getContent();
            } else {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
        }
        return null;
	}
	
	public void set(T obj, int index) { //updates the element at an index
		if(index<=length) {
			Node<T> temp = head;
			for(int i=0;i<index;i++) {
				temp = temp.getNext(); //iterating through the list until at the required index	
			}
			temp.setContent(obj);
		}
		else {
			if(head==null) {} //TODO

			
			else {}//TODO
		}
		
	}
	
	public void clear() { //to delete the whole list and orphan every node
		head=null;
		tail=null;
		length = 0;
	}

	public int size() {
		return length;
	}

	@Override
	public Iterator<T> iterator() {
		return new CustomIterator<T>(head);
	}
}
