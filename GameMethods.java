import java.util.Scanner;

class GameMethods {


    //Methods below are for letting the user choose their class and validating that choice.

    static boolean isKnight;
    static boolean isArcher;
    static boolean isMage;

    public static Scanner input = new Scanner(System.in);
    static int userChoice;

    public static void classValidator() { //Checks if user input is valid after asking to choose their class.
        while (true) {
            askUserTheirClass();
            if (input.hasNextInt()) {
                userChoice = input.nextInt();
                
                input.nextLine(); 
                if (userChoice >= 1 && userChoice <= 3) {
                    break;
                } else {
                    System.out.println("Please choose a valid class (1, 2, or 3).");
                }
            } else {
                System.out.println("Please enter a number for the corresponding class you wish to play as.");
                input.nextLine(); 
            }
        }
    }

    public static void askUserTheirClass() { //Asks the user their class.
        System.out.println("\n--- Choose Your Class ---");
        System.out.println("1. The Knight");
        System.out.println("2. The Archer");
        System.out.println("3. The Mage");
        System.out.print("Type the number that corresponds with your chosen class: ");
    }

    public static void askKnight() { //Gives brief description of Knight class.
        System.out.println("\n--- The Knight ---");
        System.out.println("HP: 150");
        System.out.println("Items: 2 x Health potion");
        System.out.println("Description: Wields great sword. Higher chance of critical damage, armor causes slightly higher damage negation to other classes.");
        System.out.print("Choose The Knight? Y/N > ");
    }

    public static void askArcher() { //Gives brief description of Archer class.
        System.out.println("\n--- The Archer ---");
        System.out.println("HP: 80");
        System.out.println("Items: 50x Arrow, 1x health potion");
        System.out.println("Description: Wields a bow and arrows. High chance of dodging incoming attacks.");
        System.out.print("Choose The Archer? Y/N > ");
    }

    public static void askMage() { //Gives brief description of Mage class.
        System.out.println("\n--- The Mage ---");
        System.out.println("HP: 100");
        System.out.println("Mana: 75");
        System.out.println("Items: 2x Mana potion");
        System.out.println("Description: Wields magic. Has a limited amount of mana, so use it wisely!");
        System.out.print("Choose The Mage? Y/N > ");
    }

    public static boolean yesOrNoValidator() { //Checks if the user has confirmed choice, or if the input is valid.
        while (true) {
            String confirmation = input.nextLine();
            if (confirmation.equalsIgnoreCase("Y")) {
                if (userChoice == 1) {
                    isKnight = true;
                } else if (userChoice == 2) {
                    isArcher = true;
                } else {
                    isMage = true;
                }
                return true;
            } else if (confirmation.equalsIgnoreCase("N")) {
                isKnight = false;
                isArcher = false;
                isMage = false;
                return false;
            } else {
                System.out.print("Invalid input. Please choose Y for Yes or N for No: ");
            }
        }
    }

    //--------------------------------------------------------------------------------------//
    //           V V V        Methods below are for game mechanics          V V V           //
    //--------------------------------------------------------------------------------------//



}