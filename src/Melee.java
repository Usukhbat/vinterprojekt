import java.util.Random;
public class Melee extends Weapons {
    String name;
    int damage;
    Random random = new Random();

    public Melee(String name) {
        super(name);
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