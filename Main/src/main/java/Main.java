import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner reader = new Scanner(System.in);
        Menu.mainMenu('+','|',"tangzhong recipe builder","choose your measurements",65);
        System.out.print("Enter your choice here: ");
        int userChoice = reader.nextInt();
        System.out.println();
        while (userChoice < 1 || userChoice > 3) { // this catches invalid input
            Menu.mainMenu('+','|',"tangzhong recipe builder","choose your measurements",65);
            System.out.print("You must enter a valid option, try again: ");
            userChoice = reader.nextInt();
            System.out.println();
        }
        if (userChoice == 1) {
            Grams.gramConversion();
        } else if (userChoice == 2){
            Volume.volumeConversion();
        } else if (userChoice == 3) {
            Conversions.temp();
        }
        //Export.getPDF();
    }

    //TODO create method for allowing the user to select what type of liquid ingredients (milk, eggs, honey, butter, etc)

}
