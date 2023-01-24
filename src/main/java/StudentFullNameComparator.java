import java.util.Comparator;
import org.apache.commons.lang3.StringUtils;

public class StudentFullNameComparator implements StudentsComparator {
    @Override
    public int compare(Student student1, Student student2) {
        return StringUtils.compare(student1.getFullName(),student2.getFullName());
    }
}

