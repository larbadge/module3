package repository;

public class RepositoryFactory {


    private static final GroupRepository GROUP_REPOSITORY = new GroupRepositoryImpl();
    private static final LecturerRepository LECTURER_REPOSITORY = new LecturerRepositoryImpl();
    private static final StudentRepository STUDENT_REPOSITORY = new StudentRepositoryImpl();
    private static final SubjectRepository SUBJECT_REPOSITORY = new SubjectRepositoryImpl();

    private RepositoryFactory() {
    }

    public static SubjectRepository getSubjectRepositoryInstance() {
        return SUBJECT_REPOSITORY;
    }

    public static StudentRepository getStudentRepositoryInstance() {
        return STUDENT_REPOSITORY;
    }

    public static LecturerRepository getLecturerRepositoryInstance() {
        return LECTURER_REPOSITORY;
    }


    public static GroupRepository getGroupRepositoryInstance() {
        return GROUP_REPOSITORY;
    }

}
