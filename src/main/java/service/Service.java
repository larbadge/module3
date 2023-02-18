package service;

import dto.TopAndBottomPerformingSubjects;
import repository.*;

public class Service {

    private final static Service INSTANCE = new Service();
    private final GroupRepository groupRepository;
    private final LecturerRepository lecturerRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    private Service() {
        this.groupRepository = RepositoryFactory.getGroupRepositoryInstance();
        this.lecturerRepository = RepositoryFactory.getLecturerRepositoryInstance();
        this.studentRepository = RepositoryFactory.getStudentRepositoryInstance();
        this.subjectRepository = RepositoryFactory.getSubjectRepositoryInstance();
    }

    public static Service getInstance() {
        return INSTANCE;
    }

    public void printStudentsWithAverageGradeUpperThan(double grade) {
        studentRepository.getAllByAverageGradeGreaterThan(grade)
                .forEach(System.out::println);
    }

    public void printLecturersByFirstOrLastName(String name) {
        lecturerRepository.getAllByNameOrLastname(name)
                .forEach(System.out::println);
    }

    public void printGroupsByName(String name) {
        groupRepository.getAllByName(name)
                .forEach(System.out::println);
    }

    public void printCountOfStudentsByGroup() {
        groupRepository.countStudensByName()
                .forEach(System.out::println);
    }

    public void printEachGroupAverageGrade() {
        groupRepository.getAverageGrades()
                .forEach(System.out::println);
    }

    public void printSubjectsByGradeThresholds() {
        TopAndBottomPerformingSubjects dto = subjectRepository.getTopAndBottomPerformingSubjects();
        System.out.println(dto);

    }

}
