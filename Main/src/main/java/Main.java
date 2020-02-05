import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

//TODO do you really need to pass in the three char arrays for every call to drawMenu?

//TODO add options for yogurt, sour cream, cream cheese for enriched doughs


public class Main {
    private static Scanner reader = new Scanner(System.in);
    private static Menu main = new Menu();

    public static void main(String[] args) throws IOException {
        goToMainMenu();
    }

    public static void goToMainMenu() throws IOException {
        /*
            When calling drawMenu, use Menu.java to change some parameters, and pass in custom parameters when calling
            setOptionNames(<custom params here>) and setOptionNumbers(<custom params here>).
         */

        Menu.drawMenu(main.charsTitle, main.charsBanner, main.charsRow, Menu.TITLE, "main menu",
                Menu.setOptionNames("grams", "ounces", "volume", "exit"), Menu.setOptionNumbers('1', '2', '3', '0'),
                Menu.width);

        boolean correctInput = false;
        do {
            try {
                System.out.print("Enter your choice here: ");
                int userMainChoice = Integer.parseInt(reader.nextLine());
                System.out.println();
                while (userMainChoice < 0 || userMainChoice > 3) {
                    System.out.print("You must enter a valid option, try again: ");
                    userMainChoice = Integer.parseInt(reader.nextLine());
                    System.out.println();
                }
                if (userMainChoice == 0) {
                    System.out.println("Goodbye!");
                }
                if (userMainChoice == 1) {
                    correctInput = true;
                    Grams.gotoGramsMenu();
                } else if (userMainChoice == 2) {
                    correctInput = true;
                    Ounces.gotoOuncesMenu();
                } else if (userMainChoice == 3) {
                    correctInput = true;
                    Menu.drawMenu(main.charsTitle, main.charsBanner, main.charsRow, Menu.TITLE, "Proceed?", Menu.setOptionNames("proceed", "go back"),
                            Menu.setOptionNumbers('1', '0'), Menu.width);
                    System.out.println("Using volume measurements is not recommended, you will experience \ninherent rounding errors.");
                    System.out.println("Are you sure you wish to proceed?");
                    System.out.println();
                    System.out.print("Enter your choice here: ");
                    int proceed = reader.nextInt();
                    if (proceed == 1) {
                        Volume.gotoVolumeMenu();
                    } else {
                        goToMainMenu();
                    }
                    correctInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("You must enter a valid number!");
                System.out.println();
            }
        }
        while (!correctInput);
    }
}

