import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Character {
    public String name;
    public int level;
    public double hp;
    public double mana;
    public double runSpeed;
    private final double defaultRunSpeed;
    public double maxHp;
    public double maxMana;
    public double maxRunSpeed;
    public boolean equippedTalisman;
    public Sword equippedSword;
    public Shield equippedShield;
    public double damage;
    public double defense;
    public double defaultDamage;
    public double defaultDefense;
    public Job job;

    /**
     * Increases the character's level and updates maximum HP, mana, and run speed.
     */
    public void levelUp() {
        level++;
        maxHp = 100+(10*level);
        maxMana = 50+(2*level);
        maxRunSpeed = runSpeed+(0.1+(0.03*level));

    }

    /**
     * Attacks the target character, dealing damage based on equipped sword and target's defense.
     * effects: target will receive damage based on equipped sword.
     * @param target The character to attack
     */
    public void attack(Character target) {
        double damageDealt = 0;
        if(equippedSword == null){
            System.out.println(name + " can't attack without a sword");
        }
        else {
            damageDealt += damage-target.defense;
        }

        target.hp -= damageDealt;
        if(target.hp <= 0) {
            System.out.println(target.name + " is now dead");
        }
    }

    /**
     * Initializes a character with a name, level, base run speed, and job.
     * @param _name         The name of the character
     * @param _level        The level of the character
     * @param _baseRunSpeed The base run speed of the character
     * @param job           The job of the character
     */
    public Character(String _name,int _level,double _baseRunSpeed,Job job){
        name = _name;
        level = _level;
        runSpeed = _baseRunSpeed;
        defaultRunSpeed = _baseRunSpeed;
        damage = 0;
        defense = 0;

        maxHp = 100+(10*level);
        hp = maxHp;
        maxMana = 50+(2*level);
        mana = maxMana;
        maxRunSpeed = runSpeed+(0.1+(0.03*level));
        initializeJob(job);
    }
    private void initializeJob(Job job) {
        this.job = job;
        job.applyJobEffects(this);
    }

    /**
     * Equips a sword.
     * effects: Updating run speed and damage.
     * @param sword The sword to be equipped
     */
    public void equipSword(Sword sword) {
        equippedSword = sword;
        runSpeed -= runSpeed * (0.1 + (0.04 * level));
        damage += sword.damage;
    }

    /**
     * Equips a shield.
     * effects: Updating run speed and defense.
     * @param shield The shield to be equipped
     */
    public void equipShield(Shield shield) {
        equippedShield = shield;
        runSpeed -= runSpeed * (0.1 + (0.06 * level));
        defense += shield.defense;
    }

    /**
     * Unequips a sword.
     * effects: Resetting run speed and damage.
     * @param sword The sword to be unequipped
     */
    public void unEquipSword(Sword sword){
        if(equippedSword == sword){
            equippedSword = null;
            damage -= sword.damage;
        }else{
            System.out.println(name+" hasn't equipped "+sword.name+" sword");
        }
        runSpeed = defaultRunSpeed;
    }

    /**
     * Unequips a shield.
     * effects: Resetting run speed and defense.
     * @param shield The shield to be unequipped
     */
    public void unEquipShield(Shield shield){
        if(equippedShield == shield){
            equippedShield = null;
            defense -= shield.defense;
        }else{
            System.out.println(name+" hasn't equipped "+shield.name+" shield");
        }
        runSpeed = defaultRunSpeed;
    }

    //effect of Necklace
    /**
     * Increases the maximum HP of the character.
     * effects: Increases the maximum HP and hp of the character.
     * @param amount The amount to increase the maximum HP
     */
    public void increaseMaxHp(int amount) {
        maxHp += amount;
        hp = Math.min(hp + amount, maxHp); // Ensure current HP does not exceed the new max HP
    }
    //effect of Necklace
    /**
     * Decreases the maximum HP of the character.
     * effects: Decreases the maximum HP and hp of the character.
     * @param amount The amount to decrease the maximum HP
     */
    public void decreaseMaxHp(int amount) {
        maxHp -= amount;
        hp = Math.min(hp - amount, maxHp); // Ensure current HP does not exceed the new max HP
    }
    //effect of Talisman
    /**
     * Heals the character's HP using a random amount if a talisman is equipped.
     */
    public void heal() {
        Random rand = new Random();
        int healAmount = rand.nextInt(11) + 10; // Random heal between 1 and 20
        if(equippedTalisman){
            hp = Math.min(maxHp, hp + healAmount);
            System.out.println(name + " healed for " + healAmount + " HP.");
        }else{
            System.out.println("You need to buy the talisman before using its effects.");
        }
    }
    private List<Accessories> accessoriesList = new ArrayList<>();
    // Method to buy an accessory
    /**
     * Buys an accessory.
     * effects: Adds accessory to the character's accessories list.
     * @param accessory The accessory to buy
     */
    public void buyAccessory(Accessories accessory) {
        accessory.buy();
        accessoriesList.add(accessory);
        applyAccessoryEffects();
    }

    // Method to sell an accessory
    /**
     * Sells an accessory.
     * effects: Removes accessory from the character's accessories list, and applies effects.
     * @param accessory The accessory to sell
     */
    public void sellAccessory(Accessories accessory) {
        accessory.sell();
        accessoriesList.remove(accessory);
        if(accessory instanceof Ring){
            ((Ring) accessory).decreaseSwordDamage(equippedSword);
        } else if (accessory instanceof Earring) {
            ((Earring) accessory).decreaseShieldDefense(equippedShield);
        } else if (accessory instanceof Necklace) {
            ((Necklace) accessory).decreaseMaxHp(this);
        }  else if (accessory instanceof Talisman) {
            ((Talisman) accessory).stopRandomHeal(this);
            equippedTalisman = false;
        }
        applyAccessoryEffects();
    }

    // Apply effects of all accessories
    /**
     * Applies the effects of all accessories equipped by the character.
     */
    private void applyAccessoryEffects() {
        resetStats(); // Reset stats to the base values

        for (Accessories accessory : accessoriesList) {
            if (accessory instanceof Ring) {
                ((Ring) accessory).increaseSwordDamage(equippedSword);
                damage = defaultDamage + equippedSword.damage;
            } else if (accessory instanceof Earring) {
                ((Earring) accessory).increaseShieldDefense(equippedShield);
                defense = defaultDefense + equippedShield.defense;
            } else if (accessory instanceof Necklace) {
                ((Necklace) accessory).increaseMaxHp(this);
            } else if (accessory instanceof Talisman) {
                ((Talisman) accessory).randomHeal(this);
                equippedTalisman = true;
            }
        }
    }

    // Reset stats to base values
    /**
     * Reset the effects of all accessories equipped by the character.
     */
    private void resetStats() {
        // Reset character stats to base values before applying accessory effects
        // You may want to keep track of base stats separately for proper resetting
        if(equippedShield == null && equippedSword == null){
            damage = defaultDamage;
            defense = defaultDefense;
        }else if(equippedShield == null){
            damage = equippedSword.damage + defaultDamage;
            defense = defaultDefense;
        }else if(equippedSword == null){
            damage = defaultDamage;
            defense = equippedShield.defense + defaultDefense;
        }else {
            damage = equippedSword.damage + defaultDamage;
            defense = equippedShield.defense + defaultDefense;
        }
        // Reset other stats as needed
    }
}
