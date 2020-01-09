import java.util.ArrayList;

public class Menu {
    public static String separator = ":  ";
    char[] charsTitle = {'+', '=', '=' }; // array that holds all characters in the title bar
    char[] charsBanner = {'|', '>', '<' }; // array that holds all characters in the banner bar
    char[] charsRow = {'|', ' ', '-' }; // array that holds all characters in each row
    String title = "tangzhong recipe builder"; // text to be displayed at the very top, ideally never changes
    int width = 60;

    /** --- drawMenu method ---
     * (1) calls drawTitle, which passes charsTitle array, title string, and width int. This draws the top-most row
     * (2) calls drawBanner, which passes charsBanner array, banner string, and width int. Draws the banner row
     * (3) calls drawRow, which passes the first and second characters in array charsRow, and draws a generic row
     * (4) determines the max length of each option name + the separator length + option number so that things are
     *     centered and right-aligned
     * (5) calls drawRowWithOption as many times as there are strings in the optionNames ArrayList, which is populated
     *     from the call setOptionNames(<custom strings here>)
     * (6) draws one generic row for aesthetics only
     * (7) draw the bottom-most row with a different char to close the box
     * --------------------------------------------------------------------
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
        int maxLength = 0; // this will be updated next
        for (String optionName : optionNames) { // iterates for the same amount of optionNames
            if (maxLength < getOptionLength(optionName)) {
                maxLength = getOptionLength(optionName); // changes maxLength to the longest option name + separator + optionNum
            }
        }
        for (int i = 0; i < optionNames.size(); i++) { // this repeatedly calls the below method for each optionName
            drawRowWithOption(charsRow[0], charsRow[1], charsRow[1], optionNames.get(i), optionNums.get(i), width,
                    maxLength);
        }
        drawRow(charsRow[0], charsRow[1], width); // draws generic row
        drawRow(charsRow[0], charsRow[2], width); // draws generic row with different char so it closes the box
    }

    /** --- drawTitle method ---
     * (1) control flow determines if the length of the title string is even or odd and if the int width is even or odd
     * (2) prints the outside char one time
     * (3) prints the left char as many times as (width - title.length()) / 2
     * (4) prints the title in upper case with spaces around it
     * (5) prints the right char as many times as (width - title.length()) / 2
     * (6) prints the outside char one time
     * ---------------------------------------------------------------
     * @param charsTitle array that holds all chars for the title row
     * @param title The primary title string
     * @param width The width of the whole box, not counting the outside chars
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

        // LAST LEFT OFF, trying to figure out how to get the max length when calling this method x times
        int optionLength = optionName.length() + separator.length() + 1; // the + 1 is to account for the length of the char
        int difference = maxLength - optionLength;
        String space = "";
        for (int i = 0; i < difference; i++) {
            space += " ";
        }
        int lengthOfOption = (space.length() + optionName.length() + separator.length() + Integer.toString(optionNum).length());
        System.out.print(outsideChar);
        for (int i = 0; i < (width - lengthOfOption) / 2; i++) {
            System.out.print(inCharLeft);
        }
        System.out.print(space + optionName.toUpperCase() + separator + optionNum);
        if (width % 2 == 0) {
            for (int i = 0; i <= ((width - lengthOfOption) / 2) + 1; i++) {
                System.out.print(inCharRight);
            }
        } else {
            for (int i = 0; i <= (width - lengthOfOption) / 2; i++) {
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
