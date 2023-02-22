package com.mikhalov.service;

import com.mikhalov.dto.StudentAverageGrade;
import com.mikhalov.model.Lecturer;
import com.mikhalov.model.Student;
import com.mikhalov.model.Subject;
import com.mikhalov.repository.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static com.mikhalov.util.RandomGenerator.*;

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
        List<StudentAverageGrade> grades = studentRepository.getAllByAverageGradeGreaterThan(grade);
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
        List<String> groups = groupRepository.getNamesByPattern(name);
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
        var randomGroup = groupRepository.getByName("RANDOM");

        LocalDateTime entry = LocalDateTime.of(2022, 9, 1, 9, 0);

        Map<Subject, Integer> grades = new HashMap<>();
        List<Subject> randomSubjects = subjectRepository.getRandomSubjects(3);
        IntStream.range(0, randomSubjects.size())
                .forEach(i -> grades.put(randomSubjects.get(i), getRandomGrade()));

        Student randomStudent = Student.builder()
                .firstName(getString())
                .lastName(getString())
                .age(getAge())
                .entryDate(entry)
                .group(randomGroup)
                .addGrades(grades)
                .build();

        studentRepository.save(randomStudent);
        System.out.println(randomStudent);
    }

}
