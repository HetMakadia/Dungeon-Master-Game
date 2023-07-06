/**
 * The type Enemy decorator.
 */
public abstract class EnemyDecorator extends Enemy {

  private Enemy enemy;

  /**
   * Instantiates a new Enemy decorator.
   *
   * @param e   the enemy that should be decorated
   * @param n   the name of the enemy that should be decorated
   * @param mHp the maximum hp of the enemy that should be decorated
   */
  public EnemyDecorator(Enemy e, String n, int mHp) {
    super(n, mHp);
    enemy = e;
  }

  /**
   * attack - Overrides the attack method.
   *
   * @param e - Entity that should be attacked
   * @return - String representation of the attack
   */
  public String attack(Entity e) {
    return enemy.attack(e);
  }
}
