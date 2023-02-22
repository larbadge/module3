package com.mikhalov.repository;

import com.mikhalov.dto.TopAndBottomPerformingSubjects;
import com.mikhalov.model.Subject;

import java.util.List;

public interface SubjectRepository {

    List<Subject> getRandomSubjects(int count);

    TopAndBottomPerformingSubjects getTopAndBottomPerformingSubjects();
}
