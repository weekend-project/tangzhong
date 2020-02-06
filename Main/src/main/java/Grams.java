import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Grams {
    private static int liquidWeight;
    private static int flourWeight;
    private static double initialHydration;
    private static double newLiquidWeight;
    private static Scanner reader = new Scanner(System.in);
    private static Menu grams = new Menu();
    private static String gramsBanner = "ingredient weights in grams";
    private static int timesChoseWater;
    private static int timesChoseMilk;
    private static int timesChoseEggs;
    private static int timesChoseButter;
    private static int timesChoseHoney;
    private static int timesChoseSyrup;
    private static int timesChoseMolasses;
    private static int timesChoseFlour;
    private static int justMilk;
    private static int justWater;

    public static void gotoGramsMenu() throws IOException {
        Menu.drawMenu(grams.charsTitle, grams.charsBanner, grams.charsRow, Menu.TITLE, gramsBanner,
                Menu.setOptionNames("water", "milk", "eggs", "butter", "honey", "syrup", "molasses", "flour",
                        "continue", "back"),
                Menu.setOptionNumbers('1', '2', '3', '4', '5', '6', '7', '8', '9', '0'), Menu.width);

        System.out.print("Enter your choice here: ");
        int userGramsChoice = reader.nextInt();
        while (userGramsChoice < 0 || userGramsChoice > 9) {
            System.out.println();
            System.out.print("You must enter a valid option! ");
            userGramsChoice = reader.nextInt();
            System.out.println();
        }
        if (userGramsChoice == 0) {
            Menu.gotoMainMenu();
        } else if (userGramsChoice == 1) {
            gotoWater();
        } else if (userGramsChoice == 2) {
            gotoMilk();
        } else if (userGramsChoice == 3) {
            gotoEggs();
        } else if (userGramsChoice == 4) {
            gotoButter();
        } else if (userGramsChoice == 5) {
            gotoHoney();
        } else if (userGramsChoice == 6) {
            gotoSyrup();
        } else if (userGramsChoice == 7) {
            gotoMolasses();
        } else if (userGramsChoice == 8) {
            gotoFlour();
        } else if (userGramsChoice == 9) {
            getRouxAmounts();
        } else {
            Menu.gotoMainMenu();
        }
    }

    public static void gotoFlour() throws IOException {
        if (timesChoseFlour > 0) {
            System.out.println("You already entered flour " + timesChoseFlour + " time(s), are you sure you " +
                    "want to enter more flour?");
            System.out.print("Type 1 for yes, or 0 for no: ");
            int moreFlour = reader.nextInt();
            while (moreFlour < 0 || moreFlour > 1) {
                System.out.print("You must enter either 1 for yes, or 0 for no: ");
                moreFlour = reader.nextInt();
            }
            if (moreFlour == 1) {
                System.out.print("Enter the amount of flour in grams: ");
                timesChoseFlour++;
                flourWeight += reader.nextInt();
            }
            gotoGramsMenu();
        }
        System.out.print("Enter the amount of all flour in grams: ");
        timesChoseFlour++;
        flourWeight = reader.nextInt();
        gotoGramsMenu();
    }

    public static void gotoWater() throws IOException {
        if (timesChoseWater > 0) {
            System.out.println("You already entered water " + timesChoseWater + " time(s), are you sure you " +
                    "want to enter more water?");
            System.out.print("Type 1 for yes, or 0 for no: ");
            int moreWater = reader.nextInt();

            // catches invalid input
            while (moreWater < 0 || moreWater > 1) {
                System.out.print("You must enter either 1 for yes, or 0 for no: ");
                moreWater = reader.nextInt();
            }
            if (moreWater == 1) {
                System.out.print("Enter the amount of water in grams: ");
                timesChoseWater++;
                justWater += reader.nextInt();
                liquidWeight += justWater;
            }
            gotoGramsMenu();
        }
        System.out.print("Enter the amount of water in grams: ");
        timesChoseWater++;
        justWater += reader.nextInt();
        liquidWeight += justWater;
        gotoGramsMenu();
    }

    public static void gotoMilk() throws IOException {
        if (timesChoseMilk > 0) {
            System.out.println("You already entered milk " + timesChoseMilk + " time(s), are you sure you " +
                    "want to enter more milk?");
            System.out.print("Type 1 for yes, or 0 for no: ");
            int moreMilk = reader.nextInt();

            while (moreMilk < 0 || moreMilk > 1) {
                System.out.print("You must enter either 1 for yes, or 0 for no: ");
                moreMilk = reader.nextInt();
            }
            if (moreMilk == 1) {
                System.out.print("Enter the amount of milk in grams: ");
                timesChoseMilk++;
                liquidWeight += (int) Math.round(reader.nextInt() * Conversions.MILK);
            }
            gotoGramsMenu();
        }
        System.out.print("Enter the amount of milk in grams: ");
        timesChoseMilk++;
        justMilk = reader.nextInt();
        liquidWeight += (int) Math.round(justMilk * Conversions.MILK);
        gotoGramsMenu();
    }

    public static void gotoEggs() throws IOException {
        if (timesChoseEggs > 0) {
            System.out.println("You already entered eggs " + timesChoseEggs + " time(s), are you sure you " +
                    "want to enter more eggs?");
            System.out.print("Type 1 for yes, or 0 for no: ");
            int moreEggs = reader.nextInt();

            while (moreEggs < 0 || moreEggs > 1) {
                System.out.print("You must enter either 1 for yes, or 0 for no: ");
                moreEggs = reader.nextInt();
            }
            if (moreEggs == 1) {
                System.out.print("Enter the number of whole eggs: ");
                timesChoseEggs++;

                /*
                    takes current liquidWeight + (whatever the user enters * 50) * 0.74, rounds and casts to an int
                    user input * 50 because one egg weighs about 50g
                 */
                liquidWeight += (int) Math.round((reader.nextInt() * 50) * Conversions.EGGS);
            }
            gotoGramsMenu();
        }
        System.out.print("Enter the number of whole eggs: ");
        timesChoseEggs++;

        /*
           takes current liquidWeight + (whatever the user enters * 50) * 0.74, rounds and casts to an int
           user input * 50 because one egg weighs about 50g
        */
        liquidWeight += (int) Math.round((reader.nextInt() * 50) * Conversions.EGGS);
        gotoGramsMenu();
    }

    public static void gotoButter() throws IOException {
        if (timesChoseButter > 0) {
            System.out.println("You already entered butter " + timesChoseButter + " time(s), are you sure you " +
                    "want to enter more butter?");
            System.out.print("Type 1 for yes, or 0 for no: ");
            int moreButter = reader.nextInt();

            while (moreButter < 0 || moreButter > 1) {
                System.out.print("You must enter either 1 for yes, or 0 for no: ");
                moreButter = reader.nextInt();
            }
            if (moreButter == 1) {
                System.out.print("Enter the amount of butter in grams: ");
                timesChoseButter++;
                liquidWeight += (int) Math.round(reader.nextInt() * Conversions.BUTTER);
            }
            gotoGramsMenu();
        }
        System.out.print("Enter the amount of butter in grams: ");
        timesChoseButter++;
        liquidWeight += (int) Math.round(reader.nextInt() * Conversions.BUTTER);
        gotoGramsMenu();
    }

    public static void gotoHoney() throws IOException {
        if (timesChoseHoney > 0) {
            System.out.println("You already entered honey " + timesChoseHoney + " time(s), are you sure you " +
                    "want to enter more honey?");
            System.out.print("Type 1 for yes, or 0 for no: ");
            int moreHoney = reader.nextInt();

            while (moreHoney < 0 || moreHoney > 1) {
                System.out.print("You must enter either 1 for yes, or 0 for no: ");
                moreHoney = reader.nextInt();
            }
            if (moreHoney == 1) {
                System.out.print("Enter the amount of honey in grams: ");
                timesChoseHoney++;
                liquidWeight += (int) Math.round(reader.nextInt() * Conversions.HONEY);
            }
            gotoGramsMenu();
        }
        System.out.print("Enter the amount of honey in grams: ");
        timesChoseHoney++;
        liquidWeight += (int) Math.round(reader.nextInt() * Conversions.HONEY);
        gotoGramsMenu();
    }

    public static void gotoSyrup() throws IOException {
        if (timesChoseSyrup > 0) {
            System.out.println("You already entered syrup " + timesChoseSyrup + " time(s), are you sure you " +
                    "want to enter more syrup?");
            System.out.print("Type 1 for yes, or 0 for no: ");
            int moreMilk = reader.nextInt();

            while (moreMilk < 0 || moreMilk > 1) {
                System.out.print("You must enter either 1 for yes, or 0 for no: ");
                moreMilk = reader.nextInt();
            }
            if (moreMilk == 1) {
                System.out.print("Enter the amount of syrup in grams: ");
                timesChoseSyrup++;
                liquidWeight += (int) Math.round(reader.nextInt() * Conversions.SYRUP);
            }
            gotoGramsMenu();
        }
        System.out.print("Enter the amount of syrup in grams: ");
        timesChoseSyrup++;
        liquidWeight += (int) Math.round(reader.nextInt() * Conversions.SYRUP);
        gotoGramsMenu();
    }

    public static void gotoMolasses() throws IOException {
        if (timesChoseMolasses > 0) {
            System.out.println("You already entered molasses " + timesChoseMolasses + " time(s), are you sure you " +
                    "want to enter more molasses?");
            System.out.print("Type 1 for yes, or 0 for no: ");
            int moreMilk = reader.nextInt();

            // catches invalid input
            while (moreMilk < 0 || moreMilk > 1) {
                System.out.print("You must enter either 1 for yes, or 0 for no: ");
                moreMilk = reader.nextInt();
            }
            if (moreMilk == 1) {
                System.out.print("Enter the amount of molasses in grams: ");
                timesChoseMolasses++;
                liquidWeight += (int) Math.round(reader.nextInt() * Conversions.MOLASSES);
            }
            gotoGramsMenu();
        }
        System.out.print("Enter the amount of molasses in grams: ");
        timesChoseMolasses++;
        liquidWeight += (int) Math.round(reader.nextInt() * Conversions.MOLASSES);
        gotoGramsMenu();
    }

    public static void gotoPrintMenu() throws IOException {
        Menu.drawMenu(grams.charsTitle, grams.charsBanner, grams.charsRow, Menu.TITLE, gramsBanner,
                Menu.setOptionNames("save to pdf", "main menu"), Menu.setOptionNumbers('1', '0'),
                Menu.width);
        System.out.print("Enter your choice here: ");
        int userPrintMenuChoice = reader.nextInt();
        while (userPrintMenuChoice < 0 || userPrintMenuChoice > 1) {
            Menu.drawMenu(grams.charsTitle, grams.charsBanner, grams.charsRow, Menu.TITLE, gramsBanner,
                    Menu.setOptionNames("save to pdf", "main menu"), Menu.setOptionNumbers('1', '0'),
                    Menu.width);
            System.out.println("Invalid, try again");
            System.out.println();
            System.out.print("Enter your choice here: ");
            userPrintMenuChoice = reader.nextInt();
        }
        if (userPrintMenuChoice == 0) {
            clearAll();
            Menu.gotoMainMenu();
        } else {
            Export.getPDF(getRouxFlourAmount(flourWeight) + "g", getRouxWaterAmount(flourWeight) + "g");
        }
    }

    public static void getRouxAmounts() throws IOException {
        System.out.println();
        if (justMilk >= justWater) {
            System.out.println("Total liquid amount is: " + (justMilk + justWater) + "g"); // should print only if more milk than water
            initialHydration = Math.round(((double) (justMilk + justWater) / (double) flourWeight) * 100);
        } else {
            System.out.println("Total liquid amount is: " + liquidWeight + "g"); // should print only if more water than milk
            initialHydration = Math.round(((double) liquidWeight / (double) flourWeight) * 100);
        }
        System.out.println();
        System.out.println("Total flour amount is: " + flourWeight + "g");

        System.out.println();
        System.out.println("Initial hydration % is: " + (int) initialHydration + "%");
        if (initialHydration < 75.0) {
            System.out.println();
            System.out.println("In order to use tangzhong, the hydration should be at least 75%");
            System.out.println();
            if (justMilk >= justWater) {
                newLiquidWeight = (justMilk + justWater) + getMoreWater(flourWeight, (justMilk + justWater));
                System.out.println("You will need to add " + getMoreWater(flourWeight, (justMilk + justWater)) +
                        "g additional milk to your recipe, \nfor a total of " + (int) Math.round(newLiquidWeight) + "g");
                System.out.println();
                System.out.println("Amounts for the roux:\n" + getRouxFlourAmount(flourWeight) + "g flour\n" +
                        getRouxWaterAmount(flourWeight) + "g milk");
            } else {
                newLiquidWeight = liquidWeight + getMoreWater(flourWeight, liquidWeight);
                System.out.println("You will need to add " + getMoreWater(flourWeight, liquidWeight) +
                        "g additional water to your recipe, \nfor a total of " + (int) Math.round(newLiquidWeight) + "g");
                System.out.println();
                System.out.println("Amounts for the roux:\n" + getRouxFlourAmount(flourWeight) + "g flour\n" +
                        getRouxWaterAmount(flourWeight) + "g water");
            }
        } else {
            System.out.println("You have a high enough hydration percentage, you do not need to alter anything");
            System.out.println();
            System.out.println("Amounts for the roux:\n" + (int) Math.round(flourWeight * Conversions.ROUX_PERCENT)
                    + "g flour\n" + (int) Math.round((flourWeight * Conversions.ROUX_PERCENT) * 5) + "g liquid");
        }
        gotoPrintMenu();
    }

    public static int getMoreWater(int flourWeight, int liquidWeight) {
        return (int) (Math.round(flourWeight * 0.75) - liquidWeight);
    }

    public static int getRouxFlourAmount(int flourWeight) {
        return (int) Math.round(flourWeight * Conversions.ROUX_PERCENT);
    }

    public static int getRouxWaterAmount(int flourWeight) {
        return getRouxFlourAmount(flourWeight) * 5;
    }

    public static void clearAll() {
        liquidWeight = 0;
        flourWeight = 0;
        initialHydration = 0;
        newLiquidWeight = 0;
        timesChoseWater = 0;
        timesChoseMilk = 0;
        timesChoseEggs = 0;
        timesChoseButter = 0;
        timesChoseHoney = 0;
        timesChoseSyrup = 0;
        timesChoseMolasses = 0;
        timesChoseFlour = 0;
        justMilk = 0;
        justWater = 0;
    }
}
