/**
 * The type Hero.
 */
public class Hero extends Entity implements Magical {

  private Point loc;
  private int level = 1;
  private int gold;
  private int key;

  /**
   * Constructor - Builds an hero(user) with the help of super class entity, set
   * the instance of the map and find the start location of the hero on the map
   *
   * @param n - name
   */
  public Hero(String n) {
    super(n, 25);
    Map.getInstance().loadMap(level);
    loc = new Point(Map.getInstance().findStart().x, Map.getInstance().findStart().y);
  }

  /**
   * levelUp - increase the level, then load the new map and show the start
   * location.
   */
  public void levelUp() {
    level += 1;
    int newLevel = level % 3;
    Map.getInstance().loadMap(newLevel);
    Map.getInstance().reveal(loc);
  }

  /**
   * getLevel - provides the current level of the map
   *
   * @return - level
   */
  public int getLevel() {
    return this.level;
  }

  /**
   * goNorth - move one step in the north direction
   *
   * @return - character at new location.
   */
  public char goNorth() {
    if (loc.x > 0) {
      loc.x -= 1;
      return Map.getInstance().getCharAtLoc(loc);
    }
    return 'x';
  }

  /**
   * goSouth - move one step in the south direction
   *
   * @return - character at new location.
   */
  public char goSouth() {
    if (loc.x < 4) {
      loc.x += 1;
      return Map.getInstance().getCharAtLoc(loc);
    }
    return 'x';
  }

  /**
   * goWest - move one step in the west direction
   *
   * @return - character at new location.
   */
  public char goWest() {
    if (loc.y > 0) {
      loc.y -= 1;
      return Map.getInstance().getCharAtLoc(loc);
    }
    return 'x';
  }

  /**
   * goEast - move one step in the east direction
   *
   * @return - character at new location.
   */
  public char goEast() {
    if (loc.y < 4) {
      loc.y += 1;
      return Map.getInstance().getCharAtLoc(loc);
    }
    return 'x';
  }

  /**
   * getLevel - provides the current location of the hero
   *
   * @return - point - location
   */
  public Point getLoc() {
    return this.loc;
  }

  /**
   * getLevel - provides the current amount of gold with hero
   *
   * @return - level
   */
  public int getGold() {
    return gold;
  }

  /**
   * getLevel - increment the gold of the hero as parameter
   *
   * @param g the g
   */
  public void collectGold(int g) {
    gold += g;
  }

  /**
   * getLevel - decrement the gold of the hero as parameter
   *
   * @param g the g
   */
  public void spendGold(int g) {
    gold -= g;
  }

  /**
   * Has key boolean.
   *
   * @return the boolean
   */
  public boolean hasKey() {
    return key > 0;
  }

  /**
   * Pick up key.
   */
  public void pickUpKey() {
    key += 1;
  }

  /**
   * Use key boolean.
   *
   * @return the boolean
   */
  public boolean useKey() {
    if (key > 0) {
      key -= 1;
      return true;
    } else {
      return false;
    }
  }

  /**
   * toString - String representation of the
   *
   * @return - String representation of the profile
   */
  @Override
  public String toString() {
    return (super.toString() + " \nGold: " + this.getGold() + " \nKeys Status: " + this.hasKey() + "\n \n   Level: "
        + level + Map.getInstance().mapToString(loc));
  }

  /**
   * attack - randomly selects the amount of damage to be done on enemy
   *
   * @param e - Entity that should be attacked
   * @return - String representation of the attack
   */
  @Override
  public String attack(Entity e) {
    int damageHp = (int) (Math.random() * 2) + 1; // Random: 1 - 2
    e.takeDamage(damageHp);
    return (this.getName() + " attacked " + e.getName() + " for " + damageHp + " damage.");
  }

  /**
   * magicMissile - Powerful magicMissile attack by the hero
   *
   * @param e - entity that should be attack
   * @return - String representation of the attack
   */
  @Override
  public String magicMissile(Entity e) {
    int damageHp = (int) (Math.random() * 3) + 1; // Random: 1 - 3
    e.takeDamage(damageHp);
    return (this.getName() + " hits " + e.getName() + " with Magical Missile \nfor " + damageHp + " damage.");
  }

  /**
   * fireball - Powerful fireball attack by the hero
   *
   * @param e - entity that should be attack
   * @return - String representation of the attack
   */
  @Override
  public String fireball(Entity e) {
    int damageHp = (int) (Math.random() * 4) + 1; // Random: 1 - 4
    e.takeDamage(damageHp);
    return (this.getName() + " hits " + e.getName() + " with a fireball \nfor " + damageHp + " damage.");
  }

  /**
   * thunderclap - Powerful thunderclap attack by the hero
   *
   * @param e - entity that should be attack
   * @return - String representation of the attack
   */
  @Override
  public String thunderclap(Entity e) {
    int damageHp = (int) (Math.random() * 5) + 1; // Random: 1 - 5
    e.takeDamage(damageHp);
    return (this.getName() + " hits " + e.getName() + " with a thunderclap \nfor " + damageHp + " damage.");
  }
}
