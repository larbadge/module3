package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "student_group")
@ToString
public class Group {


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @ToString.Exclude
    private String id;
    @Column(unique = true, nullable = false)
    private String name;
    @OneToMany(mappedBy = "group")
    @ToString.Exclude
    private List<Student> students = new ArrayList<>();

}
