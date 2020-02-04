import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Extractor.java. Implements feature extraction for collinear points in
 * two dimensional data.
 *
 * @author  Carson Barnett (cob0013@auburn.edu)
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 9/29/19
 *
 */
public class Extractor {
   
   /** raw data: all (x,y) points from source data. */
   private Point[] points;
   
   /** lines identified from raw data. */
   private SortedSet<Line> lines;
  
   /**
    * Builds an extractor based on the points in the file named by filename. 
    */
   public Extractor(String filename) {
      try {
         File file = new File(filename);
         Scanner scan = new Scanner(file);
         int n = scan.nextInt();
         points = new Point[n];
         for (int i = 0; i < n; i ++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            points[i] = new Point(x, y);
         }
      }
      catch(Exception e) {
         System.out.println("Error reading file");
      }
   }
  
   /**
    * Builds an extractor based on the points in the Collection named by pcoll. 
    *
    * THIS METHOD IS PROVIDED FOR YOU AND MUST NOT BE CHANGED.
    */
   public Extractor(Collection<Point> pcoll) {
      points = pcoll.toArray(new Point[]{});
   }
  
   /**
    * Returns a sorted set of all line segments of exactly four collinear
    * points. Uses a brute-force combinatorial strategy. Returns an empty set
    * if there are no qualifying line segments.
    */
   public SortedSet<Line> getLinesBrute() {
      lines = new TreeSet<Line>();
      for (int i = 0; i < points.length; i++) {
         for (int j = i + 1; j < points.length; j++) {
            for (int k = j + 1; k < points.length; k++) {
               for (int l = k + 1; l < points.length; l++) {
                  Line line = new Line();
                  line.add(points[i]);
                  line.add(points[j]);
                  line.add(points[k]);
                  line.add(points[l]);
                  if (line.length() == 4) lines.add(line);
               }
            }
         }
      }
      return lines;
   }
  
   /**
    * Returns a sorted set of all line segments of at least four collinear
    * points. The line segments are maximal; that is, no sub-segments are
    * identified separately. A sort-and-scan strategy is used. Returns an empty
    * set if there are no qualifying line segments.
    */
   public SortedSet<Line> getLinesFast() {
      lines = new TreeSet<Line>();
      Point[] sorted = Arrays.copyOf(points, points.length);
      Line l = new Line();
      for (int i = 0; i < points.length; i++) {
         Arrays.sort(sorted, points[i].slopeOrder);
         for (Point p : sorted) {
            l.add(sorted[0]);
            boolean added = l.add(p);
            if (!added) {
               if (l.length() >= 4) lines.add(l);
               l = new Line();
               l.add(p);
            }
         }
      }
      return lines;
   }
   
}
