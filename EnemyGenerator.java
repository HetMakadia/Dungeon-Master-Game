/**
 * The type Enemy generator.
 */
public class EnemyGenerator {

  private Enemy ene;

  /**
   * Constructor - Instantiates a new Enemy generator. Randomly selects an enemy
   * from four enemy bases
   */
  public EnemyGenerator() {
    int randomEnemy = (int) (Math.random() * 4); // Random: 0 - 3

    if (randomEnemy == 0) {
      ene = new Orc();
    } else if (randomEnemy == 1) {
      ene = new Troll();
    } else if (randomEnemy == 2) {
      ene = new Froglok();
    } else if (randomEnemy == 3) {
      ene = new Goblin();
    }
  }

  /**
   * generateEnemy - Builds up the power of the enemy as per the level that hero
   * is in.
   *
   * @param level the level
   * @return the enemy
   */
  public Enemy generateEnemy(int level) {
    if (level == 1) {
      return ene;
    } else {

      int randomDec = (int) (Math.random() * 2); // Random: 0 - 1
      if (randomDec == 0) {
        for (int i = 1; i < level; i++) {
          ene = new Warrior(ene);
        }
      } else if (randomDec == 1) {
        for (int i = 1; i < level; i++) {
          ene = new Warlock(ene);
        }
      }
    }
    return ene;
  }
}
