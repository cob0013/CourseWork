import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Autocomplete {
        /**
         * Uses binary search to find the index of the first Term in the passed in
         * array which is considered equivalent by a comparator to the given key.
         * This method should not call comparator.compare() more than 1+log n times,
         * where n is the size of a.
         *
         * @param a
         *            - The array of Terms being searched
         * @param key
         *            - The key being searched for.
         * @param comparator
         *            - A comparator, used to determine equivalency between the
         *            values in a and the key.
         * @return The first index i for which comparator considers a[i] and key as
         *         being equal. If no such index exists, return -1 instead.
         */
   public static int firstIndexOf(Term[] a, Term key, Comparator<Term> comparator) {
            // TODO: Implement firstIndexOf
      int beg = 0, end = a.length-1;
      int index = -1;
      while (beg <= end) {
         int mid = (beg + end)/2;
         Term cur = a[mid];
         int comparisonResult = comparator.compare(key, cur);
         if (comparisonResult == 0) index = mid;
         if (comparisonResult <= 0) end = mid-1;
         else beg = mid+1;
      }
      return index;
   }

        /**
         * The same as firstIndexOf, but instead finding the index of the last Term.
         *
         * @param a
         *            - The array of Terms being searched
         * @param key
         *            - The key being searched for.
         * @param comparator
         *            - A comparator, used to determine equivalency between the
         *            values in a and the key.
         * @return The last index i for which comparator considers a[i] and key as
         *         being equal. If no such index exists, return -1 instead.
         */
   public static int lastIndexOf(Term[] a, Term key, Comparator<Term> comparator) {
            // TODO: Implement lastIndexOf
      int beg = 0, end = a.length-1;
      int index = -1;
      while (beg <= end) {
         int mid = (beg + end)/2;
         Term cur = a[mid];
         int comparisonResult = comparator.compare(key, cur);
         if (comparisonResult == 0) index = mid;
         if (comparisonResult < 0) end = mid-1;
         else beg = mid+1;
      }
      return index;
   }

    /**
     * An Autocompletor supports returning either the top k best matches, or the
     * single top match, given a String prefix.
     *
     * @author Austin Lu
     *
     */
   public interface Autocompletor {
   
        /**
         * Returns the top k matching terms in descending order of weight. If there
         * are fewer than k matches, return all matching terms in descending order
         * of weight. If there are no matches, return an empty iterable.
         */
      public Iterable<String> topMatches(String prefix, int k);
   
        /**
         * Returns the single top matching term, or an empty String if there are no
         * matches.
         */
      public String topMatch(String prefix);
   
        /**
         * Return the weight of a given term. If term is not in the dictionary,
         * return 0.0
         */
      public double weightOf(String term);
   }
    /**
     * Implements Autocompletor by scanning through the entire array of terms for
     * every topKMatches or topMatch query.
     */
   public static class BruteAutocomplete implements Autocompletor {
   
      Term[] myTerms;
   
      public BruteAutocomplete(String[] terms, double[] weights) {
         if (terms == null || weights == null)
            throw new NullPointerException("One or more arguments null");
         if (terms.length != weights.length)
            throw new IllegalArgumentException("terms and weights are not the same length");
         myTerms = new Term[terms.length];
         HashSet<String> words = new HashSet<String>();
         for (int i = 0; i < terms.length; i++) {
            words.add(terms[i]);
            myTerms[i] = new Term(terms[i], weights[i]);
            if (weights[i] < 0)
               throw new IllegalArgumentException("Negative weight "+ weights[i]);
         }
         if (words.size() != terms.length)
            throw new IllegalArgumentException("Duplicate input terms");
      }
   
      public Iterable<String> topMatches(String prefix, int k) {
         if (k < 0)
            throw new IllegalArgumentException("Illegal value of k:"+k);
            // maintain pq of size k
         PriorityQueue<Term> pq = new PriorityQueue<Term>(k, new Term.WeightOrder());
         for (Term t : myTerms) {
            if (!t.getWord().startsWith(prefix))
               continue;
            if (pq.size() < k) {
               pq.add(t);
            } else if (pq.peek().getWeight() < t.getWeight()) {
               pq.remove();
               pq.add(t);
            }
         }
         int numResults = Math.min(k, pq.size());
         LinkedList<String> ret = new LinkedList<String>();
         for (int i = 0; i < numResults; i++) {
            ret.addFirst(pq.remove().getWord());
         }
         return ret;
      }
   
      public String topMatch(String prefix) {
         String maxTerm = "";
         double maxWeight = -1;
         for (Term t : myTerms) {
            if (t.getWeight() > maxWeight && t.getWord().startsWith(prefix)) {
               maxWeight = t.getWeight();
               maxTerm = t.getWord();
            }
         }
         return maxTerm;
      }
   
      public double weightOf(String term) {
         for (Term t : myTerms) {
            if (t.getWord().equalsIgnoreCase(term))
               return t.getWeight();
         }
            // term is not in dictionary return 0
         return 0;
      }
   }
   /**
     *
     * Using a sorted array of Term objects, this implementation uses binary search
     * to find the top term(s).
     *
     * @author Austin Lu, adapted from Kevin Wayne
     * @author Jeff Forbes
     */
   public static class BinarySearchAutocomplete implements Autocompletor {
   
      Term[] myTerms;
   
        /**
         * Given arrays of words and weights, initialize myTerms to a corresponding
         * array of Terms sorted lexicographically.
         *
         * This constructor is written for you, but you may make modifications to
         * it.
         *
         * @param terms
         *            - A list of words to form terms from
         * @param weights
         *            - A corresponding list of weights, such that terms[i] has
         *            weight[i].
         * @return a BinarySearchAutocomplete whose myTerms object has myTerms[i] =
         *         a Term with word terms[i] and weight weights[i].
         * @throws a
         *             NullPointerException if either argument passed in is null
         */
      public BinarySearchAutocomplete(String[] terms, double[] weights) {
         if (terms == null || weights == null)
            throw new NullPointerException("One or more arguments null");
         myTerms = new Term[terms.length];
         for (int i = 0; i < terms.length; i++) {
            myTerms[i] = new Term(terms[i], weights[i]);
         }
         Arrays.sort(myTerms);
      }
   
        /**
         * Required by the Autocompletor interface. Returns an array containing the
         * k words in myTerms with the largest weight which match the given prefix,
         * in descending weight order. If less than k words exist matching the given
         * prefix (including if no words exist), then the array instead contains all
         * those words. e.g. If terms is {air:3, bat:2, bell:4, boy:1}, then
         * topKMatches("b", 2) should return {"bell", "bat"}, but topKMatches("a",
         * 2) should return {"air"}
         *
         * @param prefix
         *            - A prefix which all returned words must start with
         * @param k
         *            - The (maximum) number of words to be returned
         * @return An array of the k words with the largest weights among all words
         *         starting with prefix, in descending weight order. If less than k
         *         such words exist, return an array containing all those words If
         *         no such words exist, reutrn an empty array
         * @throws a
         *             NullPointerException if prefix is null
         */
      public Iterable<String> topMatches(String prefix, int k) {
         if (prefix == null) throw new NullPointerException();
         int f = firstIndexOf(myTerms, new Term(prefix, 0) , new Term.PrefixOrder(prefix.length()));
         int l = lastIndexOf(myTerms, new Term(prefix, 0) , new Term.PrefixOrder(prefix.length()));
         if (l < 0)
            return new ArrayList<String>();
         PriorityQueue<Term> pq = new PriorityQueue<Term>(k, new Term.WeightOrder());
         for (int i = f; i <= l; i++) {
            Term t = myTerms[i];
            if (pq.size() < k) {
               pq.add(t);
            } else if (pq.peek().getWeight() < t.getWeight()) {
               pq.remove();
               pq.add(t);
            }
         }
         int numResults = Math.min(k, pq.size());
         LinkedList<String> ret = new LinkedList<String>();
         for (int i = 0; i < numResults; i++) {
            ret.addFirst(pq.remove().getWord());
         }
         return ret;
      }
   
        /**
         * Given a prefix, returns the largest-weight word in myTerms starting with
         * that prefix. e.g. for {air:3, bat:2, bell:4, boy:1}, topMatch("b") would
         * return "bell". If no such word exists, return an empty String.
         *
         * @param prefix
         *            - the prefix the returned word should start with
         * @return The word from myTerms with the largest weight starting with
         *         prefix, or an empty string if none exists
         * @throws a
         *             NullPointerException if the prefix is null
         *
         */
      public String topMatch(String prefix) {
         if (prefix == null) throw new NullPointerException();
         int f = firstIndexOf(myTerms, new Term(prefix, 0) , new Term.PrefixOrder(prefix.length()));
         int l = lastIndexOf(myTerms, new Term(prefix, 0) , new Term.PrefixOrder(prefix.length()));
         ArrayList<Term> found = new ArrayList<Term>();
         if (l < 0)
            return "";
         double maxWeight = myTerms[f].getWeight();
         int maxWeightIndex = f;
         for (int i = f+1; i <= l; i++) {
            if (myTerms[i].getWeight() > maxWeight) {
               maxWeight = myTerms[i].getWeight();
               maxWeightIndex = i;
            }
         }
         return myTerms[maxWeightIndex].getWord();
      }
   
        /**
         * Return the weight of a given term. If term is not in the dictionary,
         * return 0.0
         */
      public double weightOf(String term) {
            // TODO complete weightOf
         return 0.0;
      }
   }
    /**
     * General trie/priority queue algorithm for implementing Autocompletor
     *
     * @author Austin Lu
     * @author Jeff Forbes
     */
   public static class TrieAutocomplete implements Autocompletor {
   
        /**
         * Root of entire trie
         */
      protected Node myRoot;
   
        /**
         * Constructor method for TrieAutocomplete. Should initialize the trie
         * rooted at myRoot, as well as add all nodes necessary to represent the
         * words in terms.
         *
         * @param terms
         *            - The words we will autocomplete from
         * @param weights
         *            - Their weights, such that terms[i] has weight weights[i].
         * @throws NullPointerException
         *             if either argument is null
         * @throws IllegalArgumentException
         *             if terms and weights are different weight
         */
      public TrieAutocomplete(String[] terms, double[] weights) {
         if (terms == null || weights == null)
            throw new NullPointerException("One or more arguments null");
            // Represent the root as a dummy/placeholder node
         myRoot = new Node('-', null, 0);
      
         for (int i = 0; i < terms.length; i++) {
            add(terms[i], weights[i]);
         }
      }
   
        /**
         * Add the word with given weight to the trie. If word already exists in the
         * trie, no new nodes should be created, but the weight of word should be
         * updated.
         *
         * In adding a word, this method should do the following: Create any
         * necessary intermediate nodes if they do not exist. Update the
         * subtreeMaxWeight of all nodes in the path from root to the node
         * representing word. Set the value of myWord, myWeight, isWord, and
         * mySubtreeMaxWeight of the node corresponding to the added word to the
         * correct values
         *
         * @throws a
         *             NullPointerException if word is null
         * @throws an
         *             IllegalArgumentException if weight is negative.
         */
      private void add(String word, double weight) {
            // TODO: Implement add
           //need to come back and solve duplicate issue
      
         if (word == null) {
            throw new  NullPointerException("word cannot be null");
         }
      
         if (weight < 0) {
            throw new IllegalArgumentException("Weight cannot be negative");
         }
      
         Node curr = myRoot;
      
         //use traveral pattern given in handout, but use for each loop for cleaner
         //https://stackoverflow.com/questions/2451650/how-do-i-apply-the-for-each-loop-to-every-character-in-a-string
         for (char c : word.toCharArray()) {
         
          //if new weight is bigger than current node, update current nodes max weight
          //https://www.geeksforgeeks.org/java-math-max-method-examples
            curr.mySubtreeMaxWeight = Math.max(weight, curr.mySubtreeMaxWeight);
         
            if (!curr.children.containsKey(c)){
               //if child doesn't exist build node
               Node next = new Node(c, curr, weight);
               curr.children.put(c, next);
            }
         
            //go to child
            curr = curr.getChild(c);
         }
         
         //need to check for duplicates
         
         
      
         curr.setWord(word);
         curr.setWeight(weight);
         curr.isWord = true;
         
      }
   
        /**
         * Required by the Autocompletor interface. Returns an array containing the
         * k words in the trie with the largest weight which match the given prefix,
         * in descending weight order. If less than k words exist matching the given
         * prefix (including if no words exist), then the array instead contains all
         * those words. e.g. If terms is {air:3, bat:2, bell:4, boy:1}, then
         * topKMatches("b", 2) should return {"bell", "bat"}, but topKMatches("a",
         * 2) should return {"air"}
         *
         * @param prefix
         *            - A prefix which all returned words must start with
         * @param k
         *            - The (maximum) number of words to be returned
         * @return An Iterable of the k words with the largest weights among all
         *         words starting with prefix, in descending weight order. If less
         *         than k such words exist, return all those words. If no such words
         *         exist, return an empty Iterable
         * @throws a
         *             NullPointerException if prefix is null
         */
      public Iterable<String> topMatches(String prefix, int k) {
         //https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
         // usedhttps://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html
         // TODO: Implement topKMatches
         if (prefix == null) {
            throw new NullPointerException("Prefix is null");
         }
      
         ArrayList<String> output = new ArrayList<String>();
         
            
         //traverse to proper node
      
         Node curr = myRoot;
      
         for (char c : prefix.toCharArray()) {
         
            if (!curr.children.containsKey(c)) {
               //if prefix doesn't exist return empty iterable
               return output;
            }
            curr = curr.getChild(c);
         
         }
         
         //use reverse comparator to maintain max heap so you get best matches
         PriorityQueue<Node> pq = new PriorityQueue<Node>(new Node.ReverseSubtreeMaxWeightComparator());
         
         //keep track of kBest nodes we have seen
         PriorityQueue<Node> kBest = new PriorityQueue<Node>();
         //add initial word to pq and begin search
         pq.add(curr);
      
         while (!pq.isEmpty()) {
            Node next = pq.poll();
            if (kBest.size() >= k) {
               if (kBest.peek().getWeight() > next.mySubtreeMaxWeight) {
                  // we know no nodes yet to be explored can have larger weights
                  break;
               }
            }
            
            
            if (next.isWord) {
               kBest.add(next);
               //only keep best k values
               //https://stackoverflow.com/questions/1846225/java-priorityqueue-with-fixed-size
               if (kBest.size() > k) {
                  kBest.poll();
               }
            }
            for (Node child : next.children.values()) {
               //throw all children on pq
               pq.add(child);
            }
         }
         
         while (!kBest.isEmpty()) {
            //pop from pq and add  to front of output
            output.add(0, kBest.poll().getWord());
         }
      
         return output;
      }
   
        /**
         * Given a prefix, returns the largest-weight word in the trie starting with
         * that prefix.
         *
         * @param prefix
         *            - the prefix the returned word should start with
         * @return The word from with the largest weight starting with prefix, or an
         *         empty string if none exists
         * @throws a
         *             NullPointerException if the prefix is null
         */
      public String topMatch(String prefix) {
            // TODO: Implement topMatch
         if (prefix == null) {
            throw new NullPointerException("Prefix can't be null");
         }
      
         Node curr = myRoot;
      
         //traverse to node of proper prefix
         for (char c : prefix.toCharArray()) {
         
            if (!curr.children.containsKey(c)){
            //if prefix does not exist in the tri, return empty string
               return "";
            }
         
            curr = curr.getChild(c);
         }
      
         double maxWeight = curr.mySubtreeMaxWeight;
      
      
         //traverse the trie choosing the child whose maxWeight matches
         //the goals match weight
         //return when the current nodes weight is the goal weight
         while (curr.myWeight != maxWeight) {
         //https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
            for (Node child : curr.children.values()) {
               if (child.mySubtreeMaxWeight == maxWeight) {
                  curr   = child;
                  break;
               }
            }
         }
         return curr.myWord;
      }
   
        /**
         * Return the weight of a given term. If term is not in the dictionary,
         * return 0.0
         */
      public double weightOf(String term) {
               // TODO complete weightOf
      
         Node curr = myRoot;
      
         for (char c : term.toCharArray()) {
            if (!curr.children.containsKey(c)) {
               return 0.0;
            }
            curr = curr.getChild(c);
         }
         if (!curr.isWord) {
            return 0.0;
         }
         return curr.myWeight;
      
      }
   
        /**
         * Optional: Returns the highest weighted matches within k edit distance of
         * the word. If the word is in the dictionary, then return an empty list.
         *
         * @param word
         *            The word to spell-check
         * @param dist
         *            Maximum edit distance to search
         * @param k
         *            Number of results to return
         * @return Iterable in descending weight order of the matches
         */
      public Iterable<String> spellCheck(String word, int dist, int k) {
         return null;
      }
   }
}
