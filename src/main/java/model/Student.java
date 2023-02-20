package model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

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
    private Map<Subject, Integer> grades = new HashMap<>();
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
        private String firstName;
        private String lastName;
        private int age;
        private LocalDateTime entryDate;
        private Map<Subject, Integer> grades;
        private Group group;

        public Student build() {
            if (entryDate == null) {
                entryDate = LocalDateTime.now();
            }

            return new Student(null, firstName, lastName, age, entryDate, grades, group);
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

        public Builder addGrades(Map<Subject, Integer> grades) {
            this.grades = grades;
            return this;
        }
    }

}
