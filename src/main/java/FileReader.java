import lombok.extern.log4j.Log4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Log4j
public class FileReader {

    private FileReader(){

    };

    public static List<Student> ReadStudentXlsx(File file) {
        List<Student> studentsList = new ArrayList<>();

        try{
        XSSFWorkbook myBook = new XSSFWorkbook(new FileInputStream(file));
        XSSFSheet myStudentsSheet = myBook.getSheet("Студенты");

        Iterator<Row> rows = myStudentsSheet.iterator();
        rows.next();
        while (rows.hasNext()){
            Row curRow = rows.next();
            Student student = new Student();
            studentsList.add(student);
            student.setUniversityId(curRow.getCell(0).getStringCellValue());
            student.setFullName(curRow.getCell(1).getStringCellValue());
            student.setCurrentCourseNumber((int)curRow.getCell(2).getNumericCellValue());
            student.setAvgExamScore((float)curRow.getCell(3).getNumericCellValue());
        }
        myBook.close();
        log.debug("XLS Файл прочитан"+" "+file);
        return studentsList;
        }
        catch (IOException e){
            log.debug("Не удается найти указанный файл"+" "+file);
        }
        return studentsList;
    }

    public static List<University> ReadUniversitiesXlsx(File file) {
        List<University> universitiesList = new ArrayList<>();
        try {

            XSSFWorkbook myBook = new XSSFWorkbook(new FileInputStream(file));
            XSSFSheet myUniversitiesSheet = myBook.getSheet("Университеты");

            Iterator<Row> rows = myUniversitiesSheet.iterator();
            rows.next();

            while (rows.hasNext()) {
                Row curRow = rows.next();
                University university = new University();
                universitiesList.add(university);
                university.setId(curRow.getCell(0).getStringCellValue());
                university.setFullName(curRow.getCell(1).getStringCellValue());
                university.setShortName(curRow.getCell(2).getStringCellValue());
                university.setYearOfFoundation((int) curRow.getCell(3).getNumericCellValue());
                university.setMainProfile(StudyProfile.valueOf(curRow.getCell(4).getStringCellValue()));
            }

            myBook.close();
            return universitiesList;
        }
        catch (IOException e){
        log.debug("Не удается найти указанный файл"+" "+file);
        }
        return universitiesList;
    }


}
