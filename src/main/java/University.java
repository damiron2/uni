import com.google.gson.annotations.SerializedName;

public class University {
    @SerializedName("ID")
    String id;
    @SerializedName("Name")
    String fullName;
    @SerializedName("Short")
    String shortName;
    @SerializedName("Year")
    int yearOfFoundation;
    @SerializedName("Profile")
    StudyProfile mainProfile;

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    @Override
    public String toString() {
        return "Университет{" +
                "id='" + id + '\'' +
                ", Название='" + fullName + '\'' +
                ", Короткое название='" + shortName + '\'' +
                ", Год основания=" + yearOfFoundation +
                ", Профиль=" + mainProfile +
                '}';
    }

    public University() {
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }
}
