import jpa.JpaUtil;
import model.Group;
import model.Lecturer;
import model.Student;
import model.Subject;

public class Main {

    public static void main(String[] args) {

        // TODO set up migrations, create tables, add started data
        // TODO create Service interface for CRUD operations
        // TODO realise Services for each entity
        // TODO realise methods from task
        // TODO create console menu for this methods
        // TODO set up logging by task


        Subject subject = new Subject();
        subject.setName("Math");
        Lecturer lecturer = new Lecturer();

        lecturer.setAge(40);
        lecturer.setFirstName("S");
        lecturer.setLastName("W");

        Student student = new Student();
        Group group = new Group();
        group.setName("GG3");


        student.setAge(20);
        student.setFirstName("V");
        student.setLastName("Q");
        student.getGrades().put(subject, 4.0);


        JpaUtil.doWithinTransaction(em -> em.persist(subject));
        JpaUtil.doWithinTransaction(em -> em.persist(lecturer));
        JpaUtil.doWithinTransaction(em -> em.persist(group));
        JpaUtil.doWithinTransaction(em -> {
            student.setGroup(group);
            group.getStudents().add(student);
            em.persist(student);
        });
    }
}
