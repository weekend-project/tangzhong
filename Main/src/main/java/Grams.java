import java.util.Scanner;

public class Grams {
    public static int liquidWeight = 0;
    public static int flourWeight = 0;
    public static double initialHydration = 0.0;
    public static double newLiquidWeight = 0.0;

    public static void gramConversion() throws InterruptedException {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter the amount of all liquids in grams: ");
        liquidWeight = reader.nextInt();
        System.out.print("Enter the amount of all flour in grams: ");
        flourWeight = reader.nextInt();

        while(liquidWeight > flourWeight) { // catches incorrect inputs
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
        Thread.sleep(500);
        System.out.println();
        System.out.println("Initial hydration % is: " + (int) initialHydration + "%");

        if (initialHydration < 75.0) { // we only need to change things if the hydration is below 75%
            Thread.sleep(1000);
            System.out.println();
            System.out.println("In order to use tangzhong, you want your hydration to be at least 75%");
            Thread.sleep(1000);
            System.out.println();
            newLiquidWeight = liquidWeight + getMoreLiquid(flourWeight, liquidWeight);
            System.out.println("You will need to add " + getMoreLiquid(flourWeight, liquidWeight) + "g additional liquid to your recipe, \nfor a total of " + (int) Math.round(newLiquidWeight) + "g");
            System.out.println();
            System.out.println("Amounts for the slurry:\n" + getFlourSlurry(flourWeight) + "g flour\n" + getLiquidSlurry(flourWeight) + "g liquid");

        } else {
            Thread.sleep(1000);
            System.out.println("You have a high enough hydration percentage, you do not need to alter anything");
            Thread.sleep(500);
            System.out.println("Amounts for the slurry:\n" + (int) Math.round(flourWeight * 0.075) + "g flour\n" + (int) Math.round((flourWeight * 0.075) * 5) +"g liquid");
        }
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
