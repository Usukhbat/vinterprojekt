public class Goblin extends Monsters{
    public Goblin(String name, int health){
        super(name, health);
    }
    public void reset(){
        this.health = 20;
    }
}
