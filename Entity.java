/**
 * The type Entity.
 */
public abstract class Entity {
  private String name;
  private int maxHp;
  private int hp;

  /**
   * Instantiates a new Entity.
   *
   * @param n   the name of the character
   * @param mHp the maximum hp of the character
   */
  public Entity(String n, int mHp) {
    name = n;
    maxHp = mHp;
    hp = mHp;
  }

  /**
   * attack - builds up an abstracts method
   *
   * @param e the entity
   * @return the string representation of the attack
   */
  public abstract String attack(Entity e);

  /**
   * Gets name.
   *
   * @return the name of the entity
   */
  public String getName() {
    return name;
  }

  /**
   * Gets hp.
   *
   * @return the hp of the entity
   */
  public int getHp() {
    return hp;
  }

  /**
   * Gets max hp.
   *
   * @return the max hp of the entity
   */
  public int getMaxHp() {
    return maxHp;
  }

  /**
   * heal - heal up the entity as needed
   *
   * @param h the amount of health that should be added
   */
  public void heal(int h) {
    hp += h;
    if (hp > maxHp) {
      hp = maxHp;
    }
  }

  /**
   * takeDamage - gives damage to the entity that is passed in
   *
   * @param d the amount of damage
   */
  public void takeDamage(int d) {
    hp -= d;
    if (hp < 0) {
      hp = 0;
    }
  }

  /**
   * toString - String representation of the name and health
   *
   * @return - String representation
   */
  public String toString() {
    return (name + "\nHP: " + hp + "/" + maxHp);
  }
}
