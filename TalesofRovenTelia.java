import java.util.Scanner;

public class TalesofRovenTelia {

    public static Scanner input = new Scanner(System.in);
    static int userChoice;

    static boolean isKnight;
    static boolean isArcher;
    static boolean isMage;

    static int hp;

    static int numHealthPotions;

    static int monsterHP;

    public static void askUserTheirClass() { //Asks the user their class.
        System.out.println("\n--- Choose Your Class ---");
        System.out.println("1. The Knight");
        System.out.println("2. The Archer");
        System.out.println("3. The Mage");
        System.out.print("Type the number that corresponds with your chosen class: ");
    }

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

    //GAME METHODS/MECHANICS BELOW V V V
    
    public static void fightCard() {
        System.out.println("+------------------------+");
        System.out.println("|         Fight!         |");
        System.out.println("+------------------------+");    
    }

    public static void monsterIntro(int numMonsters, String monsterName, int monsterHealth) {
        monsterHP = monsterHealth;
        if (numMonsters > 1) {
            System.out.println(numMonsters + " " + monsterName + " appear!");
        } else {
            System.out.println("A " + monsterName + " appears!");
        }
    }

    public static void fightSequence() {
        while (monsterHP > 0 && hp > 0) {
            System.out.println("Monster HP: " + monsterHP);
            System.out.println("Your HP: " + hp);
            System.out.println("What do you do?");
            System.out.println("1. ATTACK");
            System.out.println("2. ITEM");

            userChoice = input.nextInt();

            switch(userChoice) {
                case 1:
                    double crit = Math.random();
                    if (crit > 0.8)  {
                        System.out.println("You raise your greatsword overhead and bring it crashing down onto your foe!");
                        monsterHP -= 5;
                        System.out.println("A critical hit!");
                    } else {
                        System.out.println("You swing your sword toward your foe.");
                        monsterHP -= 3;
                    }
                    break;
                case 2:
                    System.out.println("ITEMS");
                    System.out.println("1. Health Potion x " + numHealthPotions);
                    System.out.println("2. BACK");

                    userChoice = input.nextInt();

                    if (userChoice == 1) {
                        numHealthPotions--;
                        System.out.println("Consumed 1 Health Potion. 35 HP restored.");
                        hp += 35;
                    } else {
                        continue;
                    }
                    break;
            }

            if (monsterHP > 0) {
                System.out.println("Your foe strikes back!");
                hp -= 15;
            }

            if (monsterHP <= 0) {
                System.out.println("You defeated your foe!");
                break;
            } else if (hp <= 0) {
                System.out.println("You died!");
                break;
            }
        }
    }

    //KNIGHT STORY PATH KNIGHT STORY PATH KNIGHT STORY PATH KNIGHT STORY PATH
    //V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V

    

    public static void runKnightStory() {
        System.out.println("Running Knight pathway."); 

        hp = 150;

        numHealthPotions = 2;
        
        System.out.println("You were once a well respected knight in the kingdom of Roven Telia, but after some controversy about you and the princess, you were banished and sent on a suicide mission. You have to go to the old castle of Poachers Peak and slay the dragon in order to return to Roven Telia. You were geared with your basic standard issue gear and some potions by some mage and sent into the forest.");
        System.out.println("");
        System.out.println("While strolling through the deadly forest you were ambushed by a group of Goblins. You didn't speak their tongue but you could tell they wanted everything you had on you.");
        System.out.println("");

        fightCard();

        monsterIntro(3, "Goblins", 18);

        fightSequence();





    
    } //END OF KNIGHT STORY PATH

    //ARCHER STORY PATH ARCHER STORY PATH ARCHER STORY PATH ARCHER STORY PATH
    //V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V

    public static void runArcherStory() {
        System.out.println("Running Archer pathway."); //Placeholder
        //This would essentially be the "main" for the Archer path.
        //Any scripting, dialouge, fights, etc. would go here instead of Game.
    } // END OF ARCHER STORY PATH

    //MAGE STORY PATH MAGE STORY PATH MAGE STORY PATH MAGE STORY PATH MAGE STORY PATH
    //V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V

    public static void runMageStory() {
        System.out.println("Running Mage pathway."); //Placeholder
        //This would essentially be the "main" for the Mage path.
        //Any scripting, dialouge, fights, etc. would go here instead of Game.
    }

    //GAME LOOP ONLY BELOW THIS POINT. GAME LOOP ONLY BELOW THIS POINT. GAME LOOP ONLY BELOW THIS POINT.
    //GAME LOOP ONLY BELOW THIS POINT. GAME LOOP ONLY BELOW THIS POINT. GAME LOOP ONLY BELOW THIS POINT.
    //GAME LOOP ONLY BELOW THIS POINT. GAME LOOP ONLY BELOW THIS POINT. GAME LOOP ONLY BELOW THIS POINT.
    //GAME LOOP ONLY BELOW THIS POINT. GAME LOOP ONLY BELOW THIS POINT. GAME LOOP ONLY BELOW THIS POINT.
    //V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V


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
            runKnightStory();
        } else if (isArcher) {
            System.out.println("You have chosen The Archer!");
            runArcherStory();
        } else if (isMage) {
            System.out.println("You have chosen The Mage!");
            runMageStory();
        }
        
        input.close();
    }
} //end of class