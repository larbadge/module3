package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GroupStudentsCount {

    private String groupName;
    private Long studentCount;

    @Override
    public String toString() {
        return String.format("Group %s have %d students%n", getGroupName(), getStudentCount());
    }
}