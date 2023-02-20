DELETE FROM pg_extension WHERE extname = 'uuid-ossp';
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

INSERT INTO lecturer(id, age, first_name, last_name)
VALUES
(uuid_generate_v4(), 35, 'John', 'Doe'),
(uuid_generate_v4(), 28, 'Jane', 'Doe'),
(uuid_generate_v4(), 42, 'Bob', 'Smith'),
(uuid_generate_v4(), 39, 'Sarah', 'Lee'),
(uuid_generate_v4(), 50, 'Mike', 'Brown'),
(uuid_generate_v4(), 45, 'Emily', 'Jones'),
(uuid_generate_v4(), 33, 'Daniel', 'Kim'),
(uuid_generate_v4(), 27, 'Amanda', 'Rodriguez'),
(uuid_generate_v4(), 48, 'Mark', 'Taylor'),
(uuid_generate_v4(), 36, 'Laura', 'Nguyen');

INSERT INTO subject (id, name, lecturer_id)
VALUES
(uuid_generate_v4(), 'Introduction to Computer Science', (SELECT id FROM lecturer WHERE first_name = 'John' AND last_name = 'Doe')),
(uuid_generate_v4(), 'Calculus I', (SELECT id FROM lecturer WHERE first_name = 'Jane' AND last_name = 'Doe')),
(uuid_generate_v4(), 'Organic Chemistry', (SELECT id FROM lecturer WHERE first_name = 'Bob' AND last_name = 'Smith')),
(uuid_generate_v4(), 'American History', (SELECT id FROM lecturer WHERE first_name = 'Sarah' AND last_name = 'Lee')),
(uuid_generate_v4(), 'Artificial Intelligence', (SELECT id FROM lecturer WHERE first_name = 'Mike' AND last_name = 'Brown')),
(uuid_generate_v4(), 'Microeconomics', (SELECT id FROM lecturer WHERE first_name = 'Emily' AND last_name = 'Jones')),
(uuid_generate_v4(), 'World Literature', (SELECT id FROM lecturer WHERE first_name = 'Daniel' AND last_name = 'Kim')),
(uuid_generate_v4(), 'Environmental Science', (SELECT id FROM lecturer WHERE first_name = 'Amanda' AND last_name = 'Rodriguez')),
(uuid_generate_v4(), 'Digital Marketing', (SELECT id FROM lecturer WHERE first_name = 'Mark' AND last_name = 'Taylor')),
(uuid_generate_v4(), 'Public Speaking', (SELECT id FROM lecturer WHERE first_name = 'Laura' AND last_name = 'Nguyen'));

INSERT INTO student_group (id, name) VALUES
(uuid_generate_v4(), 'HT-32'),
(uuid_generate_v4(), 'MX-13'),
(uuid_generate_v4(), 'MIT-23'),
(uuid_generate_v4(), 'RANDOM');

INSERT INTO student (id, age, entry_date, first_name, last_name, group_id)
VALUES
(uuid_generate_v4(), 18, '2022-09-01', 'Alice', 'Johnson', (SELECT id FROM student_group WHERE name = 'HT-32')),
(uuid_generate_v4(), 19, '2022-09-01', 'Bob', 'Williams', (SELECT id FROM student_group WHERE name = 'HT-32')),
(uuid_generate_v4(), 20, '2022-09-01', 'Charlie', 'Brown', (SELECT id FROM student_group WHERE name = 'HT-32')),
(uuid_generate_v4(), 18, '2022-09-01', 'David', 'Lee', (SELECT id FROM student_group WHERE name = 'HT-32')),
(uuid_generate_v4(), 19, '2022-09-01', 'Emma', 'Garcia', (SELECT id FROM student_group WHERE name = 'HT-32')),
(uuid_generate_v4(), 20, '2022-09-01', 'Frank', 'Martin', (SELECT id FROM student_group WHERE name = 'MX-13')),
(uuid_generate_v4(), 18, '2022-09-01', 'Grace', 'Rodriguez', (SELECT id FROM student_group WHERE name = 'MX-13')),
(uuid_generate_v4(), 19, '2022-09-01', 'Hannah', 'Davis', (SELECT id FROM student_group WHERE name = 'MX-13')),
(uuid_generate_v4(), 20, '2022-09-01', 'Isaac', 'Campbell', (SELECT id FROM student_group WHERE name = 'MX-13')),
(uuid_generate_v4(), 18, '2022-09-01', 'Julia', 'Moore', (SELECT id FROM student_group WHERE name = 'MX-13')),
(uuid_generate_v4(), 19, '2022-09-01', 'Karen', 'Taylor', (SELECT id FROM student_group WHERE name = 'MIT-23')),
(uuid_generate_v4(), 20, '2022-09-01', 'Liam', 'Anderson', (SELECT id FROM student_group WHERE name = 'MIT-23')),
(uuid_generate_v4(), 18, '2022-09-01', 'Megan', 'Green', (SELECT id FROM student_group WHERE name = 'MIT-23')),
(uuid_generate_v4(), 19, '2022-09-01', 'Nathan', 'Thomas', (SELECT id FROM student_group WHERE name = 'MIT-23')),
(uuid_generate_v4(), 20, '2022-09-01', 'Olivia', 'Parker', (SELECT id FROM student_group WHERE name = 'MIT-23'));

INSERT INTO student_grades (student_id, grade, subject_id)
VALUES
((SELECT id FROM student WHERE first_name = 'Alice' AND last_name = 'Johnson'), 80, (SELECT id FROM subject WHERE name = 'Introduction to Computer Science')),
((SELECT id FROM student WHERE first_name = 'Alice' AND last_name = 'Johnson'), 95, (SELECT id FROM subject WHERE name = 'Calculus I')),
((SELECT id FROM student WHERE first_name = 'Alice' AND last_name = 'Johnson'), 75, (SELECT id FROM subject WHERE name = 'Environmental Science')),
((SELECT id FROM student WHERE first_name = 'Bob' AND last_name = 'Williams'), 90, (SELECT id FROM subject WHERE name = 'Organic Chemistry')),
((SELECT id FROM student WHERE first_name = 'Bob' AND last_name = 'Williams'), 85, (SELECT id FROM subject WHERE name = 'Microeconomics')),
((SELECT id FROM student WHERE first_name = 'Bob' AND last_name = 'Williams'), 60, (SELECT id FROM subject WHERE name = 'Artificial Intelligence')),
((SELECT id FROM student WHERE first_name = 'Charlie' AND last_name = 'Brown'), 75, (SELECT id FROM subject WHERE name = 'World Literature')),
((SELECT id FROM student WHERE first_name = 'Charlie' AND last_name = 'Brown'), 80, (SELECT id FROM subject WHERE name = 'Digital Marketing')),
((SELECT id FROM student WHERE first_name = 'Charlie' AND last_name = 'Brown'), 70, (SELECT id FROM subject WHERE name = 'American History')),
((SELECT id FROM student WHERE first_name = 'David' AND last_name = 'Lee'), 65, (SELECT id FROM subject WHERE name = 'Microeconomics')),
((SELECT id FROM student WHERE first_name = 'David' AND last_name = 'Lee'), 75, (SELECT id FROM subject WHERE name = 'World Literature')),
((SELECT id FROM student WHERE first_name = 'David' AND last_name = 'Lee'), 85, (SELECT id FROM subject WHERE name = 'Introduction to Computer Science')),
((SELECT id FROM student WHERE first_name = 'Emma' AND last_name = 'Garcia'), 80, (SELECT id FROM subject WHERE name = 'Calculus I')),
((SELECT id FROM student WHERE first_name = 'Emma' AND last_name = 'Garcia'), 70, (SELECT id FROM subject WHERE name = 'Digital Marketing')),
((SELECT id FROM student WHERE first_name = 'Emma' AND last_name = 'Garcia'), 90, (SELECT id FROM subject WHERE name = 'Environmental Science')),
((SELECT id FROM student WHERE first_name = 'Frank' AND last_name = 'Martin'), 65, (SELECT id FROM subject WHERE name = 'American History')),
((SELECT id FROM student WHERE first_name = 'Frank' AND last_name = 'Martin'), 80, (SELECT id FROM subject WHERE name = 'Microeconomics')),
((SELECT id FROM student WHERE first_name = 'Frank' AND last_name = 'Martin'), 95, (SELECT id FROM subject WHERE name = 'Introduction to Computer Science')),
((SELECT id FROM student WHERE first_name = 'Hannah' AND last_name = 'Davis'), 90, (SELECT id FROM subject WHERE name = 'Introduction to Computer Science')),
((SELECT id FROM student WHERE first_name = 'Hannah' AND last_name = 'Davis'), 75, (SELECT id FROM subject WHERE name = 'Organic Chemistry')),
((SELECT id FROM student WHERE first_name = 'Hannah' AND last_name = 'Davis'), 70, (SELECT id FROM subject WHERE name = 'World Literature')),
((SELECT id FROM student WHERE first_name = 'Grace' AND last_name = 'Rodriguez'), 85, (SELECT id FROM subject WHERE name = 'Calculus I')),
((SELECT id FROM student WHERE first_name = 'Grace' AND last_name = 'Rodriguez'), 80, (SELECT id FROM subject WHERE name = 'Environmental Science')),
((SELECT id FROM student WHERE first_name = 'Grace' AND last_name = 'Rodriguez'), 70, (SELECT id FROM subject WHERE name = 'Microeconomics')),
((SELECT id FROM student WHERE first_name = 'Karen' AND last_name = 'Taylor'), 75, (SELECT id FROM subject WHERE name = 'World Literature')),
((SELECT id FROM student WHERE first_name = 'Karen' AND last_name = 'Taylor'), 80, (SELECT id FROM subject WHERE name = 'Digital Marketing')),
((SELECT id FROM student WHERE first_name = 'Karen' AND last_name = 'Taylor'), 90, (SELECT id FROM subject WHERE name = 'Introduction to Computer Science')),
((SELECT id FROM student WHERE first_name = 'Liam' AND last_name = 'Anderson'), 80, (SELECT id FROM subject WHERE name = 'Microeconomics')),
((SELECT id FROM student WHERE first_name = 'Liam' AND last_name = 'Anderson'), 90, (SELECT id FROM subject WHERE name = 'Calculus I')),
((SELECT id FROM student WHERE first_name = 'Liam' AND last_name = 'Anderson'), 75, (SELECT id FROM subject WHERE name = 'Environmental Science')),
((SELECT id FROM student WHERE first_name = 'Isaac' AND last_name = 'Campbell'), 87, (SELECT id FROM subject WHERE name = 'Introduction to Computer Science')),
((SELECT id FROM student WHERE first_name = 'Isaac' AND last_name = 'Campbell'), 92, (SELECT id FROM subject WHERE name = 'Calculus I')),
((SELECT id FROM student WHERE first_name = 'Isaac' AND last_name = 'Campbell'), 81, (SELECT id FROM subject WHERE name = 'Organic Chemistry')),
((SELECT id FROM student WHERE first_name = 'Julia' AND last_name = 'Moore'), 78, (SELECT id FROM subject WHERE name = 'American History')),
((SELECT id FROM student WHERE first_name = 'Julia' AND last_name = 'Moore'), 85, (SELECT id FROM subject WHERE name = 'Artificial Intelligence')),
((SELECT id FROM student WHERE first_name = 'Julia' AND last_name = 'Moore'), 90, (SELECT id FROM subject WHERE name = 'Microeconomics')),
((SELECT id FROM student WHERE first_name = 'Megan' AND last_name = 'Green'), 93, (SELECT id FROM subject WHERE name = 'World Literature')),
((SELECT id FROM student WHERE first_name = 'Megan' AND last_name = 'Green'), 80, (SELECT id FROM subject WHERE name = 'Environmental Science')),
((SELECT id FROM student WHERE first_name = 'Megan' AND last_name = 'Green'), 88, (SELECT id FROM subject WHERE name = 'Digital Marketing')),
((SELECT id FROM student WHERE first_name = 'Nathan' AND last_name = 'Thomas'), 76, (SELECT id FROM subject WHERE name = 'Public Speaking')),
((SELECT id FROM student WHERE first_name = 'Nathan' AND last_name = 'Thomas'), 90, (SELECT id FROM subject WHERE name = 'Organic Chemistry')),
((SELECT id FROM student WHERE first_name = 'Nathan' AND last_name = 'Thomas'), 85, (SELECT id FROM subject WHERE name = 'World Literature')),
((SELECT id FROM student WHERE first_name = 'Olivia' AND last_name = 'Parker'), 91, (SELECT id FROM subject WHERE name = 'Artificial Intelligence')),
((SELECT id FROM student WHERE first_name = 'Olivia' AND last_name = 'Parker'), 82, (SELECT id FROM subject WHERE name = 'Introduction to Computer Science')),
((SELECT id FROM student WHERE first_name = 'Olivia' AND last_name = 'Parker'), 88, (SELECT id FROM subject WHERE name = 'Microeconomics'));