import java.io.IOException;
import java.util.Scanner;

public class Grams {
    public static int liquidWeight;
    public static int flourWeight;
    public static double initialHydration;
    public static double newLiquidWeight;

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

    public static void goToGramsMenu() throws IOException {
        Menu.drawMenu(grams.charsTitle, grams.charsBanner, grams.charsRow, Menu.TITLE, gramsBanner,
                Menu.setOptionNames("water", "milk", "eggs", "butter", "honey", "syrup", "molasses", "flour",
                        "continue", "back"),
                Menu.setOptionNumbers('1', '2', '3', '4', '5', '6', '7', '8', '9', '0'), Menu.width);
        System.out.print("Enter your choice here: ");
        int userGramsChoice = reader.nextInt();

        if (userGramsChoice == 0) {
            Main.goToMainMenu();
        } else if (userGramsChoice == 1) {
            goToWater();
        } else if (userGramsChoice == 2) {
            goToMilk();
        } else if (userGramsChoice == 3) {
            goToEggs();
        } else if (userGramsChoice == 4) {
            goToButter();
        } else if (userGramsChoice == 5) {
            goToHoney();
        } else if (userGramsChoice == 6) {
            goToSyrup();
        } else if (userGramsChoice == 7) {
            goToMolasses();
        } else if (userGramsChoice == 8) {
            goToFlour();
        } else if (userGramsChoice == 9) {
            getRouxAmounts();
        } else {
            Main.goToMainMenu();
        }
    }

    public static void goToFlour() throws IOException {
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
            goToGramsMenu();
        }
        System.out.print("Enter the amount of all flour in grams: ");
        timesChoseFlour++;
        flourWeight = reader.nextInt();
        goToGramsMenu();
    }

    public static void goToWater() throws IOException {
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
                liquidWeight += reader.nextInt();
            }
            goToGramsMenu();
        }
        System.out.print("Enter the amount of water in grams: ");
        timesChoseWater++;
        liquidWeight += reader.nextInt();
        goToGramsMenu();
    }

    public static void goToMilk() throws IOException {
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

                //takes current liquidWeight + (whatever the user enters) * 0.87, rounds and casts to an int
                liquidWeight += (int) Math.round(reader.nextInt() * Conversions.MILK);
            }
            goToGramsMenu();
        }
        System.out.print("Enter the amount of milk in grams: ");
        timesChoseMilk++;

        //takes current liquidWeight + (whatever the user enters) * 0.87, rounds and casts to an int
        liquidWeight += (int) Math.round(reader.nextInt() * Conversions.MILK);
        goToGramsMenu();
    }

    public static void goToEggs() throws IOException {
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
            goToGramsMenu();
        }
        System.out.print("Enter the number of whole eggs: ");
        timesChoseEggs++;

        /*
           takes current liquidWeight + (whatever the user enters * 50) * 0.74, rounds and casts to an int
           user input * 50 because one egg weighs about 50g
        */
        liquidWeight += (int) Math.round((reader.nextInt() * 50) * Conversions.EGGS);
        goToGramsMenu();
    }

    public static void goToButter() throws IOException {
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
            goToGramsMenu();
        }
        System.out.print("Enter the amount of butter in grams: ");
        timesChoseButter++;
        liquidWeight += (int) Math.round(reader.nextInt() * Conversions.BUTTER);
        goToGramsMenu();
    }

    public static void goToHoney() throws IOException {
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
            goToGramsMenu();
        }
        System.out.print("Enter the amount of honey in grams: ");
        timesChoseHoney++;
        liquidWeight += (int) Math.round(reader.nextInt() * Conversions.HONEY);
        goToGramsMenu();
    }

    public static void goToSyrup() throws IOException {
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
            goToGramsMenu();
        }
        System.out.print("Enter the amount of syrup in grams: ");
        timesChoseSyrup++;
        liquidWeight += (int) Math.round(reader.nextInt() * Conversions.SYRUP);
        goToGramsMenu();
    }

    public static void goToMolasses() throws IOException {
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
            goToGramsMenu();
        }
        System.out.print("Enter the amount of molasses in grams: ");
        timesChoseMolasses++;
        liquidWeight += (int) Math.round(reader.nextInt() * Conversions.MOLASSES);
        goToGramsMenu();
    }

    public static void goToPrintMenu() throws IOException {
        Menu.drawMenu(grams.charsTitle, grams.charsBanner, grams.charsRow, Menu.TITLE, gramsBanner,
                Menu.setOptionNames("save to pdf", "main menu"), Menu.setOptionNumbers('1', '0'),
                Menu.width);
        System.out.print("Enter your choice here: ");
        int userPrintMenuChoice = reader.nextInt();
        while (userPrintMenuChoice < 0 || userPrintMenuChoice > 1) {
            Menu.drawMenu(grams.charsTitle, grams.charsBanner, grams.charsRow, Menu.TITLE, gramsBanner,
                    Menu.setOptionNames("print results", "new conversion", "exit"),
                    Menu.setOptionNumbers('1', '2', '0'),
                    Menu.width);
            System.out.println("Invalid, try again");
            System.out.println();
            System.out.print("Enter your choice here: ");
            userPrintMenuChoice = reader.nextInt();
        }
        if (userPrintMenuChoice == 0) {
            Main.goToMainMenu();
        } else {
            Export.getPDF();
        }
    }

    public static void getRouxAmounts() throws IOException {
        if (liquidWeight > flourWeight) {
            System.out.println();
            System.out.println("You entered more liquid than flour. Are you baking a cake?");
            System.out.println("If so, you don't need to use this method. Proceed as normally,");
            System.out.println("or re-enter your ingredient amounts...");
            System.out.println();
            Main.goToMainMenu();
        }
        System.out.println();
        System.out.println("Total liquid amount is: " + liquidWeight + "g");
        System.out.println();
        System.out.println("Total flour amount is: " + flourWeight + "g");
        initialHydration = Math.round(((double) liquidWeight / (double) flourWeight) * 100);
        System.out.println();
        System.out.println("Initial hydration % is: " + (int) initialHydration + "%");
        if (initialHydration < 75.0) {
            System.out.println();
            System.out.println("In order to use tangzhong, the hydration should be at least 75%");
            System.out.println();
            newLiquidWeight = liquidWeight + getMoreLiquid(flourWeight, liquidWeight);
            System.out.println("You will need to add " + getMoreLiquid(flourWeight, liquidWeight) +
                    "g additional liquid to your recipe, \nfor a total of " + (int) Math.round(newLiquidWeight) + "g");
            System.out.println();
            System.out.println("Amounts for the slurry:\n" + getFlourSlurry(flourWeight) + "g flour\n" +
                    getLiquidSlurry(flourWeight) + "g liquid");
        } else {
            System.out.println("You have a high enough hydration percentage, you do not need to alter anything");
            System.out.println();
            System.out.println("Amounts for the slurry:\n" + (int) Math.round(flourWeight * 0.075) + "g flour\n" +
                    (int) Math.round((flourWeight * 0.075) * 5) + "g liquid");
        }
        goToPrintMenu();
    }

    public static int getMoreLiquid(int flourWeight, int liquidWeight) {
        return (int) (Math.round(flourWeight * 0.75) - liquidWeight);
    }

    public static int getFlourSlurry(int flourWeight) {
        return (int) Math.round(flourWeight * 0.075);
    }

    public static int getLiquidSlurry(int flourWeight) {
        return getFlourSlurry(flourWeight) * 5;
    }
}
