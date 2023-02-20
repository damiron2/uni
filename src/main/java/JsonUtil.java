import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class JsonUtil {

    private JsonUtil(){

    }

    public static String studentToJson(Student student){
        return new GsonBuilder().setPrettyPrinting().create().toJson(student);

    }

    public static Student jsonToStudent(String json){
        return new Gson().fromJson(json, Student.class);
    }

    public static String universityToJson(University university){
        return new GsonBuilder().setPrettyPrinting().create().toJson(university);
    }

    public static University jsonToUniversity (String json){
        return new Gson().fromJson(json, University.class);
    }

     public static String listToJson(List<?> list){
        return new GsonBuilder().setPrettyPrinting().create().toJson(list);
    }

    public static List<Student> jsonToListOfStudents(String json){
        return new Gson().fromJson(json,new TypeToken<List<Student>>(){}.getType());
    }



    public static List<University> jsonToListOfSUniversities(String json){
        return new Gson().fromJson(json, new TypeToken<List<University>>(){}.getType());
    }
}
