/**
 * The interface Magical.
 */
public interface Magical {

  /**
   * The constant MAGIC_MENU.
   */
  public static final String MAGIC_MENU = ("1. Magic Missile \n2. Fireball \n3. Thunderclap");

  /**
   * Magic missile string.
   *
   * @param e the entity that should be attacked
   * @return the string
   */
  public String magicMissile(Entity e);

  /**
   * Fireball string.
   *
   * @param e the entity that should be attacked
   * @return the string
   */
  public String fireball(Entity e);

  /**
   * Thunderclap string.
   *
   * @param e the entity that should be attacked
   * @return the string
   */
  public String thunderclap(Entity e);
}
