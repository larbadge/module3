package service;

import repository.StudentRepository;

public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository studentRepository) {
        this.repository = studentRepository;
    }

    public void printCountByGroup() {
        repository.countByGroup()
                .forEach(v -> {
                    System.out.printf("Group %s have %d students%n", v.getGroupName(), v.getStudentCount());
                });
    }
}
