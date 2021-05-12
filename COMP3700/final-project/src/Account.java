public class Account {
   String username;
   String password;
   boolean admin_account;
   String student_account_id;
   
   public Account(String username_in, String password_in,
    String student_account_id_in, boolean admin_account_in) {
      username = username_in;
      password = password_in;
      student_account_id = student_account_id_in;
      admin_account = admin_account_in;
   }
   
   public String toString() {
      return "";
   }

}