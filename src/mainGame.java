import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class mainGame {
    static Melee oneSword = new Melee("Wooden Sword");
    static Melee twoSword = new Melee("Long Sword");
    static Loot plusStrength = new Loot("Red Crystal");
    static Loot plusHealth = new Loot("Green Crystal");
    static Armor oneArmor = new Armor("Leather Armor");
    public mainGame(HashMap<Integer, Characters> enemies){
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
                    int choice = random.nextInt(1,2);
                    switch (choice){
                        case 1 -> {
                            while (player.health > 0 && enemies.get(1).health > 0) {
                                oneSword.setDamage();
                                twoSword.setDamage();
                                enemies.get(1).dealDamage(oneSword.getDamage(), player.getName());
                                enemies.get(1).makeSound();
                                player.dealDamage(twoSword.getDamage(), enemies.get(1).getName());
                                System.out.println(player.getName() + ": " + player.getHealth());
                                System.out.println(enemies.get(1).getName() + ": " + enemies.get(1).getHealth());
                            }
                            if (enemies.get(1).health <= 0) {
                                int chance = random.nextInt(10);
                                player.dropLoot(chance, plusHealth.getName(), plusStrength.getName());
                                enemies.get(1).reset();
                            } else {
                                player.reset();
                                enemies.get(1).reset();
                            }
                        }
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
