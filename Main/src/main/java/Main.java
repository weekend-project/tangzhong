import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner reader = new Scanner(System.in);
        Menu main = new Menu();

        /*
            When calling drawMenu, use Menu.java to change some parameters, and pass in custom parameters when calling
            setOptionNames(<custom params here>) and setOptionNumbers(<custom params here>).
         */
        Menu.drawMenu(main.charsTitle,main.charsBanner,main.charsRow,main.title,"main menu",
            Menu.setOptionNames("metric","imperial","volume","exit"),Menu.setOptionNumbers('1','2','3','0'),main.width);

        System.out.print("Enter your choice here: ");
        int userChoice = reader.nextInt();
        System.out.println();

        // this loop catches invalid input
        while (userChoice < 0 || userChoice > 3) {
            Menu.drawMenu(main.charsTitle,main.charsBanner,main.charsRow,main.title,"main menu",
                    Menu.setOptionNames("metric","imperial","volume","exit"),Menu.setOptionNumbers('1','2','3','0'),60);
            System.out.print("You must enter a valid option, try again: ");
            userChoice = reader.nextInt();
            System.out.println();
        }

        // control flow for userChoice
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
