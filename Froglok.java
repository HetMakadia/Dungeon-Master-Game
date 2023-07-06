/**
 * The type Froglok.
 */
public class Froglok extends Enemy {

  /**
   * Instantiates a new Froglok.
   */
  public Froglok() {
    super("Froglok", 3);
  }

  /**
   * attack - Overrides the attack method.
   *
   * @param e - Entity that should be attacked
   * @return - String representation of the attack
   */
  @Override
  public String attack(Entity e) {
    int damageHp = (int) (Math.random() * 3) + 1; // Random: 1 - 3
    e.takeDamage(damageHp);
    return (this.getName() + " attacked " + e.getName() + " for " + damageHp + " damage.");
  }
}
