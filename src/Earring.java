public class Earring implements Accessories {
    private int defenseIncrease;
    private int defenseDecrease;
    private boolean isBought;

    /**
     * Constructor for the Earring class.
     *
     * @param defenseIncrease The amount by which the shield defense will be increased
     */
    public Earring(int defenseIncrease) {
        this.defenseIncrease = defenseIncrease;
        defenseDecrease = defenseIncrease;
        this.isBought = false;
    }

    /**
     * Simulates the process of buying the earring.
     * effects: Can use Earring Effect.
     * effects: "Earring bought!" printed out.
     */
    @Override
    public void buy() {
        System.out.println("Earring bought!");
        isBought = true;
    }

    /**
     * Simulates the process of selling the earring.
     * effects: Can't use Earring Effect.
     * effects: "Earring sold!" printed out.
     */
    @Override
    public void sell() {
        System.out.println("Earring sold!");
        isBought = false;
    }

    /**
     * Increases the defense of the provided shield if the earring has been bought.
     * effects: "You need to buy the earring before using its effects." printed if Earring hadn't been bought.
     * @param shield The shield to which the defense increase will be applied
     */
    public void increaseShieldDefense(Shield shield) {
        if (isBought) {
            // Increase the defense of the provided shield
            shield.increaseDefense(defenseIncrease);
            System.out.println("Shield defense increased by " + defenseIncrease);
        } else {
            System.out.println("You need to buy the earring before using its effects.");
        }
    }

    /**
     * Decreases the defense of the provided shield.
     * @param shield The shield to which the defense decrease will be applied
     * effects: "Shield defense decreased by " printed out.
     */
    public void decreaseShieldDefense(Shield shield) {
        shield.decreaseDefense(defenseDecrease);
        System.out.println("Shield defense decreased by " + defenseDecrease);
    }
}
