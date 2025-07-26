public class Game extends GameMethods {
    public static void main(String[] args) {
        while (true) { //While loop to continue asking the user to choose their class, validates their choice.
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

        //If statement below confirms user's choice and will run the corresponding story path.
        if (isKnight) {
            System.out.println("You have chosen The Knight.");
            Knight.runKnightStory();
        } else if (isArcher) {
            System.out.println("You have chosen The Archer!");
            Archer.runArcherStory();
        } else if (isMage) {
            System.out.println("You have chosen The Mage!");
            Mage.runMageStory();
        }
        
        input.close();
    }
}
