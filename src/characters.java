import java.util.ArrayList;
public class characters {
    final String name;
    int health = 20;
    int strength = 5;
    int endurance = 5;
    ArrayList<String> inventory = new ArrayList<>();
    characters(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public int getHealth(){
        this.health += endurance;
        return health;
    }
    public void dealDamage(int damage){
        int pain = damage+this.strength;
        this.health = (this.health-pain);
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
