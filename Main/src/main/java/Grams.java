import java.util.Scanner;

public class Grams {
    static Scanner reader = new Scanner(System.in);
    static Menu grams = new Menu();
    public static int liquidWeight = 0;
    public static int flourWeight = 0;
    public static double initialHydration = 0.0;
    public static double newLiquidWeight = 0.0;
    // these are counters to track how many times the user chooses an option
    static int timesChoseWater = 0;
    static int timesChoseMilk = 0;
    static int timesChoseEggs = 0;
    static int timesChoseButter = 0;
    static int timesChoseHoney = 0;
    static int timesChoseSyrup = 0;
    static int timesChoseMolasses = 0;

    public static void goToGramsMenu() throws InterruptedException {
        Menu.drawMenu(grams.charsTitle, grams.charsBanner, grams.charsRow, grams.title, "liquid in grams",
                Menu.setOptionNames("water", "milk", "eggs", "butter", "honey", "syrup", "molasses", "done", "back"),
                Menu.setOptionNumbers('1', '2', '3', '4', '5', '6', '7', '8', '0'), grams.width);
        System.out.print("Enter your choice here: ");
        int userChoice = reader.nextInt();

        while (userChoice >= 0 && userChoice <= 7) {
            if (userChoice == 0) {
                Main.goToMainMenu();
            } else if (userChoice == 1) {
                goToWater();
            } else if (userChoice == 2) {
                goToMilk();
            } else if (userChoice == 3) {
                goToEggs();
            } else if (userChoice == 4) {
                goToButter();
            } else if (userChoice == 5) {
                goToHoney();
            } else if (userChoice == 6) {
                goToSyrup();
            } else if (userChoice == 7) {
                goToMolasses();
            } else if (userChoice == 8) {
                break;
            }
        }

        System.out.print("Enter the amount of all flour in grams: ");
        flourWeight = reader.nextInt();

        // catches incorrect inputs
        while (liquidWeight > flourWeight) {
            System.out.println();
            System.out.println("Hmmm... you entered more liquid than flour. Are you baking a cake?");
            System.out.println("If so, you don't need to use this method. Proceed as normally,");
            System.out.println("or re-enter your ingredient amounts...");
            System.out.println();
            System.out.print("Enter the amount of all liquids in grams: ");
            liquidWeight = reader.nextInt();
            System.out.print("Enter the amount of all flour in grams: ");
            flourWeight = reader.nextInt();
        }

        initialHydration = Math.round(((double) liquidWeight / (double) flourWeight) * 100);
        System.out.println();
        System.out.println("Initial hydration % is: " + (int) initialHydration + "%");

        // we only need to change things if the hydration is below 75%
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
            System.out.println("Amounts for the slurry:\n" + (int) Math.round(flourWeight * 0.075) + "g flour\n" +
                    (int) Math.round((flourWeight * 0.075) * 5) + "g liquid");
        }
        //TODO make this ask the user if they want to save their results to a PDF or make a new main menu with that option
        Main.goToMainMenu();
    }

    public static void goToWater() throws InterruptedException {
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

    public static void goToMilk() throws InterruptedException {
        if (timesChoseMilk > 0) {
            System.out.println("You already entered milk " + timesChoseMilk + " time(s), are you sure you " +
                    "want to enter more milk?");
            System.out.print("Type 1 for yes, or 0 for no: ");
            int moreMilk = reader.nextInt();

            // catches invalid input
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

    public static void goToEggs() throws InterruptedException {
        if (timesChoseEggs > 0) {
            System.out.println("You already entered eggs " + timesChoseEggs + " time(s), are you sure you " +
                    "want to enter more eggs?");
            System.out.print("Type 1 for yes, or 0 for no: ");
            int moreEggs = reader.nextInt();

            // catches invalid input
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

    public static void goToButter() throws InterruptedException {
        if (timesChoseButter > 0) {
            System.out.println("You already entered butter " + timesChoseButter + " time(s), are you sure you " +
                    "want to enter more butter?");
            System.out.print("Type 1 for yes, or 0 for no: ");
            int moreButter = reader.nextInt();

            // catches invalid input
            while (moreButter < 0 || moreButter > 1) {
                System.out.print("You must enter either 1 for yes, or 0 for no: ");
                moreButter = reader.nextInt();
            }
            if (moreButter == 1) {
                System.out.print("Enter the amount of butter in grams: ");
                timesChoseMilk++;
                liquidWeight += (int) Math.round(reader.nextInt() * Conversions.BUTTER);
            }
            goToGramsMenu();
        }
        System.out.print("Enter the amount of butter in grams: ");
        timesChoseMilk++;
        liquidWeight += (int) Math.round(reader.nextInt() * Conversions.BUTTER);
        goToGramsMenu();
    }

    public static void goToHoney() throws InterruptedException {
        if (timesChoseHoney > 0) {
            System.out.println("You already entered honey " + timesChoseHoney + " time(s), are you sure you " +
                    "want to enter more honey?");
            System.out.print("Type 1 for yes, or 0 for no: ");
            int moreHoney = reader.nextInt();

            // catches invalid input
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

    public static void goToSyrup() throws InterruptedException {
        if (timesChoseSyrup > 0) {
            System.out.println("You already entered syrup " + timesChoseSyrup + " time(s), are you sure you " +
                    "want to enter more syrup?");
            System.out.print("Type 1 for yes, or 0 for no: ");
            int moreMilk = reader.nextInt();

            // catches invalid input
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

    public static void goToMolasses() throws InterruptedException {
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
