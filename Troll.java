/**
 * The type Troll.
 */
public class Troll extends Enemy {

  /**
   * Instantiates a new Troll.
   */
  public Troll() {
    super("Troll", 5);
  }

  /**
   * attack - Overrides the attack method.
   *
   * @param e - Entity that should be attacked
   * @return - String representation of the attack
   */
  @Override
  public String attack(Entity e) {
    int damageHp = (int) (Math.random() * 6); // Random: 0 - 5
    e.takeDamage(damageHp);
    return (this.getName() + " attacked " + e.getName() + " for " + damageHp + " damage.");
  }
}
