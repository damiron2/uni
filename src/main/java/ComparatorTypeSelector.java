public class ComparatorTypeSelector {

    private ComparatorTypeSelector() {
    }

    public static StudentsComparator getStudentComparator (StudentsComparatorType studentsComparatorType){
        switch (studentsComparatorType){
            case UNIVERSITY_ID: return new StudentUniversityIdComparator();
            case AVG_EXAM_SCORE: return new StudentAvgExamScoreComparator();
            case CURRENT_COURSE_NUMBER: return new StudentCurrentCourseNumberComparator();
            default: return new StudentFullNameComparator();
        }
    }

    public static UniversityComparator getUniversityComparator(UniversityComparatorType universityComparatorType){
        switch (universityComparatorType){
            case ID: return new UniversityIdComparator();
            case YEAR_OF_FOUNDATION: return new UniversityYearOfFoundationComparator();
            case MAIN_PROFILE: return new UniversityMainProfileComparator();
            case SHORT_NAME: return new UniversityShortNameComparator();
            default: return new UniversityFullNameComparator();
        }
    }

}
