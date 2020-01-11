import java.io.IOException;
import java.util.Scanner;

//TODO change option numbers to letters that correspond with option names

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
                Menu.setOptionNames("metric", "imperial", "volume", "exit"), Menu.setOptionNumbers('1', '2', '3', '0'),
                Menu.width);

        System.out.print("Enter your choice here: ");
        userMainChoice = reader.nextInt();
        System.out.println();

        if (userMainChoice == 0)
            System.out.println("Goodbye!");

        while (userMainChoice < 0 || userMainChoice > 3) {
            Menu.drawMenu(main.charsTitle, main.charsBanner, main.charsRow, Menu.TITLE, "main menu",
                    Menu.setOptionNames("metric", "imperial", "volume", "exit"),
                    Menu.setOptionNumbers('1', '2', '3', '0'), 60);
            System.out.print("You must enter a valid option, try again: ");
            userMainChoice = reader.nextInt();
            System.out.println();
        }

        if (userMainChoice == 1) {
            Grams.goToGramsMenu();
        } else if (userMainChoice == 2) {
            Imperial.temp();
        } else if (userMainChoice == 3) {
            Volume.goToVolumeMenu();
        }
    }
}

