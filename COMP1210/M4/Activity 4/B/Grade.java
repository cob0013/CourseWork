/**
*represents grade in comp 1210.
*
*activity 4B
*@CarsonBarnett-COMP1210-003
*@2/11/19
*/
public class Grade {
/**
*grading method.
*@param args command line (not used)
*/
//instance variables
   private double exam1;
   private double exam2;
   private double finalExam;
   private double activityAvg;
   private double quizAvg;
   private double projectAvg;
   private String studentName;
   
   //constants
   /**
   *public constants.
   *@param args command line (not used)
   */
   public static final int EXAM_1 = 1, EXAM_2 = 2, FINAL = 3;
   /**
   *private constants.
   *@param args command line (not used)
   */
   private static final double EXAM_WEIGHT = 0.15,
      FINAL_WEIGHT = 0.30, ACT_WEIGHT = 0.05,
      QUIZ_WEIGHT = 0.10, PROJ_WEIGHT = 0.25;
   //constructor 
   /**
   *grading constructor.
   *@param studentNameIn student name input
   */
   public Grade(String studentNameIn) {
      studentName = studentNameIn;
   
   }
   
   //methods
   /**
   *sets lab averages.
   *@param activityAvgIn average activity input
   *@param quizAvgIn average quiz input
   */
   public void setLabAverages(double activityAvgIn, double quizAvgIn) {
      activityAvg = activityAvgIn;
      quizAvg = quizAvgIn;
      
   }
   /**
   *sets project avg.
   *@param projectAvgIn project average input
   */
   public void setProjectAvg(double projectAvgIn) {
      projectAvg = projectAvgIn;
   }
   /**
   *sets exam score.
   *@param examType type of exam
   *@param examScoreIn exam score input
   */
   public void setExamScore(int examType, double examScoreIn) {
      if (examType == EXAM_1) {
         exam1 = examScoreIn; 
      }
      else if (examType == EXAM_2) {
         exam2 = examScoreIn;
      }
      else if (examType == FINAL) { 
         finalExam = examScoreIn;
      }
   }
   /**
   *calculates grade.
   *@return grade returns grade
   */
   public double calculateGrade() {
      double grade = exam1 * EXAM_WEIGHT + exam2 * EXAM_WEIGHT
         + finalExam * FINAL_WEIGHT
         + activityAvg * ACT_WEIGHT
         + quizAvg * QUIZ_WEIGHT
         + projectAvg * PROJ_WEIGHT;
   
      return grade;
   }
   /**
   *grades to string.
   *@return output returns output
   */
   public String toString() {
      return "Name: " + studentName + "\n"
         + "Course Grade: " + calculateGrade();
   }
}