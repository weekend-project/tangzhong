import java.io.IOException;
import java.util.Scanner;

//TODO do you really need to pass in the three char arrays for every call to drawMenu?

//TODO create a method that clears all variable values upon request

public class Main {
    private static Scanner reader = new Scanner(System.in);
    private static Menu main = new Menu();
    private static int userMainChoice;

    public static void main(String[] args) throws IOException {
        do {
            goToMainMenu();
        } while (userMainChoice != 0);
    }

    public static void goToMainMenu() throws IOException {
        /*
            When calling drawMenu, use Menu.java to change some parameters, and pass in custom parameters when calling
            setOptionNames(<custom params here>) and setOptionNumbers(<custom params here>).
         */
        Menu.drawMenu(main.charsTitle, main.charsBanner, main.charsRow, Menu.TITLE, "main menu",
                Menu.setOptionNames("grams", "ounces", "volume", "exit"), Menu.setOptionNumbers('1', '2', '3', '0'),
                Menu.width);

        System.out.print("Enter your choice here: ");
        userMainChoice = reader.nextInt();
        System.out.println();

        if (userMainChoice == 0)
            System.out.println("Goodbye!");

        while (userMainChoice < 0 || userMainChoice > 3) {
            Menu.drawMenu(main.charsTitle, main.charsBanner, main.charsRow, Menu.TITLE, "main menu",
                    Menu.setOptionNames("grams", "ounces", "volume", "exit"),
                    Menu.setOptionNumbers('1', '2', '3', '0'), 60);
            System.out.print("You must enter a valid option, try again: ");
            userMainChoice = reader.nextInt();
            System.out.println();
        }

        if (userMainChoice == 1) {
            Grams.gotoGramsMenu();
        } else if (userMainChoice == 2) {
            Ounces.gotoOuncesMenu();
        } else if (userMainChoice == 3) {
            Menu.drawMenu(main.charsTitle, main.charsBanner, main.charsRow, Menu.TITLE, "Proceed?", Menu.setOptionNames("proceed", "go back"),
                    Menu.setOptionNumbers('1', '0'), Menu.width);
            System.out.println("Using volume measurements is not recommended, you may experience \nrounding errors.");
            System.out.println("Are you sure you wish to proceed?");
            System.out.println();
            System.out.print("Enter your choice here: ");
            int proceed = reader.nextInt();
            if (proceed == 1) {
                Volume.gotoVolumeMenu();
            }
            goToMainMenu();
        }
    }
}

