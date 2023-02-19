package model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor()
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Student {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(nullable = false)
    private int age;
    @Column(name = "entry_date", nullable = false)
    private LocalDateTime entryDate = LocalDateTime.now();
    @ElementCollection
    @CollectionTable(name = "student_grades")
    @MapKeyJoinColumn(name = "subject_id")
    @Column(name = "grade")
    @Setter(AccessLevel.NONE)
    private Map<Subject, Double> grades = new HashMap<>();
    @OneToOne
    private Group group;

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        String str = "%s %s %d years old from %s group(entry %s)%nGrades: %s";
        if (group != null) {
            return String.format(str,
                    getFirstName(), getLastName(),
                    getAge(), getGroup().getName(),
                    getEntryDate().format(FORMATTER),
                    getGrades()
            );
        } else
            return String.format(str,
                    getFirstName(), getLastName(),
                    getAge(), "none",
                    getEntryDate().format(FORMATTER),
                    getGrades()
            );
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Builder {
        private final String id = UUID.randomUUID().toString();
        private String firstName;
        private String lastName;
        private int age;
        private LocalDateTime entryDate;
        private final Map<Subject, Double> grades = new HashMap<>();
        private Group group;

        public Student build() {
            Student student = new Student(id, firstName, lastName, age, entryDate, grades, group);
            if (group != null) {
                group.getStudents().add(student);
            }
            if (entryDate == null) {
                entryDate = LocalDateTime.now();
            }

            return student;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder entryDate(LocalDateTime entryDate) {
            this.entryDate = entryDate;
            return this;
        }

        public Builder group(Group group) {
            this.group = group;
            return this;
        }

        public Builder addGrade(Subject subject, double grade) {
            this.grades.put(subject, grade);
            return this;
        }

    }

}
