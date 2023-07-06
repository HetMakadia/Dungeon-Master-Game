/** The type Warlock. */
public class Warlock extends EnemyDecorator implements Magical {
  /**
   * Instantiates a new Warlock.
   *
   * @param e the enemy
   */
  public Warlock(Enemy e) {
    super(e, e.getName(), e.getMaxHp() + 1);
  }

  /**
   * attack - randomly selects one of the three power attacks
   *
   * @param e - Entity that should be attacked
   * @return - String representation of the attack
   */
  @Override
  public String attack(Entity e) {
    int randAttack = (int) (Math.random() * 3) + 1; // Random: 1 - 3
    if (randAttack == 1) {
      return super.attack(e)  + "\n" + this.magicMissile(e);
    } else if (randAttack == 2) {
      return super.attack(e) + "\n" + this.fireball(e);
    } else if (randAttack == 3) {
      return super.attack(e) + "\n" + this.thunderclap(e);
    } else {
      return "Problem in Warlock Attack.";
    }
  }

  /**
   * getName - returns the updated name of the powerful warlock enemy
   *
   * @return - String name
   */
  public String getName() {
    if (super.getName().contains("Warlock")) {
      return super.getName() + "-X-Warlock";
    } else {
      return super.getName() + " Warlock";
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

  /**
   * magicMissile - Powerful magicMissile attack by the warlock
   *
   * @param e - entity that should be attack
   * @return - String representation of the attack
   */
  @Override
  public String magicMissile(Entity e) {
    int damageHp = (int) (Math.random() * 3); // Random: 0 - 2
    e.takeDamage(damageHp);
    return (this.getName() + " hits " + e.getName() + " with Magical Missile \nfor " + damageHp + " damage.");
  }

  /**
   * fireball - Powerful fireball attack by the warlock
   *
   * @param e - entity that should be attack
   * @return - String representation of the attack
   */
  @Override
  public String fireball(Entity e) {
    int damageHp = (int) (Math.random() * 4); // Random: 0 - 3
    e.takeDamage(damageHp);
    return (this.getName() + " blasts " + e.getName() + " with a fireball \nfor " + damageHp + " damage.");
  }

  /**
   * thunderclap - Powerful thunderclap attack by the warlock
   *
   * @param e - entity that should be attack
   * @return - String representation of the attack
   */
  @Override
  public String thunderclap(Entity e) {
    int damageHp = (int) (Math.random() * 3) + 1; // Random: 1 - 3
    e.takeDamage(damageHp);
    return (this.getName() + " zaps " + e.getName() + " with a thunderclap \nfor " + damageHp + " damage.");
  }
}
