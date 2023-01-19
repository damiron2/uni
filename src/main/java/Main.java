import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Anna\\IdeaProjects\\uni\\src\\main\\resources\\universityInfo.xlsx");
        System.out.println(FileReader.ReadUniversitiesXlsx(file));
        System.out.println(FileReader.ReadStudentXlsx(file));
    }
}
