import java.util.*;

public class Database {
   HashMap<String, Student> student_database;
   HashMap<String, Account> account_database;
   
   
   public Database() {
      student_database = new HashMap<>();
      account_database = new HashMap<>();
   }
   
   public void create_account() {
      boolean admin = false;
      String pass;
      String username;
      String account_id;
      System.out.println("Is this an admin account? y/n");
      Scanner scan = new Scanner(System.in);
      String response = scan.nextLine().substring(0, 1).toLowerCase();
      if (response.equals("y")) {
         admin = true;
      }
      System.out.println("Create a username");
      username = scan.nextLine();
      System.out.println("Create a password");
      pass = scan.nextLine();
      if (!admin) {
         System.out.println("Enter student ID");
         account_id = scan.nextLine();
      }
      else {
         account_id = "N/A";
      }
      Account a1 = new Account(username, pass, account_id, admin);
      System.out.println("Account Created");
      account_database.put(username, a1);
   }
   
   public void addStudent() {
      Scanner scan = new Scanner(System.in);
      Account user = login();
      if (!user.admin_account) {
         System.out.println("Admin privileges are needed to update information");
         return;
      }
      String name;
      int starting_year;
      String student_id;
      System.out.println("Enter Student name: ");
      name = scan.nextLine();
      System.out.println("Enter starting year: ");
      starting_year = Integer.parseInt(scan.nextLine());
      System.out.println("Enter student ID");
      student_id = scan.nextLine();
      System.out.println("Enter major: ");
      String major = scan.nextLine();
      System.out.println("Enter minor: ");
      String minor = scan.nextLine();
      student_database.put(student_id, new Student(name, starting_year, student_id, major, minor));
      System.out.println("Student succesfully added");
   }
   
   
   public void get_student_info() {
      Scanner scan = new Scanner(System.in);
      Account user = login();
      if (!user.admin_account) {
         System.out.println(student_database.get(user.student_account_id));
         return;
      }
      while (true) {
         String studentID;
         System.out.println("Enter ID of student: ");
         studentID = scan.nextLine();
         if (!student_database.containsKey(studentID)) {
            System.out.println("Invalid student ID");
            return;
         }
         System.out.println(student_database.get(studentID).toString());
         System.out.println("View another students info? y/n");
         String response = scan.nextLine();
         if (response.equals("n")) {
            return;
         }
      }
   
   }
   
   public void update_student_info() {
      Account user = login();
      Scanner scan = new Scanner(System.in);
      String student_id;
      if (!user.admin_account) {
         System.out.println("You need admin privileges to update student info");
         return;
      }
      while (true) {
         System.out.println("Enter the students ID number: ");
         student_id = scan.nextLine();
         if (!student_database.containsKey(student_id)) {
            System.out.println("Invalid student ID");
            return;
         }
         Student s = student_database.get(student_id);
         System.out.println("Select an option");
         System.out.println("A. Update GPA");
         System.out.println("B. Update Major");
         System.out.println("C. Update Minor");
         System.out.println("D. Add course result");
         System.out.println("E. Update graduation year");
         String choice = scan.nextLine();
         if (choice.equals("A")) {
            System.out.println("Enter updated gpa: ");
            double new_gpa = Double.parseDouble(scan.nextLine());
            s.gpa = new_gpa;
            System.out.println("gpa succesfully updated");
         }
         else if (choice.equals("B")) {
            System.out.println("Enter updated major: ");
            String new_major = scan.nextLine();
            s.major = new_major;
            System.out.println("major succesfully updated");
         }
         else if (choice.equals("C")) {
            System.out.println("Enter updated minor: ");
            String new_minor = scan.nextLine();
            s.minor = new_minor;
            System.out.println("minor succesfully updated");
         }
         else if (choice.equals("D")) {
            System.out.println("Enter course name: ");
            String course_name = scan.nextLine();
            System.out.println("Enter credit hours: ");
            int credit_hours = Integer.parseInt(scan.nextLine());
            System.out.println("Enter grade received (A/B/C/D/F/W/P/NP): ");
            String grade_received = scan.nextLine();
            System.out.println("Enter semester taken: i.e Fall 2019 ");
            String semester = scan.nextLine();
            Grades course = new Grades(course_name, credit_hours, grade_received, semester);
            s.add_grade(course);
            System.out.println("Student course results succesfully updated");
         }
         else if (choice.equals("E")) {
            System.out.println("Enter updated graduation year: ");
            int new_grad_year = Integer.parseInt(scan.nextLine());
            s.graduation_year = new_grad_year;
            System.out.println("Grad year succesfully updated");
         }
         else {
            System.out.println("Invalid choice");
         
         }
         System.out.println("Update another students info? y/n");
         String response = scan.nextLine();
         if (response.equals("n")) {
            return;
         }
         
      }
      
   }
   
   public Account login() {
      Scanner scan = new Scanner(System.in);
      String user;
      String pass;
      Account acc;
      System.out.println("Enter login info");
      while (true) {
         System.out.println("Enter username: ");
         user = scan.nextLine();
         if (!account_database.containsKey(user)) {
            System.out.println("Invalid Username, please try again");
            continue;
         }
         break;
      }
      acc = account_database.get(user);
      while (true) {
         System.out.println("Enter password: ");
         pass = scan.nextLine();
         if (pass.equals(acc.password)) {
            break;
         }
         System.out.println("Password does not match, please try again");
      }
      System.out.println("Login succesfull");
      return acc;
   }
   


}