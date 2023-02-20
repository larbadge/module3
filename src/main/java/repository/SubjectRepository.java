package repository;

import dto.TopAndBottomPerformingSubjects;
import model.Subject;

import java.util.List;

public interface SubjectRepository {

    List<Subject> getRandomSubjects(int count);

    TopAndBottomPerformingSubjects getTopAndBottomPerformingSubjects();
}
