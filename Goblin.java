/**
 * The type Goblin.
 */
public class Goblin extends Enemy {

  /**
   * Instantiates a new Goblin.
   */
  public Goblin() {
    super("Goblin", 2);
  }

  /**
   * attack - Overrides the attack method.
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
}
