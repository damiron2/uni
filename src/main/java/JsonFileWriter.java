import lombok.extern.log4j.Log4j;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Log4j
public class JsonFileWriter {


    private JsonFileWriter() {

    }

    public static void makeJson(AllInfo allInfo) {
        log.debug("Конвертация в json стартовала");
        try {
            Files.createDirectory(Paths.get("jsonReqs"));
            log.debug("Директория создана");
        } catch (IOException e) {
            log.debug("Директория уже существует" + " " + e);
        }
        studentsListToJson(allInfo);
        universitiesListToJson(allInfo);
        statisticsListToJson(allInfo);
    }

    public static void studentsListToJson(AllInfo allInfo){
        String studentsJson = JsonUtil.listToJson(allInfo.getStudentList());
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("jsonReqs/students" + allInfo.getDateOfConvert().getTime()+".json");
            fileOutputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
            fileOutputStream.close();
            log.debug("Студенты записаны в json");
        }
        catch (IOException e){
            log.debug("Не удалось записать json со студентами");
        }
    }

    public static void universitiesListToJson (AllInfo allInfo){
        String universitiesJson = JsonUtil.listToJson(allInfo.getUniversitiesList());
        try {
            FileOutputStream outputStream = new FileOutputStream("jsonReqs/universities" + allInfo.getDateOfConvert().getTime() + ".json");
            outputStream.write(universitiesJson.getBytes(StandardCharsets.UTF_8));
            outputStream.close();
            log.debug("Университеты записаны в json");
        }
        catch (IOException e){
            log.debug("Не удалось записать json с университетами");
        }
    }

    public static void statisticsListToJson (AllInfo allInfo){
        String statisticsJson = JsonUtil.listToJson(allInfo.getStatisticsList());
        try {
            FileOutputStream outputStream = new FileOutputStream("jsonReqs/statistics" + allInfo.getDateOfConvert().getTime() + ".json");
            outputStream.write(statisticsJson.getBytes(StandardCharsets.UTF_8));
            outputStream.close();
            log.debug("Статистика записана в json");
        }
        catch (IOException e){
            log.debug("Не удалось записать json сщ статистикой");
        }
    }
}
