package repository;

import dto.GroupAverageGrade;
import dto.GroupStudentsCount;
import model.Group;

import java.util.List;

public interface GroupRepository {

    Group getByName(String name);

    List<String> getNamesByPattern(String name);

    List<GroupStudentsCount> countStudensByEach();

    List<GroupAverageGrade> getAverageGrades();

}
