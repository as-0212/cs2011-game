import java.util.Scanner;

public class TalesofRovenTelia {

    public static Scanner input = new Scanner(System.in);
    static int userChoice;

    static boolean isKnight;
    static boolean isArcher;
    static boolean isMage;

    static int hp;
    static int mana = 75;

    static int numHealthPotions;
    static int numManaPotions = 3;

    static int numArrows = 50;

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
         System.out.println(" .  *  )");
        System.out.println(" o  | )  ");
        System.out.println(" |< +");
        System.out.println("/ \\");
        System.out.println("");
        System.out.println("\n--- The Knight ---");
        System.out.println("HP: 150");
        System.out.println("Items: 2 x Health potion");
        System.out.println("Description: Wields great sword. Higher chance of critical damage, armor causes slightly higher damage negation to other classes.");
        System.out.print("Choose The Knight? Y/N > ");
    }

    public static void askArcher() { //Gives brief description of Archer class.
        System.out.println("  ! ");
        System.out.println("  o   ");
        System.out.println("  |<}-> -> ->");
        System.out.println(" / \\");
        System.out.println("");
        System.out.println("\n--- The Archer ---");
        System.out.println("HP: 80");
        System.out.println("Items: 50x Arrow, 1x health potion");
        System.out.println("Description: Wields a bow and arrows. High chance of dodging incoming attacks.");
        System.out.print("Choose The Archer? Y/N > ");
    }

    public static void askMage() { //Gives brief description of Mage class.
        System.out.println(" *    *");
        System.out.println(" o   *");
        System.out.println("/|\\/");
        System.out.println("/ \\");
        System.out.println("");
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

    public static void knightFightSequence() {
        while (monsterHP > 0 && hp > 0) {
            System.out.println("Monster HP: " + monsterHP);
            System.out.println("Your HP: " + hp);
            System.out.println("What do you do?");
            System.out.println("1. ATTACK");
            System.out.println("2. ITEM");

            userChoice = input.nextInt();

            switch(userChoice) {
                case 1:
                    double insecurity = Math.random();
                    double crit = Math.random();
                    if (crit > 0.8)  {
                        System.out.println("You raise your greatsword overhead and bring it crashing down onto your foe!");
                        if (insecurity > 0.9) {
                            System.out.println("But thoughts of your ex cloud your mind and you miss the critical hit.");
                            monsterHP -= 3;
                        } else {
                            monsterHP -= 5;
                            System.out.println("A critical hit!");
                        }
                    } else {
                        System.out.println("You swing your sword toward your foe.");
                        if (insecurity > 0.8) {
                            System.out.println("But your insecurities get the better of you, and your attack doesn't land as well as you want it to.");
                            monsterHP -= 1;
                        } else {
                            System.out.println("A successful hit!");
                            monsterHP -= 3;
                        }
                        
                    }
                    break;
                case 2:
                    System.out.println("ITEMS");
                    System.out.println("1. Health Potion x " + numHealthPotions);
                    System.out.println("2. BACK");

                    userChoice = input.nextInt();

                    if (userChoice == 1) {
                        if (numHealthPotions < 0) {
                            numHealthPotions--;
                        System.out.println("Consumed 1 Health Potion. 35 HP restored.");
                        hp += 50;
                        } else {
                            System.out.println("You have no more health potions.");
                        }
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

    public static void archerFightSequence() {

        int arrowsLost = 0;

        while (monsterHP > 0 && hp > 0) {
            System.out.println("Monster HP: " + monsterHP);
            System.out.println("Your HP: " + hp);
            System.out.println("Arrows: " + numArrows);
            System.out.println("What do you do?");
            System.out.println("1. ATTACK");
            System.out.println("2. ITEM");

            userChoice = input.nextInt();

            switch(userChoice) {
                case 1:
                    double overambition = Math.random();
                    System.out.println("ATTACKS");
                    System.out.println("1. Bow shot");
                    System.out.println("2. Bow trick shot");
                    System.out.println("3. Bow whack");

                    userChoice = input.nextInt();

                    if (userChoice == 1) {
                        if (numArrows > 0) {
                        System.out.println("You draw the bow string and let an arrow fly.");
                        monsterHP -= 2;
                        numArrows --;
                        arrowsLost++;
                        System.out.println("A successful shot!");
                        } else {
                            System.out.println("You reach for your quiver and realize you have run out of arrows!");
                        }
                    } else if (userChoice == 2) {
                        if (numArrows > 0) {
                        System.out.println("You, the showoff that you are, attempt to land a trickshot.");
                        System.out.println("You aim your bow and arrow up and draw the bow string, loosing the arrow into the sky...");
                        if (overambition > 0.7) {
                            System.out.println("You overambition got the better of you, and you just opened yourself up to a counter attack.");
                            numArrows--;
                        } else {
                            System.out.println("And the shot lands! A successful, critical shot!");
                            monsterHP -= 15;
                            numArrows--;
                            arrowsLost++;
                        }
                        } else {
                            System.out.println("You reach for your quiver and realize you have run out of arrows!");
                        }
                    } else if (userChoice == 3) {
                        System.out.println("You rush towards your foe and give them a good thwack! with your bow.");
                        monsterHP -= 4;
                    }
                    break;
                case 2:
                    System.out.println("ITEMS");
                    System.out.println("1. Health Potion x " + numHealthPotions);
                    System.out.println("2. BACK");

                    userChoice = input.nextInt();

                    if (userChoice == 1) {
                        if (numHealthPotions > 0) {
                            numHealthPotions--;
                        System.out.println("Consumed 1 Health Potion. 35 HP restored.");
                        hp += 50;
                        } else {
                            System.out.println("You are out of health potions.");
                        }
                        
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
                double arrowsRecovered = arrowsLost * (Math.random());

                numArrows += (int) arrowsRecovered;
                System.out.println("You've successfully recovered " + (int) arrowsRecovered + " arrows from the fight!");

                break;
            } else if (hp <= 0) {
                System.out.println("You died!");
                break;
            }
        }
    }

    public static void mageFightSequence() {
        while (monsterHP > 0 && hp > 0) {
            System.out.println("Monster HP: " + monsterHP);
            System.out.println("Your HP: " + hp);
            System.out.println("Mana: " + mana);
            System.out.println("What do you do?");
            System.out.println("1. ATTACK");
            System.out.println("2. ITEM");

            userChoice = input.nextInt();

            switch(userChoice) {
                case 1:
                double overthinking = Math.random();
                    if (overthinking > 0.8) {
                        System.out.println("Your overthinking got the better of you, and you couldn't choose which spell to cast.");
                        break;

                    } else {
                        System.out.println("ATTACKS");
                        System.out.println("1. Flamethower Spell");
                        System.out.println("2. Lightning Strike");
                        System.out.println("3. Staff Bonk");

                        userChoice = input.nextInt();
                    
                        if (userChoice == 1) {
                            if (mana > 0) {
                            System.out.println("You aim the tip of your staff and spit flames at your foe!");
                            monsterHP -= 6;
                            mana -= 7;
                            System.out.println("Ooh, burn!");
                            } else {
                                System.out.println("Your mana runs low, you cannot cast any more spells!");
                            }
                        } else if (userChoice == 2) {
                            if (mana > 0) {
                            System.out.println("You point the tip of your staff to the sky and shoot a lighting bolt into the sky!");
                            System.out.println("It comes back crashing down onto your opponent with a ZZZAP!");
                            monsterHP -= 10;
                            mana -= 9;
                            } else {
                                System.out.println("Your mana runs low, you cannot cast any more spells!");
                            }
                        } else if (userChoice == 3) {
                            System.out.println("You swing your staff and knock your foe to the ground.");
                            monsterHP -= 5;
                        }
                    break;
                    }
                case 2:
                    System.out.println("ITEMS");
                    System.out.println("1. Health Potion x " + numHealthPotions);
                    System.out.println("2. Mana potions" + numManaPotions);
                    System.out.println("2. BACK");

                    userChoice = input.nextInt();

                    if (userChoice == 1) {
                        if (numHealthPotions > 0) {
                            numHealthPotions--;
                        System.out.println("Consumed 1 Health Potion. 35 HP restored.");
                        hp += 50;
                        } else {
                            System.out.println("You are out of Health Potions.");
                        }
                        
                    } else if (userChoice == 2) {
                        if (numManaPotions > 0) {
                            numManaPotions--;
                            System.out.println("Consumed 1 Mana Potion. 15 Mana restored.");
                            mana += 15;
                        } else {
                            System.out.println("You are out of Mana Potions.");
                        }
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
        System.out.println("");
        System.out.println("Running Knight pathway."); 

        hp = 150;

        numHealthPotions = 2;
        
        System.out.println("");

        System.out.println("You were once a respected knight in Roven Telia, but after a scandal with the princess, you were exiled.");
        System.out.println("To earn redemption, you were tasked with a suicide mission: slay the dragon at Poachers Peak.");
        System.out.println("Equipped with your sword and a few potions, you enter the dangerous forest.");

        System.out.println("As you march deeper, a trio of ICE goblins leap from the shadows, snarling and pointing at your gear.");
        fightCard();
        System.out.println("");
        System.out.println("~o~     *   *");
        System.out.println("/-\\ }->,|, *");
        System.out.println("        + /");
        System.out.println("");
        monsterIntro(3, "Goblins", 18);
        knightFightSequence();

        System.out.println("Victorious but bruised, you wipe off goblin blood and move forward through the dense woods.");
        System.out.println("Suddenly, two giant cockroaches creep out from the bushes, mandibles clicking hungrily.");
        fightCard();
        System.out.println("");
        System.out.println(" \\/  ");
        System.out.println("\\oo/ ");
        System.out.println("_||_ ");
        System.out.println(" ()");
        System.out.println("/  \\");
        System.out.println("");
        monsterIntro(2, "Giant Cockroaches", 20);
        knightFightSequence();

        System.out.println("You used up a lot of energy. You rest on a stone...");
        System.out.println("But there's no time to relax! Goblins riding cockroaches charge!");
        fightCard();
        monsterIntro(4, "Mounted Goblins", 25);
        knightFightSequence();

        System.out.println("You push forward, limbs sore. Suddenly, two woodland elves confront you.");
        System.out.println("They claim you're trespassing on sacred land.");
        fightCard();
        System.out.println("");
        System.out.println("^o^     *   *");
        System.out.println("/-\\ }->,|, *");
        System.out.println("        + /");
        System.out.println("");
        monsterIntro(2, "Woodland Elves", 18);
        knightFightSequence();

        System.out.println("You slump under a tree and rest. HP restored by 50.");
        hp += 50;

        System.out.println("At dawn, you reach Poachers Peak. A massive dragon roars overhead and lands before you.");
        fightCard();
        System.out.println("");
        System.out.println("  \\/ ");
        System.out.println(" \\00/ ");
        System.out.println("  ||");
        System.out.println("/ OO \\");
        System.out.println("VV  VV");
        System.out.println("");
        monsterIntro(1, "Dragon", 40);
        knightFightSequence();

        System.out.println("You've done the impossible. The dragon lies dead.");
        System.out.println("You return to Roven Telia a hero... but the people look away.");
        System.out.println("The King welcomes you, but the princess avoids your gaze.");
        System.out.println("You live in the shadows, a warrior turned beggar.");

    } //END OF KNIGHT STORY PATH

    //ARCHER STORY PATH ARCHER STORY PATH ARCHER STORY PATH ARCHER STORY PATH
    //V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V

    public static void runArcherStory() {
        System.out.println("Running Archer pathway...");

        hp = 80;

        fightCard();

        monsterIntro(3, "Goblins", 18);

        archerFightSequence();

    } // END OF ARCHER STORY PATH

    //MAGE STORY PATH MAGE STORY PATH MAGE STORY PATH MAGE STORY PATH MAGE STORY PATH
    //V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V V

    public static void runMageStory() {
        System.out.println("Running Mage pathway...");

        hp = 100;

        fightCard();

        monsterIntro(3, "Goblins", 18);

        mageFightSequence();
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
