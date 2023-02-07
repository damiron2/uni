import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        File fileToRead = new File("C:\\Users\\Anna\\IdeaProjects\\uni\\src\\main\\resources\\universityInfo.xlsx");
        File fileToWrite = new File("C:\\Users\\Anna\\IdeaProjects\\uni\\src\\main\\resources\\statistics.xlsx");


        List<University> universities = FileReader.ReadUniversitiesXlsx(fileToRead);
        List<Student> students = FileReader.ReadStudentXlsx(fileToRead);

        UniversityComparator universityComparator = ComparatorTypeSelector.getUniversityComparator(UniversityComparatorType.ID);
        universities.sort(universityComparator);

        StudentsComparator studentsComparator = ComparatorTypeSelector.getStudentComparator(StudentsComparatorType.AVG_EXAM_SCORE);
        students.sort(studentsComparator);

        Stream.of(students).forEach(System.out::println);
        Stream.of(universities).forEach(System.out::println);

        String studentsJson = JsonUtil.studentsToJson(students);
        String universitiesJson = JsonUtil.universitiesToJson(universities);

        System.out.println(studentsJson);
        System.out.println(universitiesJson);

        List<University> deserializedUni = JsonUtil.jsonToListOfSUniversities(universitiesJson);
        List<Student> deserializedStu = JsonUtil.jsonToListOfStudents(studentsJson);

        System.out.println(deserializedUni);
        System.out.println(deserializedStu);

        students.stream().forEach(student -> {
            String stuJson = JsonUtil.studentToJson(student);
            System.out.println(stuJson);
            Student stuFromJson = JsonUtil.jsonToStudent(stuJson);
            System.out.println(stuFromJson);
        });

        universities.stream().forEach(university -> {
            String uniJson = JsonUtil.universityToJson(university);
            System.out.println(uniJson);
            University uniFromJson = JsonUtil.jsonToUniversity(uniJson);
            System.out.println(uniFromJson);
        });


        FileWriter.XLSXWriter(fileToWrite,StatisticsUtils.makeStatistics(students, universities));


    }
}
