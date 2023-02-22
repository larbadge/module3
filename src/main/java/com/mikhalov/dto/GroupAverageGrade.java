package com.mikhalov.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GroupAverageGrade {

    private String groupName;
    private Double averageGrade;

    @Override
    public String toString() {
        return String.format("Group %s average grade = %.1f", getGroupName(), getAverageGrade());
    }

}
