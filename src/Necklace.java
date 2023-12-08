public class Necklace implements Accessories {

    private int maxHpIncrease;
    private int maxHpDecrease;
    private boolean isBought;

    /**
     * Constructs a new Necklace with the specified maximum HP increase.
     *
     * @param maxHpIncrease The amount by which the maximum HP increases when the necklace is worn
     */
    public Necklace(int maxHpIncrease) {
        this.maxHpIncrease = maxHpIncrease;
        this.maxHpDecrease = maxHpIncrease;  // Initial decrease amount is set to the increase amount
        this.isBought = false;
    }

    /**
     * Simulates the process of buying the necklace.
     * effects: Can use Necklace Effect.
     * effects: "Necklace bought!" printed out.
     */
    @Override
    public void buy() {
        System.out.println("Necklace bought!");
        isBought = true;
    }

    /**
     * Simulates the process of selling the necklace.
     * effects: Can't use Necklace Effect.
     * effects: "Necklace sold!" printed out.
     */
    @Override
    public void sell() {
        System.out.println("Necklace sold!");
        isBought = false;
    }

    /**
     * Increases the maximum HP of the provided character.
     * effects: "You need to buy the necklace before using its effects." printed if Necklace hadn't been bought.
     * @param character The character wearing the necklace
     */
    public void increaseMaxHp(Character character) {
        if (isBought) {
            character.increaseMaxHp(maxHpIncrease);
            System.out.println("Max HP increased by " + maxHpIncrease);
        } else {
            System.out.println("You need to buy the necklace before using its effects.");
        }
    }

    /**
     * Decreases the maximum HP of the provided character.
     * @param character The character from whom the necklace is removed
     * effects: "Max HP decreased by " printed out.
     */
    public void decreaseMaxHp(Character character) {
        character.decreaseMaxHp(maxHpDecrease);
        System.out.println("Max HP decreased by " + maxHpIncrease);
    }
}
