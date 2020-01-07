
public class Menu {

    // Variables for drawRowWithOption
    private static char charLeft = ' ';
    private static char charRight = ' ';
    private static String optionName0 = "exit";
    private static String optionName1 = "use metric";
    private static String optionName2 = "use imperial";
    private static String optionName3 = "use volume (cups)";
    //private static String optionName4 = "include only primary liquid";
    //private static String optionName5 = "include all liquid ingredients";
    private static String separator = ":  ";
    private static int optionNum0 = 0;
    private static int optionNum1 = 1;
    private static int optionNum2 = 2;
    private static int optionNum3 = 3;
    private static int optionNum4 = 4;
    private static int optionNum5 = 5;
    private static int option0Length = optionName0.length() + separator.length() + Integer.toString(optionNum0).length();
    private static int option1Length = optionName1.length() + separator.length() + Integer.toString(optionNum1).length();
    private static int option2Length = optionName2.length() + separator.length() + Integer.toString(optionNum2).length();
    private static int option3Length = optionName3.length() + separator.length() + Integer.toString(optionNum3).length();
    //private static int option4Length = optionName4.length() + separator.length() + Integer.toString(optionNum4).length();
    //private static int option5Length = optionName5.length() + separator.length() + Integer.toString(optionNum5).length();

    public static void mainMenu(char cornerChar, char outsideChar, String title, String banner, int width) {
        drawTopMenuBar(cornerChar, '=', '=', title, width);
        drawBanner(outsideChar, '>', '<', banner, width);
        drawRow(outsideChar, ' ', width);
        drawRowWithOption(outsideChar, charLeft, charRight, optionName1, optionNum1, width);
        drawRowWithOption(outsideChar, charLeft, charRight, optionName2, optionNum2, width);
        drawRowWithOption(outsideChar, charLeft, charRight, optionName3, optionNum3, width);
        //drawRowWithOption(outsideChar, charLeft, charRight, optionName4, optionNum4, width);
        // drawRowWithOption(outsideChar, charLeft, charRight, optionName4, optionNum5, width);
        drawRowWithOption(outsideChar, charLeft, charRight, optionName0, optionNum0, width);
        drawRow(outsideChar, ' ', width);
        drawRow(cornerChar, '-', width);
    }

    public static void drawTopMenuBar(char cornerChar, char inCharLeft, char inCharRight, String title, int width) {

        if (title.length() % 2 == 0 && width % 2 == 0) {
            System.out.print(cornerChar);
            for (int i = 1; i < (width - title.length()) / 2; i++) {
                System.out.print(inCharLeft);
            }
            System.out.print(" ");
            System.out.print(title.toUpperCase());
            System.out.print(" ");
            for (int i = 1; i < (width - title.length()) / 2; i++) {
                System.out.print(inCharRight);
            }
            System.out.println(cornerChar);
        } else if (title.length() % 2 != 0 && width % 2 == 0) {
            System.out.print(cornerChar);
            for (int i = 1; i <= (width - title.length()) / 2; i++) {
                System.out.print(inCharLeft);
            }
            System.out.print(" ");
            System.out.print(title.toUpperCase());
            System.out.print(" ");
            for (int i = 1; i < (width - title.length()) / 2; i++) {
                System.out.print(inCharRight);
            }
            System.out.println(cornerChar);
        } else if (title.length() % 2 == 0 && width % 2 != 0) {
            System.out.print(cornerChar);
            for (int i = 1; i < (width - title.length()) / 2; i++) {
                System.out.print(inCharLeft);
            }
            System.out.print(" ");
            System.out.print(title.toUpperCase());
            System.out.print(" ");
            for (int i = 0; i < (width - title.length()) / 2; i++) {
                System.out.print(inCharRight);
            }
            System.out.println(cornerChar);
        } else {
            System.out.print(cornerChar);
            for (int i = 1; i < (width - title.length()) / 2; i++) {
                System.out.print(inCharLeft);
            }
            System.out.print(" ");
            System.out.print(title.toUpperCase());
            System.out.print(" ");
            for (int i = 1; i < (width - title.length()) / 2; i++) {
                System.out.print(inCharRight);
            }
            System.out.println(cornerChar);
        }
    }

    public static void drawBanner(char outsideChar, char inCharLeft, char inCharRight, String banner, int width) {
        if (banner.length() % 2 == 0 && width % 2 == 0) {
            System.out.print(outsideChar);
            for (int i = 2; i < (width - banner.length()) / 2; i++) {
                System.out.print(inCharLeft);
            }
            System.out.print("  ");
            System.out.print(banner.toUpperCase());
            System.out.print("  ");
            for (int i = 2; i < (width - banner.length()) / 2; i++) {
                System.out.print(inCharRight);
            }
            System.out.println(outsideChar);
        } else if (banner.length() % 2 != 0 && width % 2 == 0) {
            System.out.print(outsideChar);
            for (int i = 2; i <= (width - banner.length()) / 2; i++) {
                System.out.print(inCharLeft);
            }
            System.out.print("  ");
            System.out.print(banner.toUpperCase());
            System.out.print("  ");
            for (int i = 2; i < (width - banner.length()) / 2; i++) {
                System.out.print(inCharRight);
            }
            System.out.println(outsideChar);
        } else if (banner.length() % 2 == 0 && width % 2 != 0) {
            System.out.print(outsideChar);
            for (int i = 2; i < (width - banner.length()) / 2; i++) {
                System.out.print(inCharLeft);
            }
            System.out.print("  ");
            System.out.print(banner.toUpperCase());
            System.out.print("  ");
            for (int i = 1; i < (width - banner.length()) / 2; i++) {
                System.out.print(inCharRight);
            }
            System.out.println(outsideChar);
        } else {
            System.out.print(outsideChar);
            for (int i = 2; i < (width - banner.length()) / 2; i++) {
                System.out.print(inCharLeft);
            }
            System.out.print("  ");
            System.out.print(banner.toUpperCase());
            System.out.print("  ");
            for (int i = 2; i < (width - banner.length()) / 2; i++) {
                System.out.print(inCharRight);
            }
            System.out.println(outsideChar);
        }
    }

    public static void drawRow(char outsideChar, char insideChar, int width) {
        System.out.print(outsideChar);
        repeat(insideChar, width);
        System.out.print(outsideChar);
        System.out.println();
    }

    /**
     * NOTE: For now, you must manually change the getMaxLength parameters as needed. getMaxLength is a varargs method
     * and can accept any number of int parameters.
     * ---
     * This method does the following:
     * (1) Gets the maximum length of all optionNames that are passed into the getMaxLength (varargs) method
     * (2) Calculates the difference of that number and each individual optionName as it is called
     * (3) Creates a String space that is space.length() == difference
     * (4) Calculates the total length of the option name, including leading spaces, separator, and option number
     * (5) Prints the outside character
     * (6) Prints all characters to the left of the option name
     * (7) Prints the option name starting with leading spaces, then option name, separator, and option number
     * (8) Checks if width is even or not and prints the appropriate number of characters to the right of option name
     * (9) Prints the outside character
     *
     * @param outsideChar printed on the left and right boundary of the row
     * @param inCharLeft  printed on the left of the optionName
     * @param inCharRight printed on the right of the optionName
     * @param optionName  name of the option
     * @param optionNum   number that will correspond with the option name
     * @param width       width of the row, and should be provided in the main method call
     */
    public static void drawRowWithOption(char outsideChar, char inCharLeft, char inCharRight, String optionName, int optionNum, int width) {
        int longest = getMaxLength(option0Length, option1Length, option2Length, option3Length);
        int difference = longest - optionName.length();
        String space = "";
        for (int i = 0; i < difference; i++) {
            space += " ";
        }
        int lengthOfOption = (space.length() + optionName.length() + separator.length() + Integer.toString(optionNum).length());
        System.out.print(outsideChar);
        for (int i = 1; i < (width - lengthOfOption) / 2; i++) {
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

    public static void repeat(char c, int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(c);
        }
    }

    private static int maxLength = 0;

    public static int getMaxLength(int... optionLength) {
        for (int i : optionLength) {
            if (i > maxLength) {
                maxLength = i;
            }
        }
        return maxLength;
    }


}
