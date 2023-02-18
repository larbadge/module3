package repository;

import dto.GroupAverageGrade;
import dto.GroupStudentsCount;

import java.util.List;

public interface GroupRepository {

    List<String> getAllByName(String name);

    List<GroupStudentsCount> countStudensByEach();

    List<GroupAverageGrade> getAverageGrades();

}
