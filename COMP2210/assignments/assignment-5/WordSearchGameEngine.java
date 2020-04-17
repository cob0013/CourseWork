import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Scanner;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
/**
 * Defines the methods needed to play a word search game.
 *@author Carson Barnett(cob0013@auburn.edu)
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 10/28/19
 * 
 */
public class WordSearchGameEngine implements WordSearchGame {
	//instances
   private String[][] board;
   private TreeSet<String> lexicon;
   private boolean[][] visited;
   private List<String> adjacent;
   private int size;
   private boolean lexiconLoaded;
   private List<Integer> path;
   private StringBuilder wordSoFar;
   private TreeSet<String> allValidWords;

	//constructor
   public WordSearchGameEngine() {
      size = 4;
      lexicon = new TreeSet<String>();
      board = new String[size][size];
      visited = new boolean[size][size];
      path = new ArrayList<Integer>();
      adjacent = new ArrayList<String>();
      board = new String[4][4];
   
      board[0][0] = "E"; 
      board[0][1] = "E"; 
      board[0][2] = "C"; 
      board[0][3] = "A"; 
      board[1][0] = "A"; 
      board[1][1] = "L"; 
      board[1][2] = "E"; 
      board[1][3] = "P"; 
      board[2][0] = "H"; 
      board[2][1] = "N"; 
      board[2][2] = "B"; 
      board[2][3] = "O"; 
      board[3][0] = "Q"; 
      board[3][1] = "T"; 
      board[3][2] = "T"; 
      board[3][3] = "Y";
   }



	/**
    * Loads the lexicon into a data structure for later use. 
    * 
    * @param fileName A string containing the name of the file to be opened.
    * @throws IllegalArgumentException if fileName is null
    * @throws IllegalArgumentException if fileName cannot be opened.
    */
   public void loadLexicon(String fileName) {
   
      if (fileName == null) {
         throw new IllegalArgumentException();
      }
      try {
         lexicon = new TreeSet<String>();
      
         File file = new File(fileName);
         Scanner scan = new Scanner(file);
         while (scan.hasNext()) {
            String word = scan.next().toUpperCase();
            lexicon.add(word);
         }
         lexiconLoaded = true;
      }
      
      catch(Exception e) {
         throw new IllegalArgumentException();
      }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
   }


   	/**
    * Stores the incoming array of Strings in a data structure that will make
    * it convenient to find words.
    * 
    * @param letterArray This array of length N^2 stores the contents of the
    *     game board in row-major order. Thus, index 0 stores the contents of board
    *     position (0,0) and index length-1 stores the contents of board position
    *     (N-1,N-1). Note that the board must be square and that the strings inside
    *     may be longer than one character.
    * @throws IllegalArgumentException if letterArray is null, or is  not
    *     square.
    */
   public void setBoard(String[] letterArray) {
      if (letterArray == null) {
         throw new IllegalArgumentException();
      }
      double n =  Math.sqrt(letterArray.length);
      if (n % 1 > 0) {
         throw new IllegalArgumentException();
      }
      size = (int) n;
      board = new String[size][size];
      visited = new boolean[size][size];
      int count = 0;
      for (int i = 0; i < size; i++) {
         for (int j = 0; j < size; j++) {
            board[i][j] = letterArray[count].toUpperCase();
            count++;
         }
      }
   }
    /**
    * Creates a String representation of the board, suitable for printing to
    *   standard out. Note that this method can always be called since
    *   implementing classes should have a default board.
    */
   public String getBoard() {
      String output = "";
      for (int i = 0; i < size; i++) {
         if (i > 0) {
            output += "\n";
         }
         for (int j = 0; j < size; j++) {
            output += board[i][j] + " ";
         }
      }
      return output;
   }

     /**
    * Retrieves all valid words on the game board, according to the stated game
    * rules.
    * 
    * @param minimumWordLength The minimum allowed length (i.e., number of
    *     characters) for any word found on the board.
    * @return java.util.SortedSet which contains all the words of minimum length
    *     found on the game board and in the lexicon.
    * @throws IllegalArgumentException if minimumWordLength < 1
    * @throws IllegalStateException if loadLexicon has not been called.
    */
   public SortedSet<String> getAllValidWords(int minimumWordLength) {
      if (!lexiconLoaded) {
         throw new IllegalStateException();
      }
      if (minimumWordLength < 1) {
         throw new IllegalArgumentException();
      
      }
      visited = new boolean[size][size];
      String word = "";
      allValidWords = new TreeSet<String>();
      for (int i = 0; i < size; i++) {
         for (int j = 0; j < size; j++) {
            getAllValidWordsHelper(i, j, word, minimumWordLength);
         }
      }
   
   
      
      return allValidWords;
   }
   public void getAllValidWordsHelper(int i, int j, String word, int minimumWordLength) {
      if (word != null && !isValidPrefix(word)) {
         return;
      }
      Coordinate c = new Coordinate(i, j);
      word += board[i][j];
      visited[i][j] = true;
      if (isValidWord(word.toString()) && word.toString().length() >= minimumWordLength) {
         allValidWords.add(word.toString());
      }
      for (Coordinate p : c.getNeigbors()) {
         if (isInBounds(p) && !visited[p.r][p.c]) {
            getAllValidWordsHelper(p.r, p.c, word, minimumWordLength);
         }
      }
      word = "" + word.charAt(word.length() - 1);
      visited[i][j] = false;
   }
   /**
   * Computes the cummulative score for the scorable words in the given set.
   * To be scorable, a word must (1) have at least the minimum number of characters,
   * (2) be in the lexicon, and (3) be on the board. Each scorable word is
   * awarded one point for the minimum number of characters, and one point for 
   * each character beyond the minimum number.
   *
   * @param words The set of words that are to be scored.
   * @param minimumWordLength The minimum number of characters required per word
   * @return the cummulative score of all scorable words in the set
   * @throws IllegalArgumentException if minimumWordLength < 1
   * @throws IllegalStateException if loadLexicon has not been called.
   */  
   public int getScoreForWords(SortedSet<String> words, int minimumWordLength) {
      if (minimumWordLength < 1) {
         throw new IllegalArgumentException();
      }
      if (!lexiconLoaded) {
         throw new IllegalStateException();
      }
      int score = 0;
      for (String word : words) {
         if (word.length() >= minimumWordLength && !isOnBoard(word).isEmpty()
         		&& lexicon.contains(word)) {
            score += minimumWordLength + (word.length() - minimumWordLength);
         }
      }
      return score;
   }
   /**
    * Determines if the given word is in the lexicon.
    * 
    * @param wordToCheck The word to validate
    * @return true if wordToCheck appears in lexicon, false otherwise.
    * @throws IllegalArgumentException if wordToCheck is null.
    * @throws IllegalStateException if loadLexicon has not been called.
    */
   public boolean isValidWord(String wordToCheck) {
      if (wordToCheck == null) {
         throw new IllegalArgumentException();
      }
      if (!lexiconLoaded) {
         throw new IllegalArgumentException();
      }
      wordToCheck = wordToCheck.toUpperCase();
      return (lexicon.contains(wordToCheck));
   }
    /**
    * Determines if there is at least one word in the lexicon with the 
    * given prefix.
    * 
    * @param prefixToCheck The prefix to validate
    * @return true if prefixToCheck appears in lexicon, false otherwise.
    * @throws IllegalArgumentException if prefixToCheck is null.
    * @throws IllegalStateException if loadLexicon has not been called.
    */
   public boolean isValidPrefix(String prefixToCheck) {
      if (prefixToCheck == null) {
         throw new IllegalArgumentException();
      }
      if (!lexiconLoaded) {
         throw new IllegalStateException();
      }
      prefixToCheck = prefixToCheck.toUpperCase();
      String ceiling = lexicon.ceiling(prefixToCheck);
      if (ceiling == null) {
         return false;
      }
      
      return ceiling.startsWith(prefixToCheck);
   }

   /**
    * Determines if the given word is in on the game board. If so, it returns
    * the path that makes up the word.
    * @param wordToCheck The word to validate
    * @return java.util.List containing java.lang.Integer objects with  the path
    *     that makes up the word on the game board. If word is not on the game
    *     board, return an empty list. Positions on the board are numbered from zero
    *     top to bottom, left to right (i.e., in row-major order). Thus, on an NxN
    *     board, the upper left position is numbered 0 and the lower right position
    *     is numbered N^2 - 1.
    * @throws IllegalArgumentException if wordToCheck is null.
    * @throws IllegalStateException if loadLexicon has not been called.
    */
   public List<Integer> isOnBoard(String wordToCheck) {
      if (wordToCheck == null || !lexiconLoaded) {
         throw new IllegalArgumentException();
      }
      path = new ArrayList<Integer>();
      visited = new boolean[size][size];
      wordSoFar = new StringBuilder();
      wordToCheck = wordToCheck.toUpperCase();
      for (int i = 0; i < size; i++) {
         for (int j = 0; j < size; j++) {
            if (wordToCheck.startsWith(board[i][j])) {
               if (dfsOneWord(i, j, wordToCheck, wordSoFar, path)) {
                  return path;
               }
            }
         }
      }
      return path;
   }

   /**
   *DFS on Grid looking for word.
   */
   public boolean dfsOneWord(int i, int j, String wordToCheck, StringBuilder wordSoFar, List<Integer> path) {
      Coordinate c = new Coordinate(i, j);
      if (!isInBounds(c)) {
         return false;
      }
      if (isVisited(c)) {
         return false;
      }
      if (!isValidPrefix(wordSoFar.toString())) {
         return false;
      }
      wordSoFar.append(board[i][j]);
      visited[i][j] = true;
      int value = (i * size) + j;
      path.add(value);
      if (wordSoFar.toString().equals(wordToCheck)) {
         return true;
      }
      ArrayList<Coordinate> neighbors = new ArrayList<Coordinate>();
      neighbors = c.getNeigbors();
      for (Coordinate p : neighbors) {
         if (dfsOneWord(p.r, p.c, wordToCheck, wordSoFar, path)) {
            return true;
         }
      }
      visited[i][j] = false;
      path.remove(path.size() - 1);
      wordSoFar.delete(wordSoFar.length() - 1, wordSoFar.length());
      return false;
   
   }
   public  boolean isInBounds(Coordinate p){
      return (p.c >= 0 && p.r >= 0  && p.r < size && p.c < size);
   }
   public  boolean isVisited(Coordinate p) {
      return visited[p.r][p.c];
   }
   





   
   private class Coordinate {
      int r;
      int c;
      public Coordinate(int i, int j) {
         r = i;
         c = j;
      }
      public  ArrayList<Coordinate> getNeigbors() {
         ArrayList<Coordinate> neighbors = new ArrayList<Coordinate>();
         for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
               if (!(i == 0 && j == 0)) {
                  Coordinate p = new Coordinate(r + i, c + j);
                  if (isInBounds(p)) {
                     neighbors.add(p);
                  }
               }
            }
         }
         return neighbors;
      }
   }
}