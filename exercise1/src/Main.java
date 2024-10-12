import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List students = new ArrayList<Student>(20);
        Random random = new Random();
        String names = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < 10; i++) {
            List quizscores = new ArrayList<Integer>(15);
            for(int j = 0; j <15; j++){
                Integer score = random.nextInt(100);
                quizscores.add(score);
            }

            String name = names.substring(i * 2, i * 2 + 1);
            PartTimeStudent student = new PartTimeStudent(quizscores, name);
            students.add(student);

            String fname = names.substring(i * 2 + 1, i * 2 + 2);
            Integer exam1score = random.nextInt(100);
            Integer exam2score = random.nextInt(100);
            FullTimeStudent fstudent = new FullTimeStudent(quizscores, exam1score, exam2score, fname);

            students.add(fstudent);

        }
        Session session = new Session(students);

        session.calculateAverageStudentScore();
        System.out.println("");
        System.out.println("==========================================");
        System.out.println("");
        session.printFullTimeStudentScores();
        System.out.println("");
        System.out.println("==========================================");
        System.out.println("");
        session.printQuizScores();
        System.out.println("");
        System.out.println("==========================================");
        System.out.println("");
        session.printPartTimeStudentsNames();
    }
}
