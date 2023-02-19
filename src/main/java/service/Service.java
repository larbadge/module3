package service;

import model.Group;
import model.Lecturer;
import model.Student;
import repository.*;

import java.time.LocalDateTime;
import java.util.List;

import static util.RandomGenerator.*;

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
        List<Student> grades = studentRepository.getAllByAverageGradeGreaterThan(grade);
        if (grades.size() != 0) {
            grades.forEach(System.out::println);
        } else {
            System.out.println("Nothing... Try again");
        }
    }

    public void printLecturersByFirstOrLastName(String name) {
        List<Lecturer> lecturers = lecturerRepository.getAllByNameOrLastname(name);
        if (lecturers.size() != 0) {
            lecturers.forEach(System.out::println);
        } else {
            System.out.println("Nothing... Try again");
        }
    }

    public void printGroupsByName(String name) {
        List<String> groups = groupRepository.getAllByName(name);
        if (groups.size() != 0) {
            groups.forEach(System.out::println);
        } else {
            System.out.println("Nothing... Try again");
        }
    }

    public void printEachGroupCountOfStudents() {
        groupRepository.countStudensByEach()
                .forEach(System.out::println);
    }

    public void printEachGroupAverageGrade() {
        groupRepository.getAverageGrades()
                .forEach(System.out::println);
    }

    public void printTopAndBottomPerformingSubjects() {
        var dto = subjectRepository.getTopAndBottomPerformingSubjects();
        System.out.println(dto);

    }

    public void createAndPrintRandomStudent() {
        var subjects = subjectRepository.getTopAndBottomPerformingSubjects();
        Group group = Group.builder()
                .name("RANDOM")
                .build();
        Student randomStudent = Student.builder()
                .firstName(getString())
                .lastName(getString())
                .age(getAge())
                .entryDate(LocalDateTime.of(2022, 9, 1, 9, 0))
                .addGrade(subjects.getBottomSubject(), getRandomGrade())
                .addGrade(subjects.getTopSubject(), getRandomGrade())
                .group(group)
                .build();

        System.out.println(randomStudent);
    }

}
