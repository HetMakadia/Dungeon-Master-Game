/**
 *  The type Enemy. 
*/
public abstract class Enemy extends Entity {

  /**
   *  Instantiates a new Enemy.
   *
   *  @param n the name of the enemy
   *  @param mHp the maximum hp of the enemy
  */
  public Enemy(String n, int mHp) {
    super(n, mHp);
  }

  /**
   *  attack - Overrides the attack method.
   *
   *  @param e - Entity that should be attacked
   *  @return - String representation of the attack
  */
  @Override
  public String attack(Entity e) {
    int damageHp = (int) (Math.random() * 5) + 1; // Random: 1 - 5
    e.takeDamage(damageHp);
    return (this.getName() + " attacked " + e.getName() + " for " + damageHp + " damage.");
  }
}
