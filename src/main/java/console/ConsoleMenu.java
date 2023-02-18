package console;

import util.UserInput;

import java.util.Arrays;

public class ConsoleMenu {

    @SuppressWarnings(value = "all")
    public static void run() {
        while (true) {
            System.out.println("Select an action:");
            Arrays.stream(Actions.values())
                    .skip(1)
                    .forEach(action -> System.out.printf("%d. %s%n", action.ordinal(), action.getMessage()));
            System.out.printf("%d. %s%n", Actions.QUIT.ordinal(), Actions.QUIT.getMessage());

            int choice = UserInput.getChoice();
            Action action = fromChoice(choice);
            action.execute();

            backToMain();
        }
    }

    private static void backToMain() {
        String goMain = "";
        while (!goMain.equals("y")) {
            System.out.print("If you want back to the main menu write \"y\": ");
            goMain = UserInput.getString();
            System.out.println();
        }
    }

    private static Action fromChoice(int choice) {
        return Arrays.stream(Actions.values())
                .filter(a -> a.ordinal() == choice)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Invalid choice: " + choice));
    }

}
