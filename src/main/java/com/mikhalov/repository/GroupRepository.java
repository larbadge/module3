package com.mikhalov.repository;

import com.mikhalov.dto.GroupAverageGrade;
import com.mikhalov.dto.GroupStudentsCount;
import com.mikhalov.model.Group;

import java.util.List;

public interface GroupRepository {

    Group getByName(String name);

    List<String> getNamesByPattern(String name);

    List<GroupStudentsCount> countStudensByEach();

    List<GroupAverageGrade> getAverageGrades();

}
