import java.util.*;
public class AutocompleteTest {
   public static void main(String [] args) {
      String[] queries = {"", "", "", "", "a", "ap", "b", "ba", "d"};
      int[] k = {8, 1, 2, 3, 1, 1, 2, 2, 100};
      String[] words = {"ape", "app", "ban", "bat", "bee", "car", "cat"};
      double[] weights = {6, 4, 2, 3, 5, 7, 1};
      Autocomplete.TrieAutocomplete test = new Autocomplete.TrieAutocomplete(words, weights);
      for (int i = 0; i < queries.length; i++) {
         System.out.println("Test case " + (i + 1));
         Iterable<String> results = test.topMatches(queries[i], k[i]);
         for (String s : results) {
            System.out.println(s);
         }
      }
   }

}