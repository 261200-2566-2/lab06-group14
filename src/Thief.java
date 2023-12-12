public class Thief implements Job {

    /**
     * Applies job-specific effects on the provided character.
     * effects: this character increases run speed, maximum run speed, and maximum HP.
     * @param character The character to apply job effects on
     */
    @Override
    public void applyJobEffects(Character character) {
        character.runSpeed += 2;
        character.maxRunSpeed += 2;
        character.maxHp += 20;
        character.hp = character.maxHp;  // Resetting current HP to the new maximum
        character.defaultDamage = character.damage;
        character.defaultDefense = character.defense;
    }
}
