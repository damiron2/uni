import lombok.extern.log4j.Log4j;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Log4j
public class Main {
    public static void main(String[] args) {
        log.debug("Start");

        File fileToRead = new File("C:\\Users\\Anna\\IdeaProjects\\uni\\src\\main\\resources\\universityInfo.xlsx");
        File fileToWrite = new File("C:\\Users\\Anna\\IdeaProjects\\uni\\src\\main\\resources\\statistics.xlsx");


        List<University> universities = FileReader.ReadUniversitiesXlsx(fileToRead);
        List<Student> students = FileReader.ReadStudentXlsx(fileToRead);

        UniversityComparator universityComparator = ComparatorTypeSelector.getUniversityComparator(UniversityComparatorType.ID);
        universities.sort(universityComparator);

        StudentsComparator studentsComparator = ComparatorTypeSelector.getStudentComparator(StudentsComparatorType.AVG_EXAM_SCORE);
        students.sort(studentsComparator);

        String studentsJson = JsonUtil.listToJson(students);
        String universitiesJson = JsonUtil.listToJson(universities);

        List<University> deserializedUni = JsonUtil.jsonToListOfSUniversities(universitiesJson);
        List<Student> deserializedStu = JsonUtil.jsonToListOfStudents(studentsJson);

        List<Statistics> statistics = StatisticsUtils.makeStatistics(students, universities);

        FileWriter.XLSXWriter(fileToWrite,statistics);

        AllInfo allInfo = new AllInfo();
        allInfo.setStudentList(students);
        allInfo.setUniversitiesList(universities);
        allInfo.setStatisticsList(statistics);
        allInfo.setDateOfConvert(new Date());

        try {
            XMLWriter.makeXML(allInfo);
            JsonFileWriter.makeJson(allInfo);
        }
        catch (JAXBException e){
            log.debug(e);
        }

        log.debug("Finish");

    }
}
