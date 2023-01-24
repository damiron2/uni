import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Anna\\IdeaProjects\\uni\\src\\main\\resources\\universityInfo.xlsx");

        List<University> universities = FileReader.ReadUniversitiesXlsx(file);
        List<Student> students = FileReader.ReadStudentXlsx(file);

        UniversityComparator universityComparator = ComparatorTypeSelector.getUniversityComparator(UniversityComparatorType.ID);
        universities.sort(universityComparator);

        StudentsComparator studentsComparator = ComparatorTypeSelector.getStudentComparator(StudentsComparatorType.AVG_EXAM_SCORE);
        students.sort(studentsComparator);

        Stream.of(students).forEach(System.out::println);
        Stream.of(universities).forEach(System.out::println);
    }
}
