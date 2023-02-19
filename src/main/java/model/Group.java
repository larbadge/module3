package model;

import lombok.*;
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
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
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
    @Builder.Default
    private List<Student> students = new ArrayList<>();

}
