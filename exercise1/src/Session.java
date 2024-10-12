import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Session {
    private List<Student> students;
    public Session(List students){
        this.students = students;
    }

    public  void calculateAverageStudentScore(){
        for(int i = 0; i <students.size();i++){
            Student student = students.get(i);
            List<Integer> quizScores = student.getQuizScores();
            double sum = 0;

            for(int j = 0; j < quizScores.size(); j++){
                sum+=quizScores.get(j);
            }

            if (student instanceof FullTimeStudent) {
             Integer   examscore1 = ((FullTimeStudent) student).getExam1Score();
             Integer   examscore2= ((FullTimeStudent) student) .getExam2Score();
             sum+=examscore1;
             sum+=examscore2;
            }

            double averageStudentScore = sum/quizScores.size();
            System.out.println("Student " + student.getName() + " average score: " + averageStudentScore);

        }



    }
    public  void printQuizScores(){
        Collections.sort(students, (s1, s2) -> {
            int sum1 = 0;
            List<Integer> quizScores1 = s1.getQuizScores();
            for(int j = 0; j < quizScores1.size(); j++){
                sum1+=quizScores1.get(j);
            }

            int sum2 = 0;
            List<Integer> quizScores2 = s2.getQuizScores();
            for(int j = 0; j < quizScores2.size(); j++){
                sum2+=quizScores2.get(j);
            }

            return Integer.compare(sum1, sum2);
        });

        for(int i = 0; i <students.size();i++) {
            Student student = students.get(i);
            System.out.println("Student " + student.getName() + " quiz score: " + student.getQuizScores());
        }
    }
    public  void printPartTimeStudentsNames(){
        for(int i = 0; i <students.size();i++){
            Student student = students.get(i);
            if (student instanceof PartTimeStudent) {
                System.out.println("Part time student name: " + student.getName());
            }
        }
    }
    public  void printFullTimeStudentScores(){
        for(int i = 0; i <students.size();i++){
            Student student = students.get(i);
            if (student instanceof FullTimeStudent) {

                Integer   examscore1 = ((FullTimeStudent) student).getExam1Score();
                Integer   examscore2= ((FullTimeStudent) student) .getExam2Score();
                System.out.println("Full time student " + student.getName() + " exam score: [" + examscore1 + ", " + examscore2 + "]");
            }
        }
    }


}
