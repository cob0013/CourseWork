import java.util.*;
public class Student {
   int credits_completed;
   String name;
   int credits_until_graduation;
   int minor_degree_credits;
   double gpa;
   double minor_gpa;
   int starting_year;
   int graduation_year;
   String major;
   String minor;
   String student_id;
   ArrayList<Grades> course_list;
   
   
   public Student(String nameIn, int starting_yearIn, String student_id_in, String majorIn, String minorIn) {
      name = nameIn;
      starting_year = starting_yearIn;
      graduation_year = starting_year + 4;
      credits_until_graduation = 120;
      credits_completed = 0;
      student_id = student_id_in;
      course_list = new ArrayList<Grades>();
      major = majorIn;
      minor = minorIn;
      
   }
   
   public void add_grade(Grades grade) {
      course_list.add(grade);
      this.calculate_gpa();
      credits_completed += grade.credit_hours;
      credits_until_graduation -= grade.credit_hours;
   }
   
   public double calculate_gpa() {
      double total = gpa;
      for (Grades g: course_list) {
         total += g.gpa_points;
      }
      gpa = total / course_list.size();
      return gpa;
   }
   
   public int get_credits_completed() {
      return credits_completed;
   }
   
   public int get_gredits_until_graduation() {
      return credits_until_graduation;
   }
   
   public String toString() {
      String output = "STUDENT INFO\n";
      output += "Name: " + name + "\n";
      output += "Remaining credits to graduate: " + credits_until_graduation + "\n";
      output += "GPA: " + gpa + "\n";
      output += "Starting year: " + starting_year + "\n";
      output += "Grad year: " + graduation_year + "\n";
      output += "Major: " + major + "\n";
      output += "Minor: " + minor + "\n";
      
      
   
      return output;       
   }
   
}

