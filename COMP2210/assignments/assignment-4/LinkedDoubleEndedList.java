/**
 * LinkedDoubleEndedList.java.
 * Implements DoubleIndedList.java.
 * Assignment 4.
 *
 * @author Carson Barnet (cob0013@auburn.edu)
 * @version 10/15/19
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedDoubleEndedList<T> implements DoubleEndedList<T> {
   private Node front;
   private Node last;
   private int size;

   public LinkedDoubleEndedList() {
      front = null;
      size = 0;
   }
	/**
    * Adds element to the front of the list. If element is null,
    * this method throws an IllegalArgumentException.
    */
   public void addFirst(T element) {
      if (element == null) throw new IllegalArgumentException();
      Node n = new Node(element);
      if (isEmpty()) {
         front = n;
         last = n;
      }
      else {
         n.next = front;
         front = n;
      }
      size++;
   }
	/**
    * Adds element to the end of the list. If element is null,
    * this method throws an IllegalArgumentException.
    */
   public void addLast(T element) {
      if (element == null) throw new IllegalArgumentException();
      Node n = new Node(element);
      if (isEmpty()) {
         front = n;
         last = n;
      }
      else {
         last.next = n;
         last = n;
      }
      size++;
   }
	/**
    * Delete and return the element at the front of the list.
    * If the list is empty, this method returns null.
    */
   public T removeFirst() {
      if (isEmpty()) 
         return null;
      T deleted = front.element;
      front = front.next;
      size--;
      return deleted;
   }
	/**
    * Delete and return the element at the end of the list.
    * If the list is empty, this method returns null.
    */
   public T removeLast() {
      if (isEmpty()) 
         return null;
      T deleted = last.element;
      if (size() == 1) {
         front = null;
         last = null;
         size--;
         return deleted;
      }
      Node p = front;
      while (p.next != last) {
         p = p.next;
      }
      size--;
      last = p;
      p.next = null;
      return deleted;
   }
	/**
    * Returns the number of elements in this list.
    */
   public int size() {
      return size;
   }
	/**
    * Returns true if this list contains no elements, false otherwise.
    */
   public boolean isEmpty() {
      return size == 0;
   }
   public Iterator<T> iterator() {
      return new LinkedDoubleEndedListIterator();
   
   }

   private class Node {
      private T element;
      private Node next;
      public Node(T elementIn) {
         element = elementIn;
      }
   }
   private class LinkedDoubleEndedListIterator implements Iterator<T> {
      private Node current = front;
   
   
   
      public boolean hasNext() {
         return current != null;
      }
      public T next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        T result = current.element;
        current = current.next;
        return result;

      }

      public void remove() {
         throw new UnsupportedOperationException();
      }
   }

}