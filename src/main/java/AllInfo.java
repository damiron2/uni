import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class AllInfo {
    @XmlElementWrapper(name = "StudentsInfo")
    @XmlElement(name = "studentEntry")
    private List<Student> studentList;

    @XmlElementWrapper(name = "UniversitiesInfo")
    @XmlElement(name = "universityEntry")
    private  List<University> universities;
    @XmlElementWrapper(name = "StatisticsInfo")
    @XmlElement(name = "statisticsEntry")
    private  List<Statistics> statisticsList;

    @XmlElement(name = "processedAt")
    private Date dateOfConvert;

    public AllInfo(){

    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public List<University> getUniversitiesList() {
        return universities;
    }

    public List<Statistics> getStatisticsList() {
        return statisticsList;
    }

    public Date getDateOfConvert() {
        return dateOfConvert;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void setUniversitiesList(List<University> universities) {
        this.universities = universities;
    }

    public void setStatisticsList(List<Statistics> statisticsList) {
        this.statisticsList = statisticsList;
    }

    public AllInfo setDateOfConvert(Date dateOfConvert) {
        this.dateOfConvert = dateOfConvert;
        return this;
    }
}
