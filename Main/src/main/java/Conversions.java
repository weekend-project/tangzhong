public class Conversions {
    //TODO evaluate if this class is necessary

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


    public static int milkToGrams(int numOfCups) {
        return (numOfCups * MILK_1_CUP);
    }

    public static int flourToGrams(int numOfCups) {
        return (numOfCups * FLOUR_1_CUP);
    }

    public static int waterToGrams(int numOfCups) {
        return (numOfCups * WATER_1_CUP);
    }

    public static int eggsToGrams(int numOfEggs) {
        return (numOfEggs * EGGS_WHOLE_1);
    }

    public static double butterToGrams(int numOfTbsp) {
        return (numOfTbsp * BUTTER_1_TBSP);
    }

    public static int honeyToGrams(int numOfTbsp) {
        return (numOfTbsp * HONEY_1_TBSP);
    }

    public static double syrupToGrams(int numOfTbsp) {
        return (numOfTbsp * SYRUP_1_TBSP);
    }

    public static double molassesToGrams(int numOfTbsp) {
        return (numOfTbsp * MOLASSES_1_TBSP);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public static String decimalToVolume(double volume) {
        int cups = (int) volume;
        double remainder = volume - cups;
        String conversion = "";
        if (volume <= 1.03124) {
            if (volume >= 0.03125 && volume <= 0.09374) {
                conversion = "1 tablespoon";
            } else if (volume >= 0.09375 && volume <= 0.15624) {
                conversion = "2 tablespoons";
            } else if (volume >= 0.15625 && volume <= 0.21874) {
                conversion = "3 tablespoons";
            } else if (volume >= 0.21875 && volume <= 0.28124) {
                conversion = "1/4 cup";
            } else if (volume >= 0.28125 && volume <= 0.34374) {
                conversion = "1/4 cup + 1 tablespoon";
            } else if (volume >= 0.3475 && volume <= 0.40624) {
                conversion = "1/4 cup + 2 tablespoons";
            } else if (volume >= 0.40625 && volume <= 0.46874) {
                conversion = "1/4 cup + 3 tablespoons";
            } else if (volume >= 0.46875 && volume <= 0.53124) {
                conversion = "1/2 cup";
            } else if (volume >= 0.53125 && volume <= 0.59374) {
                conversion = "1/2 cup + 1 tablespoon";
            } else if (volume >= 0.59375 && volume <= 0.65624) {
                conversion = "1/2 cup + 2 tablespoons";
            } else if (volume >= 0.65625 && volume <= 0.71874) {
                conversion = "1/2 cup + 3 tablespoons";
            } else if (volume >= 0.71875 && volume <= 0.78124) {
                conversion = "3/4 cup";
            } else if (volume >= 0.78125 && volume <= 0.84374) {
                conversion = "3/4 cup + 1 tablespoon";
            } else if (volume >= 0.84375 && volume <= 0.90624) {
                conversion = "3/4 cup + 2 tablespoons";
            } else if (volume >= 0.90625 && volume <= 0.96874) {
                conversion = "3/4 cup + 3 tablespoons";
            } else if (volume >= 0.96875 && volume <= 1.03124) {
                conversion = "1 cup";
            }
        } else if (volume >= 1.03125 && volume <= 1.21874) { // >= 1 cup + 1 tbsp && <= 1 cup + 3 tbsp
            conversion = cups + " cup + " + decimalToVolume(remainder);
        } else if (cups == 1 && remainder <= .03124) { // one even cup
            conversion = cups + " cup" + decimalToVolume(remainder);
        } else if (cups >= 2 && remainder <= .03124) { // at least 2 even cups
            conversion = cups + " cups" + decimalToVolume(remainder);
        } else if (cups >= 1 && remainder >= .21875) { // at least one cup && at least 1/4 cup remainder
            conversion = cups + " & " + decimalToVolume(remainder);
        } else if (cups >= 2 && remainder >= 0.03125 && remainder <= 0.21874) { // >= 2+ cups + 1 tbsp && <= 2+ cups + 3 tbsp
            conversion = cups + " cups + " + decimalToVolume(remainder);
        } else {
            conversion = "--Error: unable to compute volume measurement--";
        }

        return conversion;
    }
}


