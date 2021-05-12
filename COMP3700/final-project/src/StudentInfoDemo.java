public class StudentInfoDemo {
   public static void main(String[] args) {
      Database database = new Database();
      
      //demo building students
      Student student1 = new Student("Barnett, Carson", 2018, "5808", "CSSE", "Undeclared");
      student1.gpa = 3.5;
      Student student2 = new Student("Gun, David", 2019, "1234", "CSSE", "French");
      student2.gpa = 4.0;
      Student student3 = new Student("Smith, John", 2020, "9999", "Business", "Undeclared");
      student3.gpa = 3.2;
      Student student4 = new Student("Abrams, John", 2017, "4321", "Nursing", "Spanish");
      student4.gpa = 2.5;
      
      
      
      //manually load students into database at first
      database.student_database.put(student1.student_id, student1);
      database.student_database.put(student2.student_id, student2);
      database.student_database.put(student3.student_id, student3);
      database.student_database.put(student4.student_id, student4);
      
      
      //demo creating normal student account
      //each student has a unique student ID they use to create their account
      database.create_account();
      
      //demo viewing students own information grades
      database.get_student_info();
      
      //demo an admin account created
      
      database.create_account();
      
      //demo an admin viewing 2 of the students information
      
      database.get_student_info();
      
      //demo an admin updating a students information 3 different ways
      
      database.update_student_info();
      
      
      //then show students new info
      
      database.get_student_info();
                 
   }


}