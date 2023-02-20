import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class Statistics {
    @SerializedName("UniversityProfile")
    @XmlElement(name = "UniversityProfile")
    private StudyProfile studyProfile;
    @SerializedName("AverageExamScore")
    @XmlElement(name = "AverageExamScore")
    private float avgExamScore;
    @XmlTransient
    private int studentsCountByProfile;
    @XmlTransient
    private int uniCountByProfile;
    @XmlTransient
    private String uniNames;



    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public Statistics setStudyProfile(StudyProfile studyProfile){
        this.studyProfile = studyProfile;
        return  this;
    }

    public int getStudentsCountByProfile() {
        return studentsCountByProfile;
    }

    public Statistics setStudentsCountByProfile(int studentsCountByProfile) {
        this.studentsCountByProfile = studentsCountByProfile;
        return this;
    }

    public int getUniCountByProfile() {
        return uniCountByProfile;

    }

    public Statistics setUniCountByProfile(int uniCountByProfile) {
        this.uniCountByProfile = uniCountByProfile;
        return this;
    }
    public String getUniNames() {
        return uniNames;
    }

    public Statistics setUniNames(String uniNames) {
        this.uniNames = uniNames;
        return this;
    }


    public float getAvgExamScore() {
        return avgExamScore;
    }

    public Statistics setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }
}
