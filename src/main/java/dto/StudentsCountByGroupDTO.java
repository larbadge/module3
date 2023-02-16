package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentsCountByGroupDTO {
    private String groupName;
    private Long studentCount;

    public StudentsCountByGroupDTO(String groupName, Long studentCount) {
        this.groupName = groupName;
        this.studentCount = studentCount;
    }
}