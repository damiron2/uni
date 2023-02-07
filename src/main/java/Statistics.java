
public class Statistics {

    private StudyProfile studyProfile;
    private float avgExamScore;
    private int studentsCountByProfile;
    private int uniCountByProfile;
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
