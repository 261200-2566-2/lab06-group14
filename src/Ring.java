public class Ring implements Accessories {

    private int damageIncrease;
    private int damageDecrease;
    private boolean isBought;

    /**
     * Constructs a new Ring with the specified damage increase.
     *
     * @param damageIncrease The amount by which the sword damage increases when the ring is worn
     */
    public Ring(int damageIncrease) {
        this.damageIncrease = damageIncrease;
        this.damageDecrease = damageIncrease;
        this.isBought = false;
    }

    /**
     * Simulates the process of buying the ring.
     * effects: Can use Ring Effect.
     * effects: "Ring bought!" printed out.
     */
    @Override
    public void buy() {
        System.out.println("Ring bought!");
        isBought = true;
    }

    /**
     * Simulates the process of selling the ring.
     * effects: Can't use Ring Effect.
     * effects: "Ring sold!" printed out.
     */
    @Override
    public void sell() {
        System.out.println("Ring sold!");
        isBought = false;
    }

    /**
     * Increases the damage of the provided sword.
     * effects: "You need to buy the ring before using its effects." printed if Ring hadn't been bought.
     * @param sword The sword affected by the ring
     */
    public void increaseSwordDamage(Sword sword) {
        if (isBought) {
            sword.increaseDamage(damageIncrease);
            System.out.println("Sword damage increased by " + damageIncrease);
        } else {
            System.out.println("You need to buy the ring before using its effects.");
        }
    }

    /**
     * Decreases the damage of the provided sword.
     * @param sword The sword from which the ring is removed
     * effects: "Sword damage decreased by " printed out.
     */
    public void decreaseSwordDamage(Sword sword) {
        sword.decreaseDamage(damageDecrease);
        System.out.println("Sword damage decreased by " + damageDecrease);
    }
}
