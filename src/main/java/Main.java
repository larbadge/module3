import service.Service;

public class Main {

    public static void main(String[] args) {

        // TODO set up migrations, create tables, add started data 5-10 entities for each
        // TODO create console menu for this methods
        // TODO set up logging by task


        Service s = Service.getInstance();
        s.printSubjectsByGradeThresholds();


    }
}
