import java.util.List;

public class Student {
    private List quizScores;
    private String name;

    public Student(List quizScores, String name) {
        this.quizScores = quizScores;
        this.name = name;
    }

    public List getQuizScores() {
        return quizScores;
    }

    public String getName() {
        return name;
    }
}
