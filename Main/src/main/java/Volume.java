import java.io.IOException;
import java.util.Scanner;

public class Volume {
    public static double liquidWeight;
    public static double flourWeight;
    public static double initialHydration;
    public static double newLiquidWeight;

    private static Scanner reader = new Scanner(System.in);
    private static Menu volume = new Menu();
    public static String volumeBanner = "ingredient amounts in volume";
    private static int timesChoseWater;
    private static int timesChoseMilk;
    private static int timesChoseEggs;
    private static int timesChoseButter;
    private static int timesChoseHoney;
    private static int timesChoseSyrup;
    private static int timesChoseMolasses;
    private static int timesChoseFlour;
    private static double justMilk;
    private static double justWater;

    public static void gotoVolumeMenu() throws IOException {
        Menu.drawMenu(volume.charsTitle, volume.charsBanner, volume.charsRow, Menu.TITLE, volumeBanner,
                Menu.setOptionNames("water", "milk", "eggs", "butter", "honey", "syrup", "molasses", "flour",
                        "continue", "back"),
                Menu.setOptionNumbers('1', '2', '3', '4', '5', '6', '7', '8', '9', '0'), Menu.width);
        System.out.print("Enter your choice here: ");
        int userVolChoice = reader.nextInt();

        if (userVolChoice == 0) {
            Menu.gotoMainMenu();
        } else if (userVolChoice == 1) {
            gotoWater();
        } else if (userVolChoice == 2) {
            gotoMilk();
        } else if (userVolChoice == 3) {
            gotoEggs();
        } else if (userVolChoice == 4) {
            gotoButter();
        } else if (userVolChoice == 5) {
            gotoHoney();
        } else if (userVolChoice == 6) {
            gotoSyrup();
        } else if (userVolChoice == 7) {
            gotoMolasses();
        } else if (userVolChoice == 8) {
            gotoFlour();
        } else if (userVolChoice == 9) {
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
            double moreFlour = reader.nextInt();
            while (moreFlour < 0 || moreFlour > 1) {
                System.out.print("You must enter either 1 for yes, or 0 for no: ");
                moreFlour = reader.nextInt();
            }
            if (moreFlour == 1) {
                System.out.print("Enter the amount of flour in cups: ");
                timesChoseFlour++;
                flourWeight += Math.round(Conversions.flourToGrams(reader.nextDouble()));
            }
            gotoVolumeMenu();
        }
        System.out.print("Enter the amount of all flour in cups: ");
        timesChoseFlour++;
        flourWeight = Math.round(Conversions.flourToGrams(reader.nextDouble()));
        gotoVolumeMenu();
    }

    public static void gotoWater() throws IOException {
        if (timesChoseWater > 0) {
            System.out.println("You already entered water " + timesChoseWater + " time(s), are you sure you " +
                    "want to enter more water?");
            System.out.print("Type 1 for yes, or 0 for no: ");
            double moreWater = reader.nextInt();

            // catches invalid input
            while (moreWater < 0 || moreWater > 1) {
                System.out.print("You must enter either 1 for yes, or 0 for no: ");
                moreWater = reader.nextInt();
            }
            if (moreWater == 1) {
                System.out.print("Enter the amount of water in cups: ");
                timesChoseWater++;
                justWater += reader.nextDouble();
                liquidWeight += (int) (justWater * 227.0);
            }
            gotoVolumeMenu();
        }
        System.out.print("Enter the amount of water in cups: ");
        timesChoseWater++;
        justWater += reader.nextDouble();
        liquidWeight += (int) (justWater * 227.0);
        gotoVolumeMenu();
    }

    public static void gotoMilk() throws IOException {
        if (timesChoseMilk > 0) {
            System.out.println("You already entered milk " + timesChoseMilk + " time(s), are you sure you " +
                    "want to enter more milk?");
            System.out.print("Type 1 for yes, or 0 for no: ");
            double moreMilk = reader.nextInt();

            while (moreMilk < 0 || moreMilk > 1) {
                System.out.print("You must enter either 1 for yes, or 0 for no: ");
                moreMilk = reader.nextInt();
            }
            if (moreMilk == 1) {
                System.out.print("Enter the amount of milk in cups: ");
                timesChoseMilk++;
                liquidWeight += (int) Math.round((reader.nextDouble() * 227) * Conversions.MILK);
            }
            gotoVolumeMenu();
        }
        System.out.print("Enter the amount of milk in cups: ");
        timesChoseMilk++;
        justMilk = reader.nextDouble();
        liquidWeight += justMilk * Conversions.MILK;
        gotoVolumeMenu();
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
                System.out.print("Eggcellent, enter the number of whole eggs: ");
                timesChoseEggs++;

                /*
                    takes current liquidWeight + (whatever the user enters * 50) * 0.74, rounds and casts to an int
                    user input * 50 because one egg weighs about 50g
                 */
                liquidWeight += (int) Math.round((reader.nextInt() * 50) * Conversions.EGGS);
            }
            gotoVolumeMenu();
        }
        System.out.print("Enter the number of whole eggs: ");
        timesChoseEggs++;

        /*
           takes current liquidWeight + (whatever the user enters * 50) * 0.74, rounds and casts to an int
           user input * 50 because one egg weighs about 50g
        */
        liquidWeight += (int) Math.round((reader.nextInt() * 50) * Conversions.EGGS);
        gotoVolumeMenu();
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
                liquidWeight += (int) Math.round(Conversions.butterToGrams(reader.nextInt()) *
                        Conversions.BUTTER);
            }
            gotoVolumeMenu();
        }
        System.out.print("Enter the amount of butter in tablespoons: ");
        timesChoseButter++;
        liquidWeight += (int) Math.round(Conversions.butterToGrams(reader.nextInt()) * Conversions.BUTTER);
        gotoVolumeMenu();
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
                liquidWeight += (int) Math.round(Conversions.honeyToGrams(reader.nextInt()) * Conversions.HONEY);
            }
            gotoVolumeMenu();
        }
        System.out.print("Enter the amount of honey in tablespoons: ");
        timesChoseHoney++;
        liquidWeight += (int) Math.round(Conversions.honeyToGrams(reader.nextInt()) * Conversions.HONEY);
        gotoVolumeMenu();
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
                System.out.print("Enter the amount of syrup in tablespoons: ");
                timesChoseSyrup++;
                liquidWeight += (int) Math.round(Conversions.syrupToGrams(reader.nextInt()) * Conversions.SYRUP);
            }
            gotoVolumeMenu();
        }
        System.out.print("Enter the amount of syrup in tablespoons: ");
        timesChoseSyrup++;
        liquidWeight += (int) Math.round(Conversions.syrupToGrams(reader.nextInt()) * Conversions.SYRUP);
        gotoVolumeMenu();
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
                System.out.print("Enter the amount of molasses in tablespoons: ");
                timesChoseMolasses++;
                liquidWeight += (int) Math.round(Conversions.molassesToGrams(reader.nextInt()) *
                        Conversions.MOLASSES);
            }
            gotoVolumeMenu();
        }
        System.out.print("Enter the amount of molasses in tablespoons: ");
        timesChoseMolasses++;
        liquidWeight += (int) Math.round(Conversions.molassesToGrams(reader.nextInt()) * Conversions.MOLASSES);
        gotoVolumeMenu();
    }

    public static void gotoPrintMenu() throws IOException {
        Menu.drawMenu(volume.charsTitle, volume.charsBanner, volume.charsRow, Menu.TITLE, volumeBanner,
                Menu.setOptionNames("save to pdf", "main menu"), Menu.setOptionNumbers('1', '0'),
                Menu.width);
        System.out.print("Enter your choice here: ");
        int userPrintMenuChoice = reader.nextInt();
        while (userPrintMenuChoice < 0 || userPrintMenuChoice > 1) {
            Menu.drawMenu(volume.charsTitle, volume.charsBanner, volume.charsRow, Menu.TITLE, volumeBanner,
                    Menu.setOptionNames("print results", "new conversion", "exit"),
                    Menu.setOptionNumbers('1', '2', '0'),
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
            Export.getPDF((Conversions.decimalToVolume(Conversions.round(
                    getRouxFlourAmount(flourWeight) / 120.0, 2))),
                    Conversions.decimalToVolume(Conversions.round(getRouxWaterAmount(flourWeight) / 227.0, 2)));
        }
    }

    public static void getRouxAmounts() throws IOException {
        System.out.println();
        if (justMilk >= justWater) {
            System.out.println("Total liquid amount is: " + Conversions.decimalToVolume(Conversions.round(
                    (justMilk + justWater), 2)));
            initialHydration = Math.round((((justMilk + justWater) * 227.0) / flourWeight) * 100);
        } else {
            System.out.println("Total water amount is: " + Conversions.decimalToVolume(Conversions.round(
                    liquidWeight / 227.00, 2)));
            initialHydration = Math.round((liquidWeight / flourWeight) * 100);
        }
        System.out.println();
        System.out.println("Total flour amount is: " + Conversions.decimalToVolume(Conversions.round(
                flourWeight / 120.00, 2)));
        System.out.println();
        System.out.println("Initial hydration % is: " + (int) initialHydration + "%");
        if (initialHydration < 75.0) {
            System.out.println();
            System.out.println("In order to use tangzhong, the hydration should be at least 75%");
            System.out.println();
            if (justMilk >= justWater) {
                newLiquidWeight = ((justMilk + justWater) * 227.0) + getMoreLiquid(flourWeight, ((justMilk + justWater)
                        * 227.0));
                System.out.println("You will need to add " + Conversions.decimalToVolume(Conversions.round(
                        (double) getMoreLiquid(flourWeight, ((justMilk + justWater) * 227.0)) / 227.00, 2))
                        + " of additional milk to your recipe, \nfor a total of " +
                        Conversions.decimalToVolume(Conversions.round(newLiquidWeight / 227.0, 2)));
                System.out.println();
                System.out.println("Amounts for the roux:\n" + Conversions.decimalToVolume(Conversions.round(
                        getRouxFlourAmount(flourWeight) / 120.0, 2)) + " flour\n" +
                        Conversions.decimalToVolume(Conversions.round(getRouxWaterAmount(flourWeight) / 227.0, 2))
                        + " milk");
            } else {
                newLiquidWeight = liquidWeight + getMoreLiquid(flourWeight, liquidWeight);
                System.out.println("You will need to add " + Conversions.decimalToVolume(Conversions.round(
                        (double) getMoreLiquid(flourWeight, liquidWeight) / 227.00, 2)) +
                        " of additional water to your recipe, \nfor a total of " +
                        Conversions.decimalToVolume(Conversions.round(newLiquidWeight / 227.0, 2)));
                System.out.println();
                System.out.println("Amounts for the roux:\n" + Conversions.decimalToVolume(Conversions.round(
                        getRouxFlourAmount(flourWeight) / 120.0, 2)) + " flour\n" +
                        Conversions.decimalToVolume(Conversions.round(getRouxWaterAmount(flourWeight) / 227.0, 2))
                        + " water");
            }
        } else {
            System.out.println("You have a high enough hydration percentage, you do not need to alter anything");
            System.out.println();
            System.out.println("Amounts for the roux:\n" + Conversions.decimalToVolume(Conversions.round(
                    flourWeight * Conversions.ROUX_PERCENT / 120.0, 2)) + " flour\n" +
                    Conversions.decimalToVolume(Conversions.round(((flourWeight * Conversions.ROUX_PERCENT) /
                            227.0) * 5, 2)) + " liquid");
        }
        gotoPrintMenu();
    }

    public static int getMoreLiquid(double flourWeight, double liquidWeight) {
        return (int) (Math.round(flourWeight * 0.75) - liquidWeight);
    }

    public static int getRouxFlourAmount(double flourWeight) {
        return (int) Math.round(flourWeight * Conversions.ROUX_PERCENT);
    }

    public static int getRouxWaterAmount(double flourWeight) {
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
