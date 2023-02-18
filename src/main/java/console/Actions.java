package console;

import lombok.extern.slf4j.Slf4j;
import util.UserInput;

@Slf4j
public enum Actions implements Action {

    QUIT("Quit") {
        @Override
        public void execute() {
            log.info("Exit program");
            System.exit(0);
        }
    },

    GROUPS_BY_NAME("Search for groups by name (not an exact match)") {
        @Override
        public void execute() {
            System.out.print("Write name for search: ");
            String name = UserInput.getString();
            System.out.println(PERFORMING);
            SERVICE.printGroupsByName(name);
            log.info("Printed groups by name: {}", name);
        }
    },

    EACH_GROUP_COUNT_OF_STUDENTS("Count of students in each group") {
        @Override
        public void execute() {
            System.out.println(PERFORMING);
            SERVICE.printEachGroupCountOfStudents();
            log.info("Printed {}", this.getMessage().toLowerCase());
        }
    },

    EACH_GROUP_AVERAGE_GRADE("Average grade of each group") {
        @Override
        public void execute() {
            System.out.println(PERFORMING);
            SERVICE.printEachGroupAverageGrade();
            log.info("Printed {}", this.getMessage().toLowerCase());
        }
    },

    LECTURERS_BY_NAME("Find a lecturers by first name or last name") {
        @Override
        public void execute() {
            System.out.print("Write name for search: ");
            String name = UserInput.getString();
            System.out.println(PERFORMING);
            SERVICE.printLecturersByFirstOrLastName(name);
            log.info("Printed lecturers by first name or last name: {}", name);
        }
    },

    TOP_BOTTOM_SUBJECTS("Subjects with the best and the worst academic performance") {
        @Override
        public void execute() {
            System.out.println(PERFORMING);
            SERVICE.printTopAndBottomPerformingSubjects();
            log.info("Printed {}", this.getMessage().toLowerCase());
        }
    },

    GRADE_GRATER_THAN_STUDENTS("Students whose average grade is higher than a input value") {
        @Override
        public void execute() {
            System.out.print("Write grade for search students whose average grade is higher than it: ");
            double grade = UserInput.getDouble();
            System.out.println(PERFORMING);
            SERVICE.printStudentsWithAverageGradeUpperThan(grade);
            log.info("Printed {}: {}", this.getMessage().toLowerCase(), grade);
        }
    };

    private static final String PERFORMING = "Performing action...\n";
    private final String message;

    Actions(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }

}
