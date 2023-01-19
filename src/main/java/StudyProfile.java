public enum StudyProfile { MEDICINE("Медицина"), MATHEMATICS("Математика"), LINGUISTICS("Ин-яз"),
    PHYSICS("Физика");

    private final String profileName;
    private StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}


