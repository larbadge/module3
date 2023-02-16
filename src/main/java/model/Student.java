package model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private LocalDateTime entryDate = LocalDateTime.now();
    @ElementCollection
    @CollectionTable(name = "student_grades")
    @MapKeyJoinColumn(name = "subject_id")
    @Column(name = "grade")
    @Setter(AccessLevel.NONE)
    private Map<Subject, Double> grades = new HashMap<>();
    @OneToOne
    private Group group;

}
