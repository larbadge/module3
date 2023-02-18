package repository;

import dto.GroupAverageGrade;
import dto.GroupStudentsCount;
import model.Group;

import java.util.List;

public interface GroupRepository {

    List<Group> getAllByName(String name);

    List<GroupStudentsCount> countStudensByName();

    List<GroupAverageGrade> getAverageGrades();

}
