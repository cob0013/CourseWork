import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.Collections;
import java.util.*;

import java.util.stream.Collectors;

/**
 * Provides an implementation of the WordLadderGame interface. 
 *
 * @author Your Name (you@auburn.edu)
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2019-03-29
 */
public class Doublets implements WordLadderGame {

    // The word list used to validate words.
    // Must be instantiated and populated in the constructor.
    /////////////////////////////////////////////////////////////////////////////
    // DECLARE A FIELD NAMED lexicon HERE. THIS FIELD IS USED TO STORE ALL THE //
    // WORDS IN THE WORD LIST. YOU CAN CREATE YOUR OWN COLLECTION FOR THIS     //
    // PURPOSE OF YOU CAN USE ONE OF THE JCF COLLECTIONS. SUGGESTED CHOICES    //
    // ARE TreeSet (a red-black tree) OR HashSet (a closed addressed hash      //
    // table with chaining).
    /////////////////////////////////////////////////////////////////////////////
    HashSet<String> lexicon;

    /**
     * Instantiates a new instance of Doublets with the lexicon populated with
     * the strings in the provided InputStream. The InputStream can be formatted
     * in different ways as long as the first string on each line is a word to be
     * stored in the lexicon.
     */
    public Doublets(InputStream in) {
        try {
            //////////////////////////////////////
            // INSTANTIATE lexicon OBJECT HERE  //
            //////////////////////////////////////
            lexicon = new HashSet<String>();
            Scanner s =
                new Scanner(new BufferedReader(new InputStreamReader(in)));
            while (s.hasNext()) {
                String str = s.next();
                /////////////////////////////////////////////////////////////
                // INSERT CODE HERE TO APPROPRIATELY STORE str IN lexicon. //
                /////////////////////////////////////////////////////////////
                lexicon.add(str.toLowerCase());
                s.nextLine();
            }
            in.close();
        }
        catch (java.io.IOException e) {
            System.err.println("Error reading from InputStream.");
            System.exit(1);
        }
    }


    //////////////////////////////////////////////////////////////
    // ADD IMPLEMENTATIONS FOR ALL WordLadderGame METHODS HERE  //
    //////////////////////////////////////////////////////////////
    public int getHammingDistance(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return -1;
        }
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
     
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public List<String> getMinLadder(String start, String end) {
        start = start.toLowerCase();
        end = end.toLowerCase();
        HashSet<String> visited = new HashSet<String>();
        List<String> ladder = new ArrayList<String>();
        if (!isWord(start) || !isWord(end)) {
            return ladder;
        }
        if (start.equals(end)) {
          ladder.add(start);
          return ladder;
        }
        if (getHammingDistance(start, end) == -1) {
            return ladder;
        }
        Deque<String> q = new ArrayDeque<String>();
        boolean found = false;
        q.addLast(start);
        visited.add(start);
        HashMap<String, String> backTrack = new HashMap<String, String>();
        while (!q.isEmpty()) {
            String current = q.removeFirst();
            List<String> nbs = getNeighbors(current);
            for (String n : nbs) {
                if (!visited.contains(n)) {
                    q.addLast(n);
                    visited.add(n);
                    backTrack.put(n, current);
                    if (n.equals(end)) {
                      found = true;
                      break;
                    }
                }
            }
            if (found) {
              break;
            }
        }
        if (found == false) {
            return ladder;
        }
        String pointer = end;
        while (pointer != null) { 
            ladder.add(pointer);
            pointer = backTrack.get(pointer);
        }
        Collections.reverse(ladder);
        return ladder;
    }


    public List<String> getNeighbors(String word) {
    	 String letters = "abcdefghijklmnopqrstuvwxyz";
         List<String> neighbors = new ArrayList<String>();
      // for (String p : lexicon) {
      //    String word2 = p;
      //    if (getHammingDistance(word, word2) == 1) {
      //       neighbors.add(word2);
      //    }
         for (int i = 0; i < word.length(); i++) {
         	for (int j = 0; j < letters.length(); j++) {
         		if (word.charAt(i) == letters.charAt(j)) {
         			continue;
         		}
         		String str = word.substring(0, i) + letters.charAt(j) + word.substring(i + 1);
         		if (isWord(str)) {
         			neighbors.add(str);
         		}
         	}

         }
      return neighbors;
      }
    

    public int getWordCount() {
        return lexicon.size();
    }

    public  boolean isWord(String str) {
        return lexicon.contains(str.toLowerCase());
    }

    public boolean isWordLadder(List<String> sequence) {
        if (sequence.size() < 1) {
          return false;
        }
        String prev = sequence.get(0).toLowerCase();
        for (int i = 1; i < sequence.size(); i++) {
            String current = sequence.get(i).toLowerCase();
            if (getHammingDistance(current, prev) != 1 || !isWord(current) ||!isWord(prev)) {
                return false;
            }
            prev  = current;
        }
        return true;
    }
}

