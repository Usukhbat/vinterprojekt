import java.util.Random;

public class Loot {
    String name;
    int value;
    Random random = new Random();
    public Loot(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public int getValue(){
        return value;
    }
    public void setValue(){
        this.value = random.nextInt(1,6);
    }
}
