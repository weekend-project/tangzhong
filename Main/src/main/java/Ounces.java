import java.io.IOException;
import java.util.Scanner;

public class Ounces {

    private static double liquidWeight;
    private static double flourWeight;
    private static double initialHydration;
    private static double newLiquidWeight;
    private static Scanner reader = new Scanner(System.in);
    private static Menu imperial = new Menu();
    private static String imperialBanner = "ingredient weights in ounces";
    private static int timesChoseWater;
    private static int timesChoseMilk;
    private static int timesChoseEggs;
    private static int timesChoseButter;
    private static int timesChoseHoney;
    private static int timesChoseSyrup;
    private static int timesChoseMolasses;
    private static int timesChoseFlour;

    public static void gotoOuncesMenu() throws IOException {
        Menu.drawMenu(imperial.charsTitle, imperial.charsBanner, imperial.charsRow, Menu.TITLE, imperialBanner,
                Menu.setOptionNames("water", "milk", "eggs", "butter", "honey", "syrup", "molasses", "flour",
                        "continue", "back"),
                Menu.setOptionNumbers('1', '2', '3', '4', '5', '6', '7', '8', '9', '0'), Menu.width);
        System.out.print("Enter your choice here: ");
        int userImperialChoice = reader.nextInt();

        if (userImperialChoice == 0) {
            Main.goToMainMenu();
        } else if (userImperialChoice == 1) {
            gotoWater();
        } else if (userImperialChoice == 2) {
            gotoMilk();
        } else if (userImperialChoice == 3) {
            gotoEggs();
        } else if (userImperialChoice == 4) {
            gotoButter();
        } else if (userImperialChoice == 5) {
            gotoHoney();
        } else if (userImperialChoice == 6) {
            gotoSyrup();
        } else if (userImperialChoice == 7) {
            gotoMolasses();
        } else if (userImperialChoice == 8) {
            gotoFlour();
        } else if (userImperialChoice == 9) {
            getRouxAmounts();
        } else {
            Main.goToMainMenu();
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
                System.out.print("Enter the amount of flour in ounces: ");
                timesChoseFlour++;
                flourWeight += reader.nextDouble() * Conversions.OUNCE_IN_GRAMS;
            }
            gotoOuncesMenu();
        }
        System.out.print("Enter the amount of all flour in ounces: ");
        timesChoseFlour++;
        flourWeight = reader.nextDouble() * Conversions.OUNCE_IN_GRAMS;
        gotoOuncesMenu();
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
                System.out.print("Enter the amount of water in ounces: ");
                timesChoseWater++;
                liquidWeight += reader.nextDouble() * Conversions.OUNCE_IN_GRAMS;
            }
            gotoOuncesMenu();
        }
        System.out.print("Enter the amount of water in ounces: ");
        timesChoseWater++;
        liquidWeight += reader.nextDouble() * Conversions.OUNCE_IN_GRAMS;
        gotoOuncesMenu();
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
                System.out.print("Enter the amount of milk in ounces: ");
                timesChoseMilk++;

                //takes current liquidWeight + (whatever the user enters) * 0.87, rounds and casts to an int
                liquidWeight += (reader.nextDouble() * Conversions.OUNCE_IN_GRAMS) * Conversions.MILK;
            }
            gotoOuncesMenu();
        }
        System.out.print("Enter the amount of milk in ounces: ");
        timesChoseMilk++;

        //takes current liquidWeight + (whatever the user enters) * 0.87, rounds and casts to an int
        liquidWeight += (reader.nextDouble() * Conversions.OUNCE_IN_GRAMS) * Conversions.MILK;
        gotoOuncesMenu();
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
                System.out.print("Enter the number of whole eggs, using .5 per one yolk: ");
                timesChoseEggs++;

                /*
                    takes current liquidWeight + (whatever the user enters * 50) * 0.74, rounds and casts to an int
                    user input * 50 because one egg weighs about 50g
                 */
                liquidWeight += ((reader.nextDouble() * Conversions.EGGS_WHOLE_1) * Conversions.EGGS);
            }
            gotoOuncesMenu();
        }
        System.out.print("Enter the number of whole eggs, using .5 per one yolk: ");
        timesChoseEggs++;

        /*
           takes current liquidWeight + (whatever the user enters * 50) * 0.74, rounds and casts to an int
           user input * 50 because one egg weighs about 50g
        */
        liquidWeight += ((reader.nextDouble() * Conversions.EGGS_WHOLE_1) * Conversions.EGGS);
        gotoOuncesMenu();
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
                System.out.print("Enter the amount of butter in tablespoons: ");
                timesChoseButter++;
                liquidWeight += (reader.nextDouble() * Conversions.BUTTER_1_TBSP) * Conversions.BUTTER;
            }
            gotoOuncesMenu();
        }
        System.out.print("Enter the amount of butter in tablespoons: ");
        timesChoseButter++;
        liquidWeight += (reader.nextDouble() * Conversions.BUTTER_1_TBSP) * Conversions.BUTTER;
        gotoOuncesMenu();
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
                System.out.print("Enter the amount of honey in tablespoons: ");
                timesChoseHoney++;
                liquidWeight += ((reader.nextDouble() * Conversions.HONEY_1_TBSP) * Conversions.HONEY);
            }
            gotoOuncesMenu();
        }
        System.out.print("Enter the amount of honey in tablespoons: ");
        timesChoseHoney++;
        liquidWeight += ((reader.nextDouble() * Conversions.HONEY_1_TBSP) * Conversions.HONEY);
        gotoOuncesMenu();
    }

    public static void gotoSyrup() throws IOException {
        if (timesChoseSyrup > 0) {
            System.out.println("You already entered syrup " + timesChoseSyrup + " time(s), are you sure you " +
                    "want to enter more syrup?");
            System.out.print("Type 1 for yes, or 0 for no: ");
            int moreSyrup = reader.nextInt();

            while (moreSyrup < 0 || moreSyrup > 1) {
                System.out.print("You must enter either 1 for yes, or 0 for no: ");
                moreSyrup = reader.nextInt();
            }
            if (moreSyrup == 1) {
                System.out.print("Enter the amount of syrup in tablespoons: ");
                timesChoseSyrup++;
                liquidWeight += ((reader.nextDouble() * Conversions.SYRUP_1_TBSP) * Conversions.SYRUP);
            }
            gotoOuncesMenu();
        }
        System.out.print("Enter the amount of syrup in tablespoons: ");
        timesChoseSyrup++;
        liquidWeight += ((reader.nextDouble() * Conversions.SYRUP_1_TBSP) * Conversions.SYRUP);
        gotoOuncesMenu();
    }

    public static void gotoMolasses() throws IOException {
        if (timesChoseMolasses > 0) {
            System.out.println("You already entered molasses " + timesChoseMolasses + " time(s), are you sure you " +
                    "want to enter more molasses?");
            System.out.print("Type 1 for yes, or 0 for no: ");
            int moreMolasses = reader.nextInt();

            // catches invalid input
            while (moreMolasses < 0 || moreMolasses > 1) {
                System.out.print("You must enter either 1 for yes, or 0 for no: ");
                moreMolasses = reader.nextInt();
            }
            if (moreMolasses == 1) {
                System.out.print("Enter the amount of molasses in tablespoons: ");
                timesChoseMolasses++;
                liquidWeight += ((reader.nextDouble() * Conversions.MOLASSES_1_TBSP) * Conversions.MOLASSES);
            }
            gotoOuncesMenu();
        }
        System.out.print("Enter the amount of molasses in tablespoons: ");
        timesChoseMolasses++;
        liquidWeight += ((reader.nextDouble() * Conversions.MOLASSES_1_TBSP) * Conversions.MOLASSES);
        gotoOuncesMenu();
    }

    public static void gotoPrintMenu() throws IOException {
        Menu.drawMenu(imperial.charsTitle, imperial.charsBanner, imperial.charsRow, Menu.TITLE, imperialBanner,
                Menu.setOptionNames("save to pdf", "main menu"), Menu.setOptionNumbers('1', '0'), Menu.width);
        System.out.print("Enter your choice here: ");
        int userPrintMenuChoice = reader.nextInt();
        while (userPrintMenuChoice < 0 || userPrintMenuChoice > 1) {
            Menu.drawMenu(imperial.charsTitle, imperial.charsBanner, imperial.charsRow, Menu.TITLE, imperialBanner,
                    Menu.setOptionNames("print results", "new conversion", "exit"),
                    Menu.setOptionNumbers('1', '2', '0'),
                    Menu.width);
            System.out.println("Invalid, try again");
            System.out.println();
            System.out.print("Enter your choice here: ");
            userPrintMenuChoice = reader.nextInt();
        }
        if (userPrintMenuChoice == 0) {
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
            Main.goToMainMenu();
        } else {
            Export.getPDF(Double.toString(getRouxFlourAmount(flourWeight)) + " ounces",
                    Double.toString(getRouxWaterAmount(flourWeight)) + " ounces");
            //TODO I don't think these variables will ever be reached, need to clear these after printing results
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
        }
    }

    public static void getRouxAmounts() throws IOException {
        liquidWeight = Conversions.round((liquidWeight / Conversions.OUNCE_IN_GRAMS),2);
        flourWeight = Conversions.round((flourWeight / Conversions.OUNCE_IN_GRAMS),2);
        initialHydration = Math.round((liquidWeight / flourWeight) * 100);
        double additionalLiquid = getMoreLiquid(flourWeight, liquidWeight);
        newLiquidWeight = Conversions.round((liquidWeight + additionalLiquid),2);



        System.out.println();
        System.out.println("Total water amount is: " + liquidWeight + " ounces");
        System.out.println();
        System.out.println("Total flour amount is: " + flourWeight + " ounces");
        System.out.println();
        System.out.println("Initial hydration % is: " + (int) initialHydration + "%");
        if (initialHydration < 75.0) {
            System.out.println();
            System.out.println("In order to use tangzhong, the hydration should be at least 75%");
            System.out.println();
            System.out.println("You will need to add " + additionalLiquid + " ounces additional water to your " +
                    "recipe, \nfor a total of " + newLiquidWeight + " ounces");
            System.out.println();
            System.out.println("Amounts for the roux:\n" + getRouxFlourAmount(flourWeight) + " ounces flour\n" +
                    getRouxWaterAmount(flourWeight) + " ounces water");
        } else {
            System.out.println("You have a high enough hydration percentage, you do not need to alter anything");
            System.out.println();
            System.out.println("Amounts for the roux:\n" + Conversions.round((flourWeight * Conversions.ROUX_PERCENT),
                    2) + " ounces flour\n" + Conversions.round(((flourWeight * Conversions.ROUX_PERCENT) * 5),
                    2) + " ounces water");
        }
        gotoPrintMenu();
    }

    public static double getMoreLiquid(double flourWeight, double liquidWeight) {
        return Conversions.round(((flourWeight * 0.75) - liquidWeight), 2);
    }

    public static double getRouxFlourAmount(double flourWeight) {
        return Conversions.round((((flourWeight * Conversions.ROUX_PERCENT))), 2);
    }

    public static double getRouxWaterAmount(double flourWeight) {
        return Conversions.round((((getRouxFlourAmount(flourWeight) * 5))), 2);
    }
}
