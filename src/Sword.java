public class Sword {

    public double damage;
    public final String name;
    public int level = 1;

    /**
     * Constructs a new Sword with the specified name and base damage.
     * @param _name The name of the sword
     * @param baseDamage The base damage value of the sword
     */
    public Sword(String _name, int baseDamage) {
        name = _name;
        damage = baseDamage;
    }

    /**
     * Increases the level of the sword.
     * effects: Damage is updated based on the sword's level.
     */
    public void levelUp() {
        damage = damage * (1 + (0.1 * level));
    }

    /**
     * Increases the damage of the sword by the specified amount.
     * effects: Damage is updated from specified amount.
     * @param amount The amount by which to increase the damage
     */
    public void increaseDamage(int amount) {
        damage += amount;
    }

    /**
     * Decreases the damage of the sword by the specified amount.
     * @param amount The amount by which to decrease the damage
     */
    public void decreaseDamage(int amount) {
        damage = Math.max(0, damage - amount);
    }
}
