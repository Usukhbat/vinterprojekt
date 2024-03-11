import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
public class Characters {
    final String name;
    int health;
    int strength = 5;
    ArrayList<String> inventory = new ArrayList<>();
    Random random = new Random();
    Characters(String name, int health){ // konstruktor för characters
        this.name = name;
        this.health = health;
        this.inventory.add("empty");
    }
    public String getName(){
        return name;
    } // getter
    public int getHealth(){
        return health;
    } // getter
    public void dealDamage(int damage, String name){ // tar spelarens damage som bas och sedan lägger till mer damage som beror på chans.
        damage += random.nextInt(10);
        System.out.println(name+" dealt -"+damage);
        this.health = (this.health-damage); // minskar hälsan med skadan som gjordes
    }
    public void checkInventory(){ // metod för att printa ut alla element i arraylisten.
        int n = 0;
        System.out.println("[Inventory]");
        for (String i : inventory){ //
            n++;
            System.out.println(n+". "+i);
        }
    }
    public void makeSound(){ // ljud spelaren gör innan hen attackerar.
        System.out.println("Die!");
    }
    public void checkStats(){ // printar ut attributerna av spelaren
        System.out.println("["+this.name+"'s stats]"+"\nHealth: "+this.health+"\nStrength: "+this.strength);
    }
    public void dropLoot(int chance, String plusStrength, String plusHealth){ // metod för att välja looten som addas till inventory
        System.out.println("You won!");
        switch (chance) {
            case 1 -> { // ifall chance är 1, ge spelaren strength
                System.out.println("MonsterName dropped a " + plusStrength + ".\n(Item is stashed in your inventory.)");
                if (Objects.equals(this.inventory.get(0), "empty")) { // denna if sats tar bort empty texten ifall det "empty" finns
                    this.inventory.clear();
                }
                this.inventory.add(plusStrength); // adda item i inventory av spelaren
            }
            case 2 -> { // ge hälsa ifall chance är 2
                System.out.println("MonsterName dropped a " + plusHealth + ".\n(Item is stashed in your inventory.)");
                if (Objects.equals(this.inventory.get(0), "empty")) { // samma som ovan
                    this.inventory.clear();
                }
                this.inventory.add(plusHealth); // adda item i invenory ar spelaren
            }
        }
    }
    public void reset(){ // ger spelarn full hälsa igen.
        this.health = 50;
        System.out.println("You died, try again.");
    }
    public void useItem(int plusHealth, int plusStrength){
        Scanner scan = new Scanner(System.in); // ett system där man kan med hjälp av inputs, välja och använda en item i inventoryn.
        System.out.println("Tip: To use an item type the item slot number. Type '0' to return to the main menu.");
        try{ // en try catch ifall man inte skriver enligt instruktionerna.
            int index = scan.nextInt();
            if (index == 0){ // som instruktionerna ovan säger, '0' gör så att man lämnar denna metod.
                return;
            }
            index --; // det här gör så att vi får rätt tillgång till inventoryn, arraylist index börjar med 0, inte 1.
            if (this.inventory.get(index).equalsIgnoreCase("empty")){ // kan detektera ifall inventoryn är tom.
                System.out.println("Your inventory is empty.");
                return;
            }
            System.out.println("Use, "+this.inventory.get(index)+"?\n(Yes or No)"); // bestäm om man vill verkligen använda sin item.
            String action = scan.next();
            if (action.equalsIgnoreCase("yes")){
                if (this.inventory.get(index).equalsIgnoreCase("Green Crystal")){ // denna if sats använder item från inventoryn
                    this.health += plusHealth; // ger spelaren en slumpmässig värde för att lägga till hälsan.
                    System.out.println("You used: "+this.inventory.get(index)+".\n+"+plusHealth+" Health.\n(Item has been removed from your inventory.)");
                    this.inventory.remove(index); // tar bort item från inventoryn efter att ha använt den.
                }
                if (this.inventory.get(index).equalsIgnoreCase("Red Crystal")){ // samma som ovan fast för red crystal.
                    this.strength += plusStrength;
                    System.out.println("You used: "+this.inventory.get(index)+".\n+"+plusStrength+" Strength.\n(Item has been removed from your inventory.)");
                    this.inventory.remove(index);
                }
            }
        }catch (Exception e){ // try catch meddelande.
            System.out.println("Wrong input. To use an item type the item slot number or type '0' to return to the main menu.");
        }
    }
    public void inventoryReset(){ // kollar ifall inventory är tom, och ifall det är, skriver in "empty"
        boolean check = this.inventory.isEmpty();
        if (check){
            this.inventory.add("empty");
        }
    }
    public void showEquipped(String weapon, String armor){ // visar alla utrustning som spelaren har.
        System.out.println("[Equipped]\nWeapon: "+weapon+"\nArmor: "+armor);
    }
}
