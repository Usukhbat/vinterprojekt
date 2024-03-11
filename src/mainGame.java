import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class mainGame {
    static Loot plusStrength = new Loot("Red Crystal");
    static Loot plusHealth = new Loot("Green Crystal");
    static Armor oneArmor = new Armor("Light Armor");

    public mainGame(HashMap<Integer, Characters> enemies){
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Dungeon of Ben\nYour name: "); // tar in ditt input och använder det som namn.
        String playerName = scan.nextLine();
        Characters player = new Characters(playerName, 30); // objekt för spelaren, ger namn och hälsa.
        Melee playerDamage = new Melee("long sword");
        Melee enemyDamage = new Melee("club"); // objekt för fiende skada
        boolean runGame = true;// använder denna variabel för switch case 4 i metoden under.
        while (runGame){
            System.out.println("[Main Menu]\n1. Fight\n2. Check Inventory\n3. Player Info\n4. Exit Game");
            // menyn där programmet finns och man kan välja mellan att slåss, kolla dina saker, spelare information, eller lämna spelet.
            int menu = scan.nextInt();
            switch (menu) {
                case 1 -> {
                    int randomizer = random.nextInt(1,6);
                    // randomizer variablen gör så att man kan träffa olika fiender baserad på index i hashmapen.
                    randomizer--;
                    while (player.health > 0 && enemies.get(randomizer).health > 0) {
                        playerDamage.setDamage();
                        enemyDamage.setDamage();
                        // använder denna metod för att randomiza damagen man skadar. för att det är i en while loop så det andräs vid varje loop.
                        enemies.get(randomizer).dealDamage(playerDamage.getDamage(), player.getName()); // fiende tappar hälsa
                        enemies.get(randomizer).makeSound(); // olika ljud baserad på fiende.
                        player.dealDamage(enemyDamage.getDamage(), enemies.get(randomizer).getName()); // spelaren tappar hälsa
                        System.out.println(player.getName() + ": " + player.getHealth()); // det här visar nuvarande hälsa för spelare
                        System.out.println(enemies.get(1).getName() + ": " + enemies.get(randomizer).getHealth()); // nuvarande hälsa för fiende
                    }
                    if (enemies.get(randomizer).health <= 0) { // if sats om fienden dör
                        int chance = random.nextInt(1, 3);
                        player.dropLoot(chance, plusHealth.getName(), plusStrength.getName()); // chance variabel väljer ett tal som skickas in till metod för att välja looten som droppar
                        enemies.get(randomizer).reset(); // startar om liven för fienden så ny fiende kan väljas.
                    } else { // om spelaren dör. starta om hälsan för båda..
                        player.reset();
                        enemies.get(randomizer).reset();
                    }

                }
                case 2 -> {
                    plusHealth.setValue();
                    plusStrength.setValue();
                    player.checkInventory(); // printar ut alla element i arraylisten för spelaren
                    player.useItem(plusHealth.getValue(), plusStrength.getValue()); // låter spelaren att använda en item i inventoryn
                    player.inventoryReset(); // ifall inventoryn är tom så skrivs det "Empty"
                }
                case 3 -> {
                    player.checkStats(); // printar ut alla stats för spelaren, hälsa, skada
                    player.showEquipped(playerDamage.getName(), oneArmor.getName()); // printar spelarens vapen och utrustning
                }
                case 4 -> {
                    System.out.println("Good bye!");
                    runGame = false; // stänger ner while loopen.
                }
            }
        }
    }
}
