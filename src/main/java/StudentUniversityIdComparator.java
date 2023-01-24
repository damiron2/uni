import org.apache.commons.lang3.StringUtils;
import java.util.Comparator;
public class StudentUniversityIdComparator implements StudentsComparator{
    @Override
    public int compare(Student student1, Student student2) {
        return StringUtils.compare(student1.getUniversityId(), student2.getUniversityId());
    }
}
