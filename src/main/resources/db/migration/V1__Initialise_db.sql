CREATE TABLE lecturer (
    id VARCHAR(255) NOT NULL PRIMARY KEY,
    age INT NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL
);

CREATE TABLE student_group (
    id VARCHAR(255) PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    UNIQUE(name)
);

CREATE TABLE student (
    id VARCHAR(255) NOT NULL PRIMARY KEY,
    age INT NOT NULL,
    entry_date TIMESTAMP NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    group_id VARCHAR(255),
    FOREIGN KEY (group_id) REFERENCES student_group(id)
);

CREATE TABLE subject (
    id VARCHAR(255) PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    lecturer_id VARCHAR(255),
    FOREIGN KEY (lecturer_id)  REFERENCES lecturer(id)
);

CREATE TABLE student_grades (
    student_id VARCHAR(255) NOT NULL,
    grade INT NOT NULL,
    subject_id VARCHAR(255) NOT NULL,
    PRIMARY KEY(student_id, subject_id),
    FOREIGN KEY (subject_id) REFERENCES subject(id),
    FOREIGN KEY (student_id) REFERENCES student(id)
);




