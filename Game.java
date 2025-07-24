public class Game extends GameMethods {
    public static void main(String[] args) {
        while (true) {
            classValidator();

            if (userChoice == 1) {
                askKnight();
            } else if (userChoice == 2) {
                askArcher();
            } else {
                askMage();
            }

            if (yesOrNoValidator()) {
                break;
            }
        }

        if (isKnight) {
            System.out.println("You have chosen The Knight.");
        } else if (isArcher) {
            System.out.println("You have chosen The Archer!");
        } else if (isMage) {
            System.out.println("You have chosen The Mage!");
        }
        
        input.close();
    }
}