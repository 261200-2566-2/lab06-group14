public class Knight implements Job {
    /**
     * Applies job-specific effects on the provided character.
     * effects: this character increases their defense.
     * @param character The character to which the job effects will be applied
     */
    @Override
    public void applyJobEffects(Character character) {
        character.defense += 5; // Increase character's defense by 5
        character.defaultDamage = character.damage; // Set default damage to the current damage value
        character.defaultDefense = character.defense; // Set default defense to the updated defense value
    }
}
