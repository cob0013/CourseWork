public class Grades {
   String course_name;
   int credit_hours;
   String grade_recieved;
   double gpa_points;
   String semester;
   boolean pass;
   boolean withdrew;
   
   
   public Grades(String course_name_in, int credit_hours_in, String
   grade_recieved_in, String semester_in) {
      course_name = course_name_in;
      credit_hours = credit_hours_in;
      grade_recieved = grade_recieved_in;
      semester = semester_in;
      withdrew = false;
      
      if (grade_recieved.equals("A")) {
         gpa_points = 4;
         pass = true;
      }
      else if (grade_recieved.equals("B")) {
         gpa_points = 3;
         pass = true;
      }
      else if (grade_recieved.equals("C")) {
         gpa_points = 2;
         pass = true;
      }
      else if (grade_recieved.equals("D")) {
         gpa_points = 1;
         pass = false;
      }
      else if (grade_recieved.equals("F")) {
         gpa_points = 0;
         pass = false;
      }
      else if (grade_recieved.equals("W")) {
         pass = false;
         withdrew = true;
      }
      else if (grade_recieved.equals("P")) {
         pass = true;
         
      }
      else if (grade_recieved.equals("NP")) {
         pass = false;
      }
   }

}