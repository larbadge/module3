package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Lecturer {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @ToString.Exclude
    private String id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(nullable = false)
    private int age;
    @OneToOne(mappedBy = "lecturer")
    @ToString.Exclude
    private Subject subject;

    public void setSubject(Subject subject) {
        subject.setLecturer(this);
        this.subject = subject;
    }

    @Override
    public String toString() {
        String str = "%s %s, %d years old, teach %s subject";
        if (subject != null) {
            return String.format(str, getFirstName(), getLastName(), getAge(), getSubject().getName());
        } else {
            return String.format(str, getFirstName(), getLastName(), getAge(), "none");
        }
    }
}
