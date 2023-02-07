import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class StatisticsUtils {

    public static List<Statistics> makeStatistics(List<Student> students, List<University> universities){
        List<Statistics> statisticsResult = new ArrayList<>();

        Set<StudyProfile> studyProfiles = universities.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());

        studyProfiles.forEach(studyProfile -> {
            Statistics statistics = new Statistics();
            statisticsResult.add(statistics);
            statistics.setStudyProfile(studyProfile);

            List<String> profileUniIds = universities.stream()
                    .filter(university -> university.getMainProfile().equals(studyProfile))
                    .map(University::getId)
                    .collect(Collectors.toList());

            statistics.setUniCountByProfile(profileUniIds.size());
            statistics.setUniNames(StringUtils.EMPTY);

            universities.stream().filter(university -> profileUniIds.contains(university.getId()))
                    .map(University::getFullName)
                    .forEach(fullNameUniversity -> statistics.setUniNames(statistics.getUniNames()+fullNameUniversity+";"));

            List<Student> profileStudents = students.stream()
                    .filter(student -> profileUniIds.contains(student.getUniversityId()))
                    .collect(Collectors.toList());

            statistics.setStudentsCountByProfile(profileStudents.size());

            OptionalDouble avgExamScore = profileStudents.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();
            statistics.setAvgExamScore(0);
            avgExamScore.ifPresent(value -> statistics.setAvgExamScore(
                    (float) BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue()));
        });

        return statisticsResult;
    }
}
