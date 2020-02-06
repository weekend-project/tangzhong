import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private static Scanner reader = new Scanner(System.in);
    public static final String TITLE = "tangzhong recipe builder";
    public static String separator = ":  ";
    public static int width = 60;
    public static char[] charsTitle = {'+', '=', '='};
    public static char[] charsBanner = {'|', '>', '<'};
    public static char[] charsRow = {'|', ' ', '-'};

    /**
     * When calling drawMenu, change some parameters using the arrays created at the top of this class, and pass in
     * custom parameters when calling setOptionNames() and setOptionNumbers()
     *
     * @throws IOException
     */
    public static void gotoMainMenu() throws IOException {
        drawMenu(charsTitle, charsBanner, charsRow, TITLE, "main menu",
                setOptionNames("grams", "ounces", "volume", "exit"), setOptionNumbers('1', '2', '3', '0'),
                width);

        System.out.print("Enter your choice here: ");
        int userMainChoice = reader.nextInt();
        System.out.println();
        while (userMainChoice < 0 || userMainChoice > 3) {
            System.out.println();
            System.out.print("You must enter a valid option! ");
            userMainChoice = reader.nextInt();
            System.out.println();
        }
        if (userMainChoice == 0) {
            System.out.println("Goodbye!");

        }
        if (userMainChoice == 1) {
            Grams.gotoGramsMenu();
        } else if (userMainChoice == 2) {
            Ounces.gotoOuncesMenu();
        } else { // userMainChoice == 3
            drawMenu(charsTitle, charsBanner, charsRow, TITLE, "! attention !",
                    setOptionNames("i understand", "go back"), setOptionNumbers('1', '0'), width);
            System.out.println("Using volume measurements is not recommended, you will experience \nsome " +
                    "inherent rounding errors.");
            System.out.println();
            System.out.println("Proceed?");
            System.out.println();
            System.out.print("Enter your choice here: ");
            int proceed = reader.nextInt();
            while (proceed < 0 || proceed > 1) {
                System.out.println();
                System.out.println("You must enter a valid number!");
                System.out.println();
                System.out.print("Enter your choice here: ");
                proceed = reader.nextInt();
            }
            if (proceed == 1) {
                Volume.gotoVolumeMenu();
            } else { // proceed == 0
                gotoMainMenu();
            }
        }
    }

    /**
     * --- drawMenu method ---
     * (1) calls drawTitle, which passes charsTitle array, title string, and width int. This draws the top-most row
     * (2) calls drawBanner, which passes charsBanner array, banner string, and width int. Draws the banner row
     * (3) calls drawRow, which passes the first and second characters in array charsRow, and draws a generic row
     * (4) determines the max length of each option name + the separator length + option number so that things are
     * centered and right-aligned
     * (5) calls drawRowWithOption as many times as there are strings in the optionNames ArrayList, which is populated
     * from the call setOptionNames(<custom strings here>)
     * (6) draws one generic row for aesthetics only
     * (7) draw the bottom-most row with a different char to close the box
     * --------------------------------------------------------------------
     *
     * @param charsTitle  array that holds all characters in the title bar
     * @param charsBanner array that holds all characters in the banner bar
     * @param charsRow    array that holds all characters in each row
     * @param title       text to be displayed at the very top
     * @param banner      text to be displayed in the sub-menu
     * @param optionNames ArrayList to hold the variable amount of title names
     * @param optionNums  ArrayList to hold the numbers for each optionName
     * @param width       how wide the menu box will be (number of characters wide)
     */
    public static void drawMenu(char[] charsTitle, char[] charsBanner, char[] charsRow, String title, String banner,
                                ArrayList<String> optionNames, ArrayList<Character> optionNums, int width) {
        drawTitle(charsTitle, title, width); // draws the title bar
        drawBanner(charsBanner, banner, width); // draws the banner bar
        drawRow(charsRow[0], charsRow[1], width); // draws a generic row
        for (int i = 0; i < optionNames.size(); i++) { // this repeatedly calls the below method for each optionName
            drawRowWithOption(charsRow[0], charsRow[1], charsRow[1], optionNames.get(i), optionNums.get(i), width,
                    getMaxLength(optionNames));
        }
        drawRow(charsRow[0], charsRow[1], width); // draws generic row
        drawRow(charsRow[0], charsRow[2], width); // draws generic row with different char so it closes the box
    }

    public static int getMaxLength(ArrayList<String> optionNames) {
        int maxLength = 0; // this will be updated next
        for (String optionName : optionNames) { // iterates for the same amount of optionNames
            if (maxLength < getOptionLength(optionName)) {
                // changes maxLength to the longest option name + separator + optionNum
                maxLength = getOptionLength(optionName);
            }
        }
        return maxLength;
    }

    /**
     * --- drawTitle method ---
     * (1) control flow determines if the length of the title string is even or odd and if the int width is even or odd
     * (2) prints the outside char one time
     * (3) prints the left char as many times as (width - title.length()) / 2
     * (4) prints the title in upper case with spaces around it
     * (5) prints the right char as many times as (width - title.length()) / 2
     * (6) prints the outside char one time
     * ---------------------------------------------------------------
     *
     * @param charsTitle array that holds all chars for the title row
     * @param title      The primary title string
     * @param width      The width of the whole box, not counting the outside chars
     */
    public static void drawTitle(char[] charsTitle, String title, int width) {

        // if the length of the title is even and the int width is even
        if (title.length() % 2 == 0 && width % 2 == 0) {
            System.out.print(charsTitle[0]);
            for (int i = 1; i < (width - title.length()) / 2; i++) {
                System.out.print(charsTitle[1]);
            }
            System.out.print(" ");
            System.out.print(title.toUpperCase());
            System.out.print(" ");
            for (int i = 1; i < (width - title.length()) / 2; i++) {
                System.out.print(charsTitle[2]);
            }
            System.out.println(charsTitle[0]);

            // if the length of the title is odd and the int width is even
        } else if (title.length() % 2 != 0 && width % 2 == 0) {
            System.out.print(charsTitle[0]);
            for (int i = 1; i <= (width - title.length()) / 2; i++) {
                System.out.print(charsTitle[1]);
            }
            System.out.print(" ");
            System.out.print(title.toUpperCase());
            System.out.print(" ");
            for (int i = 1; i < (width - title.length()) / 2; i++) {
                System.out.print(charsTitle[2]);
            }
            System.out.println(charsTitle[0]);

            // if the length of the title is even and the int width is odd
        } else if (title.length() % 2 == 0) {
            System.out.print(charsTitle[0]);
            for (int i = 1; i < (width - title.length()) / 2; i++) {
                System.out.print(charsTitle[1]);
            }
            System.out.print(" ");
            System.out.print(title.toUpperCase());
            System.out.print(" ");
            for (int i = 0; i < (width - title.length()) / 2; i++) {
                System.out.print(charsTitle[2]);
            }
            System.out.println(charsTitle[0]);

            // if the length of the title is odd and the int width is odd
        } else {
            System.out.print(charsTitle[0]);
            for (int i = 1; i < (width - title.length()) / 2; i++) {
                System.out.print(charsTitle[1]);
            }
            System.out.print(" ");
            System.out.print(title.toUpperCase());
            System.out.print(" ");
            for (int i = 1; i < (width - title.length()) / 2; i++) {
                System.out.print(charsTitle[2]);
            }
            System.out.println(charsTitle[0]);
        }
    }

    public static void drawBanner(char[] charsBanner, String banner, int width) {
        if (banner.length() % 2 == 0 && width % 2 == 0) {
            System.out.print(charsBanner[0]);
            for (int i = 2; i < (width - banner.length()) / 2; i++) {
                System.out.print(charsBanner[1]);
            }
            System.out.print("  ");
            System.out.print(banner.toUpperCase());
            System.out.print("  ");
            for (int i = 2; i < (width - banner.length()) / 2; i++) {
                System.out.print(charsBanner[2]);
            }
            System.out.println(charsBanner[0]);
        } else if (banner.length() % 2 != 0 && width % 2 == 0) {
            System.out.print(charsBanner[0]);
            for (int i = 2; i <= (width - banner.length()) / 2; i++) {
                System.out.print(charsBanner[1]);
            }
            System.out.print("  ");
            System.out.print(banner.toUpperCase());
            System.out.print("  ");
            for (int i = 2; i < (width - banner.length()) / 2; i++) {
                System.out.print(charsBanner[2]);
            }
            System.out.println(charsBanner[0]);
        } else if (banner.length() % 2 == 0) {
            System.out.print(charsBanner[0]);
            for (int i = 2; i < (width - banner.length()) / 2; i++) {
                System.out.print(charsBanner[1]);
            }
            System.out.print("  ");
            System.out.print(banner.toUpperCase());
            System.out.print("  ");
            for (int i = 1; i < (width - banner.length()) / 2; i++) {
                System.out.print(charsBanner[2]);
            }
            System.out.println(charsBanner[0]);
        } else {
            System.out.print(charsBanner[0]);
            for (int i = 2; i < (width - banner.length()) / 2; i++) {
                System.out.print(charsBanner[1]);
            }
            System.out.print("  ");
            System.out.print(banner.toUpperCase());
            System.out.print("  ");
            for (int i = 2; i < (width - banner.length()) / 2; i++) {
                System.out.print(charsBanner[2]);
            }
            System.out.println(charsBanner[0]);
        }
    }

    public static ArrayList<String> setOptionNames(String... optionName) {
        ArrayList<String> optionNames = new ArrayList<>(); // creating a new ArrayList to hold the variable amount of title names
        for (String option : optionName) { // iterates through each optionName arg that is passed in, and then adds that string to the ArrayList
            optionNames.add(option); //TODO not sure what Collection.addAll does exactly, leaving it this way for now
        }
        return optionNames;
    }

    public static ArrayList<Character> setOptionNumbers(char... optionNums) {
        ArrayList<Character> optionNumbers = new ArrayList<>(); // creating a new ArrayList to hold the variable amount of title names
        for (char num : optionNums) { // iterates through each optionName arg that is passed in, and then adds that string to the ArrayList
            optionNumbers.add(num); //TODO not sure what Collection.addAll does exactly, leaving it this way for now
        }
        return optionNumbers;
    }

    public static int getOptionLength(String optionName) {
        return optionName.length() + separator.length() + 1; // the + 1 is to account for the length of the char
    }

    public static void drawRowWithOption(char outsideChar, char inCharLeft, char inCharRight, String optionName,
                                         char optionNum, int width, int maxLength) {

        int optionLength = optionName.length() + separator.length() + 1; // + 1 is to account for the length of the char optionNum
        int difference = maxLength - optionLength;
        String space = "";
        for (int i = 0; i < difference; i++) {
            space += " ";
        }
        int lengthOfOption = (space.length() + optionName.length() + separator.length() + 1);
        System.out.print(outsideChar);
        for (int i = 0; i < (width - lengthOfOption) / 2; i++) {
            System.out.print(inCharLeft);
        }
        System.out.print(space + optionName.toUpperCase() + separator + optionNum);
        if (width % 2 == 0 && lengthOfOption % 2 == 0) {
            for (int i = 1; i <= ((width - lengthOfOption) / 2); i++) {
                System.out.print(inCharRight);
            }
        } else if (width % 2 != 0 && lengthOfOption % 2 == 0) {
            for (int i = 0; i <= ((width - lengthOfOption) / 2); i++) {
                System.out.print(inCharRight);
            }
        } else if (width % 2 == 0) {
            for (int i = 0; i <= ((width - lengthOfOption) / 2); i++) {
                System.out.print(inCharRight);
            }
        } else {
            for (int i = 1; i <= ((width - lengthOfOption) / 2); i++) {
                System.out.print(inCharRight);
            }
        }
        System.out.println(outsideChar);
    }

    public static void drawRow(char outsideChar, char insideChar, int width) {
        System.out.print(outsideChar);
        repeat(insideChar, width);
        System.out.print(outsideChar);
        System.out.println();
    }

    public static void repeat(char c, int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(c);
        }
    }
}
