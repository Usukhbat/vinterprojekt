import java.util.ArrayList;
import java.util.Random;
public class Characters {
    final String name;
    int health = 50;
    int strength = 5;
    int endurance = 5;
    Random random = new Random();
    ArrayList<String> inventory = new ArrayList<>();
    Characters(String name){
        this.name = name;
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
    public void levelUp(){

    }
    public void checkInventory(){
        for (String i : inventory){
            System.out.println(i);
        }
    }
    public void checkStats(){
        System.out.println(this.name+"'s stats"+"\nHealth: "+this.health+"\nStrength: "+this.strength+"\nEndurance: "+this.endurance);
    }
}
