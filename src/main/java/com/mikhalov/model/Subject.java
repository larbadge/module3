package com.mikhalov.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String name;
    @OneToOne()
    private Lecturer lecturer;

    @Override
    public String toString() {
        String s = "%s teaches %s %s";
        if (lecturer != null) {
            return String.format(s, getName(), lecturer.getFirstName(), lecturer.getLastName());
        } else {
            return String.format(s, getName(), "none", "");
        }
    }
}
