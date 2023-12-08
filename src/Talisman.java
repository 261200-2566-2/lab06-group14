public class Talisman implements Accessories {

    private boolean isBought;  // Flag indicating whether the talisman has been bought

    /**
     * Constructs a new Talisman.
     */
    public Talisman() {
        this.isBought = false;
    }

    /**
     * Simulates the process of buying the talisman.
     * effects: Can use Talisman Effect.
     * effects: "Earring bought!" printed out.
     *
     */
    @Override
    public void buy() {
        System.out.println("Talisman bought!");
        isBought = true;
    }

    /**
     * Simulates the process of selling the talisman.
     * effects: Can't use Talisman Effect.
     * effects: "Talisman sold!" printed out.
     */
    @Override
    public void sell() {
        System.out.println("Talisman sold!");
        isBought = false;
    }

    /**
     * A random healing effect on the provided character.
     * effects: "You need to buy the talisman before using its effects." printed if Talisman hadn't been bought.
     * @param character The character to be randomly healed
     */
    public void randomHeal(Character character) {
        if (isBought) {
            character.heal();
        } else {
            System.out.println("You need to buy the talisman before using its effects.");
        }
    }

    /**
     * Stops the random healing effect by from talisman.
     * effects: "No more heal effect by talisman." printed out.
     * @param character The character for whom the healing effects are stopped
     */
    public void stopRandomHeal(Character character) {
        isBought = false;
        System.out.println("No more heal effect by talisman.");
    }
}
