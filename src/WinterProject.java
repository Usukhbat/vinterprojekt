import java.util.Random;
import java.util.Scanner;
public class WinterProject{
    static Goblin goblin = new Goblin("Goblin", 20);
    static Monsters twoMonster = new Monsters("Skeleton", 20);
    static Monsters threeMonster = new Monsters("Rat", 20);
    static Monsters fourMonster = new Monsters("Zombie", 20);
    static Monsters fiveMonster = new Monsters("Wolf", 20);
    static Melee oneSword = new Melee("Wooden Sword");
    static Melee twoSword = new Melee("Long Sword");
    static Loot plusStrength = new Loot("Red Crystal");
    static Loot plusHealth = new Loot("Green Crystal");
    static Armor oneArmor = new Armor("Leather Armor");
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Dungeon of Ben\nYour name: ");
        String playerName = scan.nextLine();
        Characters player = new Characters(playerName, 30);
        boolean runGame = true;
        while (runGame){
            System.out.println("[Main Menu]\n1. Fight\n2. Check Inventory\n3. Player Info\n4. Exit Game");
            int menu = scan.nextInt();
            switch (menu) {
                case 1 -> {
                    while (player.health > 0 && goblin.health > 0) {
                        oneSword.setDamage();
                        twoSword.setDamage();
                        goblin.dealDamage(oneSword.getDamage(), player.getName());
                        goblin.makeSound();
                        player.dealDamage(twoSword.getDamage(), goblin.getName());
                        System.out.println(player.getName() + ": " + player.getHealth());
                        System.out.println(goblin.getName() + ": " + goblin.getHealth());
                    }
                    if (goblin.health <= 0) {
                        int chance = random.nextInt(10);
                        player.dropLoot(chance, plusHealth.getName(), plusStrength.getName());
                        goblin.reset();
                    } else {
                        player.reset();
                        goblin.reset();
                    }
                }
                case 2 -> {
                    plusHealth.setValue();
                    plusStrength.setValue();
                    player.checkInventory();
                    player.useItem(plusHealth.getValue(), plusStrength.getValue());
                    player.inventoryReset();
                }
                case 3 -> {
                    player.checkStats();
                    player.showEquipped(oneSword.getName(), oneArmor.getName());
                }
                case 4 -> {
                    System.out.println("Good bye!");
                    runGame = false;
                }
            }
        }
    }
}

