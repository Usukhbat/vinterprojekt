import java.util.Random;
import java.util.Scanner;
public class WinterProject{
    static Characters player = new Characters("ben");
    static Characters villain = new Characters("Loki");
    static Melee oneSword = new Melee("Short Sword");
    static Melee twoSword = new Melee("Long Sword");
    static Loot plusStrength = new Loot("Red Crystal");
    static Loot plusHealth = new Loot("Green Crystal");
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Dungeon of Ben");
        boolean runGame = true;
        while (runGame){
            System.out.println("[Main Menu]\n1. Fight\n2. Check Inventory\n3. Player Info\n4. Exit Game");
            int menu = scan.nextInt();
            switch (menu) {
                case 1 -> {
                    while (player.health > 0 && villain.health > 0) {
                        villain.dealDamage(oneSword.getDamage(), player.getName());
                        player.dealDamage(twoSword.getDamage(), villain.getName());
                        System.out.println(player.getName() + ": " + player.getHealth());
                        System.out.println(villain.getName() + ": " + villain.getHealth());
                    }
                    if (villain.health <= 0) {
                        int chance = random.nextInt(10);
                        player.dropLoot(chance, plusHealth.getName(), plusStrength.getName());
                    } else {
                        player.loss();
                    }
                }
                case 2 -> {
                    player.checkInventory();
                    player.useItem();
                    player.inventoryReset();
                }
                case 3 -> player.checkStats();
                case 4 -> {
                    System.out.println("Good bye!");
                    runGame = false;
                }
            }
        }
    }
}

