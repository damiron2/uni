public class Main {
    public static void main(String[] args) {
    University university_1 = new University("1","Университет_1","У1",2022,StudyProfile.MATH);
    University university_2 = new University("2","Университет_2","У2",2022,StudyProfile.FOREIGN_LANG);

    Student student_1 = new Student("Иванов Иван Иванович","1",1,4.9f);
    Student student_2 = new Student("Петров Петр Петрович","2",3,4.5f);

        System.out.println(university_2);
        System.out.println(student_1);

    }
}
