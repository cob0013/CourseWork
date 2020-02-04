/**
 * RandomizedArrayList.java.
 * Implements RandomizedList.java.
 * Assignment 4.
 *
 * @author Carson Barnet (cob0013@auburn.edu)
 * @version 10/15/19
 */
import java.util.Iterator;
import java.util.Random;
import java.util.NoSuchElementException;
public class RandomizedArrayList<T> implements RandomizedList<T> {
	//instances
   private int size;
   T[] elements;
   private static final int DEFAULT_CAPACITY = 5;

	//constructor
   @SuppressWarnings("unchecked")
   public RandomizedArrayList() {
      size = 0;
      elements = (T[]) new Object[DEFAULT_CAPACITY];
   }
	/**
    * Adds the specified element to this list. If the element is null, this
    * method throws an IllegalArgumentException.
    */
   @SuppressWarnings("unchecked")
   public void add(T element) {
      if (element == null) throw new IllegalArgumentException();
      if (isFull()) {
         resize(elements.length * 2);
      }
      elements[size()] = element;
      size++;
   }
	/**
    * Selects and removes an element selected uniformly at random from the
    * elements currently in the list. If the list is empty this method returns
    * null.
    */
   public T remove() {
      if (isEmpty()) 
         return null;
      int i = new Random().nextInt(size());
      T deleted = elements[i];
      elements[i] = elements[--size];
      elements[size] = null;
      if (size() > 0 && size() < elements.length / 4) {
         resize(elements.length / 2);
      }
      return deleted;
   }
	/**
    * Selects but does not remove an element selected uniformly at random from
    * the elements currently in the list. If the list is empty this method
    * return null.
    */
   public T sample() {
      if (isEmpty()) 
         return null;
      return elements[new Random().nextInt(size())];
   }
	/**
    * Creates and returns an iterator over the elements of this list.
    */
   public Iterator<T> iterator() {
      return new RandomizedArrayListIterator<T>(elements, size());
   }
	/**
    * Returns true if this list contains no elements, false otherwise.
    */
   public boolean isEmpty() {
      return size == 0;
   }
	/**
    * Returns the number of elements in this list.
    */
   public int size() {
      return size;
   }
   /**
   * Checks if it is full.
   */
   public boolean isFull() {
      return size == elements.length;
   }
	/**
	*Resizes the list
	*/
   @SuppressWarnings("unchecked")
   public void resize(int capacity) {
      T[] temp = (T[]) new Object[capacity];
      for (int j = 0; j < size(); j++) {
         temp[j] = elements[j];
      }
      elements = temp;
   }

	/**
	*Iterator for RandomizeArraList.java
	*/
   public class RandomizedArrayListIterator<T> implements Iterator<T> {
   	//items to be iterated over.
      private T[] items;
   	//number of elements.
      private int count;
   	//current position of iteration.
      private int current;
   	/**
   	*Constructor
   	*/
      public RandomizedArrayListIterator(T[] elements, int size) {
         items = elements;
         count = size;
      }
   	/**
   	*Checks if Iterator has next.
   	*/
      public boolean hasNext() {
         return count != 0;
      }
   	/**
   	*Returns next element in the Iterator.
   	*/
      public T next() {
         if (!hasNext()) throw new NoSuchElementException();
         int rand = new Random().nextInt(count);
         T next =  items[rand];
         if (count != 1) {
            items[rand] = items[count - 1];
            items[count - 1] = next; 
         }
         count--;
      
         return next;
      }
   	/**
   	*Removes next element in the Iterator.
   	*/
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }
}