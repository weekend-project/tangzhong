import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner reader = new Scanner(System.in);
        System.out.println(">>>>>>>>>>>>>>>  Tangzhong Recipe Builder  <<<<<<<<<<<<<<<");
        System.out.println();
        System.out.println("Enter the amounts in grams for the following ingredients...");
        System.out.println();
        System.out.print("Enter 1 now to continue using weight (grams), or \nEnter 2 now if you only have volume measurements: ");
        int userChoice = reader.nextInt();
        System.out.println();
        while (userChoice != 1 && userChoice != 2) { // this catches input that is not 1 or 2
            System.out.print("You must enter 1 to use weight, or 2 to use volume: ");
            userChoice = reader.nextInt();
            System.out.println();
        }
        if (userChoice == 1) {
            Grams.gramConversion();
        } else {
            Volume.volumeConversion();
        }
        Export.getPDF();
    }

    //TODO create method for allowing the user to select what type of liquid ingredients (milk, eggs, honey, butter, etc)

}
