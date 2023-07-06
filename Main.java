/**
 * CECS 277 Project 2
 * <p>
 * GROUP 10 : Het Makadia, Phiona Nicole Tumbaga, Jayvee Lou Henzon
 * <p>
 * REPLIT LINK : https://replit.com/@HetMakadia/Project2-277
 * <p>
 * ABOUT PROJECT : This program builds up an game for the user. First it builds
 * an hero (user) and load up the map to the user. At first the hero (user) will
 * be at the start point on the map. User then allowed to move in all four
 * directions in the map. User will not allowed to move out of the map. When
 * moving in different directions user will find health potion, monster, a store
 * at the start or a finish point that requires key. User can get some gold when
 * they defeat monster and that gold can be used in store User may find nothing
 * at some locations. Upon finding the monster, the user will be able to fight
 * wil different attacks or run away. User will come across tha monster again if
 * they run away at that position. If the user reaches the finish point, the
 * level will be proceeded if the user has key and a new map will be loaded. All
 * the inputs are checked and validated.
 */
class Main {
  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    char letter = ' ';

    // generates the enemy
    EnemyGenerator genEnemy = new EnemyGenerator();

    // asks use for their name
    System.out.print("\nWhat is your name, traveler? ");
    String name = CheckInput.getString();

    // creates the hero
    Hero mainCharacter = new Hero(name);
    boolean run = true;

    // loops as long as the hero is still in game
    while (run) {
      // printing out the user info, map and the asking user to move in a direction
      System.out.println(mainCharacter.toString());
      System.out.println("1. Go North \n2. Go South \n3. Go East \n4. Go West \n5. Quit");
      int selection = CheckInput.getIntRange(1, 5);
      System.out.println();
      // moving the hero as per the user's choice
      switch (selection) {
        case 1:
          letter = mainCharacter.goNorth();
          break;
        case 2:
          letter = mainCharacter.goSouth();
          break;
        case 3:
          letter = mainCharacter.goEast();
          break;
        case 4:
          letter = mainCharacter.goWest();
          break;
        case 5: {
          System.out.println("Game Over");
          run = false;
          break;
        }
      }
      Map.getInstance().reveal(mainCharacter.getLoc());
      // if the hero is in the game
      if (run) {
        if (letter == 'x') {
          // Cannot move outside the box
          System.out.println("Location was out of bounds");

        } else if (letter == 'n') {
          // Some location have nothing there
          System.out.println("There was nothing here.");

        } else if (letter == 's') {
          // if the user reaches at the start
          System.out.println("You are back at the start.");
          System.out.println("1. Visit Store \n2. Move on");
          int visitStore = CheckInput.getIntRange(1, 2);
          while (visitStore != 2) {
            if (visitStore == 1) {
              store(mainCharacter);
            }
            System.out.println("1. Visit Store \n2. Move on");
            visitStore = CheckInput.getIntRange(1, 2);
          }

        } else if (letter == 'f') {
          if (mainCharacter.hasKey()) {
            // when the user reaches the end, has the key and increase in the level
            mainCharacter.useKey();
            mainCharacter.levelUp();
            System.out.println("You found the exit. Proceeding to the next level....");
          } else {
            System.out.println("You don't have Dungeon key to unlock the door for next adventure.");
          }

        } else if (letter == 'i') {
          // when the user found potion for healing up
          System.out.println("You found a Health Potion!  You drink it to restore your health.");
          mainCharacter.heal(25);
          Map.getInstance().removeCharAtLoc(mainCharacter.getLoc());
          // 2 in 5 chance of getting key in the health potion room
          int randomKey = ((int) (Math.random() * 5));
          if ((randomKey == 1) || (randomKey == 3)) {
            System.out.println("You found a Dungeon Key.");
            mainCharacter.pickUpKey();
          }

        } else if (letter == 'm') {
          genEnemy = new EnemyGenerator();
          run = monsterRoom(mainCharacter, genEnemy.generateEnemy(mainCharacter.getLevel()));
        }
      }
      System.out.println();
    }
  }

  /**
   * monsterRoom - describes the situation when hero comes across the monster
   *
   * @param h the hero
   * @param e the enemy - monster
   * @return the boolean - true if the hero is alive
   */
  public static boolean monsterRoom(Hero h, Enemy e) {
    boolean continueFight = true;
    boolean alive = true;
    char letter = ' ';

    // Introducing the enemy to the user
    System.out.println();
    System.out.println("You have encountered a " + e.getName());

    // while the fight goes on and both are alive
    while (continueFight && e.getHp() > 0) {
      // Printing out the monster info.
      System.out.println("\n" + e.getName() + "\nHP: " + e.getHp() + "/" + e.getMaxHp());
      System.out.println();
      // Asking user either to fight or run away.
      System.out.println("1. Fight \n2. Run Away");
      int choice = CheckInput.getIntRange(1, 2);
      if (choice == 1) {
        // when user chooses to fight
        alive = fight(h, e);
        if (!alive) {
          return alive;
        }
      } else {
        // when the user choose to run away.
        int randomMove = (int) (Math.random() * 4); // Random: 0-3

        switch (randomMove) {
          case 0:
            letter = h.goNorth();
            break;
          case 1:
            letter = h.goSouth();
            break;
          case 2:
            letter = h.goEast();
            break;
          case 3:
            letter = h.goWest();
            break;
        }
        Map.getInstance().reveal(h.getLoc());
        if (letter == 'x') {
          // Cannot move outside the box
          System.out.println("Location was out of bounds");
        } else if (letter == 'n') {
          // Some location have nothing there
          System.out.println("There was nothing here.");
        } else if (letter == 's') {
          // if the user reaches at the start
          System.out.println("You are back at the start. \n1. Visit Store \n2. Move on");
          int visitStore = CheckInput.getIntRange(1, 2);
          while (visitStore != 2) {
            if (visitStore == 1) {
              store(h);
            }
            System.out.println("1. Visit Store \n2. Move on");
            visitStore = CheckInput.getIntRange(1, 2);
          }
        } else if (letter == 'f') {
          if (h.hasKey()) {
            // when the user reaches the end, has the key and increase in the level
            h.useKey();
            h.levelUp();
            System.out.println("You found the exit.  Proceeding to the \nnext level.");
          } else {
            System.out.println("You don't have key to unlock the door for next level.");
          }
        } else if (letter == 'i') {
          // when the user found potion for healing up
          System.out.println("You found a Health Potion!  You drink it \nto restore your health.");
          h.heal(25);
          Map.getInstance().removeCharAtLoc(h.getLoc());
          // 2 in 5 chance of getting key in the health potion room
          int randomKey = ((int) (Math.random() * 5));
          if ((randomKey == 1) || (randomKey == 3)) {
            System.out.println("You found a Dungeon Key.");
            h.pickUpKey();
          }
        }
        System.out.println();
        continueFight = false;
      }
    }
    return alive;
  }

  /**
   * fight - ask user to choose the attack that they want to do to enemy
   *
   * @param h the hero
   * @param e the enemy - monster
   * @return the boolean - true if the the monster dies
   */
  public static boolean fight(Hero h, Enemy e) {
    // Asking user for either physical attack or magic attack
    System.out.println("1. Physical Attack \n2. Magic Attack");
    int attackType = CheckInput.getIntRange(1, 2);

    if (attackType == 1) {
      // if the user choose for physical attack
      System.out.println(h.attack(e));
    } else {
      // if the user choose for magical attack, then asking user to select one of
      // three types.
      System.out.println(Magical.MAGIC_MENU);
      int magicAttack = CheckInput.getIntRange(1, 3);
      if (magicAttack == 1) {
        System.out.println(h.magicMissile(e));
      } else if (magicAttack == 2) {
        System.out.println(h.fireball(e));
      } else
        System.out.println(h.thunderclap(e));
    }
    System.out.println();
    if (e.getHp() > 0) {
      // if the monster is still alive, it will attack back
      System.out.println(e.attack(h));
    }

    if (h.getHp() > 0) {
      // if the hero is still alive then return true.
      if (e.getHp() == 0) {
        Map.getInstance().removeCharAtLoc(h.getLoc());
        System.out.println("You defeated the monster.");
        h.collectGold((int) (Math.random() * 8) + 3);
      }
      return true;
    } else {
      // if the user dies then the game is finished.
      System.out.println(h.getName() + " was defeated by " + e.getName());
      System.out.println("Game Over");
      return false;
    }
  }

  /**
   * store - builds up the store in which hero can buy health potion or key
   *
   * @param h the hero
   */
  public static void store(Hero h) {
    System.out.println("Welcome to the store.");
    System.out.println("Please select an item to purchase.");
    System.out.println("1. Health Potion (25 gold) \n2. Key (50 gold)");
    int storeChoice = CheckInput.getIntRange(1, 2);
    if (storeChoice == 1) {
      if (h.getGold() >= 25) {
        h.heal(h.getMaxHp());
        h.spendGold(25);
        System.out.println("You have successfully purchased health potion for 25 gold. You drink it. \n");
      } else {
        System.out.println("You cannot afford health potion at this time. \n");
      }
    } else if (storeChoice == 2) {
      if (h.getGold() >= 50) {
        h.pickUpKey();
        h.spendGold(50);
        System.out.println("You have successfully purchased Dungeon key for 50 gold. \n");
      } else {
        System.out.println("You cannot afford key at this time. \n");
      }
    }
    System.out.println("Thanks for visiting the store. Please visit again. \n");
  }
}
