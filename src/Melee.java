import java.util.Random;
public class Melee {
    String name;
    int damage;
    Random random = new Random();

    public Melee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }
    public void setDamage(){
        this.damage = random.nextInt(1,5);
    }
}