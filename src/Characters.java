import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
public class Characters {
    final String name;
    int health = 50;
    int strength = 5;
    ArrayList<String> inventory = new ArrayList<>();
    Random random = new Random();
    Characters(String name){
        this.name = name;
        this.inventory.add("empty");
    }
    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;
    }
    public void dealDamage(int damage, String name){
        damage += random.nextInt(10);
        System.out.println(name+" dealt -"+damage);
        this.health = (this.health-damage);
    }
    public void checkInventory(){
        int n = 0;
        System.out.println("[Inventory]");
        for (String i : inventory){
            n++;
            System.out.println(n+". "+i);
        }
    }
    public void checkStats(){
        System.out.println(this.name+"'s stats"+"\nHealth: "+this.health+"\nStrength: "+this.strength);
    }
    public void dropLoot(int chance, String plusStrength, String plusHealth){
        this.health = 50;
        System.out.println("You won!");
        switch (chance) {
            case 0,1,2,3,4 -> {
                System.out.println("MonsterName dropped a " + plusStrength + ".\n(Item is stashed in your inventory.)");
                if (Objects.equals(this.inventory.get(0), "empty")) {
                    this.inventory.clear();
                }
                this.inventory.add(plusStrength);
            }
            case 5,6,7,8,9 -> {
                System.out.println("MonsterName dropped a " + plusHealth + ".\n(Item is stashed in your inventory.)");
                if (Objects.equals(this.inventory.get(0), "empty")) {
                    this.inventory.clear();
                }
                this.inventory.add(plusHealth);
            }
        }
    }
    public void loss(){
        this.health = 50;
        System.out.println("You died, try again.");
    }
    public void useItem(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Tip: To use an item type the item slot number. Type 0 to return to the main menu.");
        int index = scan.nextInt();
        if (index == 0){
            return;
        }
        index --;
        if (this.inventory.get(index).equalsIgnoreCase("empty")){
            System.out.println("Your inventory is empty.");
            return;
        }
        System.out.println("Use, "+this.inventory.get(index)+"?\n(Yes or No)");
        String action = scan.next();
        if (action.equalsIgnoreCase("yes")){
            if (this.inventory.get(index).equalsIgnoreCase("Green Crystal")){
                int plusHealth = random.nextInt(1,6);
                this.health += plusHealth;
                System.out.println("You used: "+this.inventory.get(index)+".\n+"+plusHealth+" Health.\n(Item has been removed from your inventory.)");
                this.inventory.remove(index);
            }
            if (this.inventory.get(index).equalsIgnoreCase("Red Crystal")){
                int plusStrength = random.nextInt(1,6);
                this.strength += plusStrength;
                System.out.println("You used: "+this.inventory.get(index)+".\n+"+plusStrength+" Strength.\n(Item has been removed from your inventory.)");
                this.inventory.remove(index);
            }
        }
        else{
            System.out.println("Action cancelled or wrong input");
        }

    }
    public void inventoryReset(){
        boolean check = this.inventory.get(0).isEmpty();
        if (check){
            this.inventory.add("empty");
        }
    }
}
