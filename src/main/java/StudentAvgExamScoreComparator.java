import java.util.Comparator;

public class StudentAvgExamScoreComparator implements StudentsComparator {
    @Override
    public int compare(Student student1, Student student2) {
        return Float.compare(student1.getAvgExamScore(), student2.getAvgExamScore());
    }

}
