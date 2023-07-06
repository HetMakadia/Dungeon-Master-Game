/** The type Warrior. */
public class Warrior extends EnemyDecorator {

  /**
   * Instantiates a new Warrior.
   *
   * @param e the e
   */
  public Warrior(Enemy e) {
    super(e, e.getName(), e.getMaxHp() + 2);
  }

  /**
   * attack - randomly selects one of the three power attacks
   *
   * @param e - Entity that should be attacked
   * @return - String representation of the attack
   */
  @Override
  public String attack(Entity e) {
    int damageHp = (int) (Math.random() * 3) + 1; // Random: 1 - 3
    e.takeDamage(damageHp);
    return super.attack(e) + "\n" + (this.getName() + " attacked " + e.getName() + " for " + damageHp + " damage.");
  }

  /**
   * getName - returns the updated name of the powerful warlock enemy
   *
   * @return - String name
   */
  public String getName() {
    if (super.getName().contains("Warrior")) {
      return super.getName() + "-X-Warrior";
    } else {
      return super.getName() + " Warrior";
    }
  }

  /**
   * getHp - provide the hp of the warlock enemy
   *
   * @return - hp
   */
  public int getHp() {
    return super.getHp();
  }
}
