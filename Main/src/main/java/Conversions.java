public class Conversions {
    //TODO evaluate if this class is necessary

    public static final double TBSP_1 = 0.0625;
    public static final double TBSP_2 = TBSP_1 * 2;
    public static final double TBSP_3 = TBSP_1 * 3;
    public static final double TBSP_4 = TBSP_1 * 4;
    public static final double TBSP_5 = TBSP_1 * 5;
    public static final double TBSP_6 = TBSP_1 * 6;
    public static final double TBSP_7 = TBSP_1 * 7;
    public static final double TBSP_8 = TBSP_1 * 8;
    public static final double TBSP_9 = TBSP_1 * 9;

    // Each double below is the % of water in each ingredient
    public static final double MILK = 0.87;
    public static final double EGGS = 0.74;
    public static final double HONEY = 0.17;
    public static final double BUTTER = 0.16;
    public static final double SYRUP = 0.33; // https://extension.psu.edu/from-the-woods-maple-syrup-a-taste-of-nature
    public static final double MOLASSES = 0.22; // https://en.wikipedia.org/wiki/Molasses

    // Each var amount below is its weight in grams
    public static final int FLOUR_1_CUP = 120;
    public static final int WATER_1_CUP = 227;
    public static final int MILK_1_CUP = 227;
    public static final int EGGS_WHOLE_1 = 50;
    public static final double BUTTER_1_TBSP = 14.18;
    public static final int HONEY_1_TBSP = 21;
    public static final double SYRUP_1_TBSP = 19.5;
    public static final double MOLASSES_1_TBSP = 21.25;



    public static int convertMilkToGrams(int numOfCups) {
        return (numOfCups * MILK_1_CUP);
    }

    public static int convertFlourToGrams(int numOfCups) {
        return (numOfCups * FLOUR_1_CUP);
    }

    public static int convertWaterToGrams(int numOfCups) {
        return (numOfCups * WATER_1_CUP);
    }

    public static int convertEggsToGrams(int numOfEggs) {
        return (numOfEggs * EGGS_WHOLE_1);
    }

    public static double convertButterToGrams(int numOfTbsp) {
        return (numOfTbsp * BUTTER_1_TBSP);
    }

    public static int convertHoneyToGrams(int numOfTbsp) {
        return (numOfTbsp * HONEY_1_TBSP);
    }

    public static double convertSyrupToGrams(int numOfTbsp) {
        return (numOfTbsp * SYRUP_1_TBSP);
    }

    public static double convertMolassesToGrams(int numOfTbsp) {
        return (numOfTbsp * MOLASSES_1_TBSP);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
