public class Archer implements Job {
    /**
     * Applies job-specific effects on the provided character.
     * effects: this character increases their damage.
     * @param character The character to which the job effects will be applied
     */
    @Override
    public void applyJobEffects(Character character) {
        character.damage += 5; // Increase character's damage by 5
        character.defaultDamage = character.damage; // Set default damage to the updated damage value
        character.defaultDefense = character.defense; // Set default defense to the current defense value
    }
}