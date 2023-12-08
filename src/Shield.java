public class Shield {

    public double defense;
    public final String name;
    public int level = 1;

    /**
     * Constructs a new Shield with the specified name and base defense.
     * @param _name The name of the shield
     * @param baseDefense The base defense value of the shield
     */
    public Shield(String _name, int baseDefense) {
        name = _name;
        defense = baseDefense;
    }

    /**
     * Increases the level of the shield.
     * effects: Defense is updated based on the shield's level.
     */
    public void levelUp() {
        defense = defense * (1 + (0.05 * level));
    }

    /**
     * Increases the defense of the shield by the specified amount.
     * effects: Defense is updated from specified amount.
     * @param amount The amount by which to increase the defense
     */
    public void increaseDefense(int amount) {
        defense += amount;
    }

    /**
     * Decreases the defense of the shield by the specified amount.
     * @param amount The amount by which to decrease the defense
     */
    public void decreaseDefense(int amount) {
        defense = Math.max(0, defense - amount);
    }
}
