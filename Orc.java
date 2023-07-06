/**
 * The type Orc.
 */
public class Orc extends Enemy {

  /**
   * Instantiates a new Orc.
   */
  public Orc() {
    super("Orc", 4);
  }

  /**
   * attack - Overrides the attack method.
   *
   * @param e - Entity that should be attacked
   * @return - String representation of the attack
   */
  @Override
  public String attack(Entity e) {
    int damageHp = (int) (Math.random() * 5); // Random: 0 - 4
    e.takeDamage(damageHp);
    return (this.getName() + " attacked " + e.getName() + " for " + damageHp + " damage.");
  }
}
