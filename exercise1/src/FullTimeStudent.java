import java.util.List;

public class FullTimeStudent extends Student{
   private Integer exam1Score;
    private Integer exam2Score;

    public FullTimeStudent(List quizScores, Integer exam1Score,Integer exam2Score, String name) {
        super(quizScores, name);
        this.exam1Score = exam1Score;
        this.exam2Score = exam2Score;
    }

    public Integer getExam1Score() {
        return exam1Score;
    }

    public Integer getExam2Score() {
        return exam2Score;
    }
}

