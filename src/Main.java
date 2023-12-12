// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Character a = new Character("Loki", 1, 8.0, new Archer());
        Character k = new Character("Arthur", 1, 6.0, new Knight());
        Character t = new Character("Robin", 1, 7.0, new Thief());
        Sword Ex = new Sword("Excalibur",40);
        Shield Cw = new Shield("ChinaWall",20);
        Accessories r = new Ring(5);
        Accessories e = new Earring(5);
        Accessories n = new Necklace(5);
        Accessories ta = new Talisman();
        a.equipSword(Ex);
        k.equipShield(Cw);
        System.out.println("----------------------------------");
        a.buyAccessory(r);
        k.buyAccessory(n);
        k.buyAccessory(ta);
        a.attack(k);
        System.out.println(k.hp);
        a.attack(k);
        System.out.println(k.hp);
        a.attack(k);
        System.out.println(k.hp);
        a.attack(k);
        System.out.println(k.hp);
        k.heal();
        System.out.println(k.hp);
        a.attack(k);
        System.out.println(k.hp);
        a.sellAccessory(r);
        k.sellAccessory(n);
    }
}
