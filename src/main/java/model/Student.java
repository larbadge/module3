package model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
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

    @Override
    public String toString() {
        String str = "%s %s %d years old from %s group(entry %s)";
        if (group != null) {
            return String.format(str,
                    getFirstName(), getLastName(),
                    getAge(), getGroup().getName(),
                    getEntryDate().format(FORMATTER));
        } else
            return String.format(str,
                    getFirstName(), getLastName(),
                    getAge(), "none",
                    getEntryDate().format(FORMATTER));
    }
}
