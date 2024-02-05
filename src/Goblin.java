public class Goblin extends Characters{
    public Goblin(String name, int health){
        super(name, health);
    }
    public void reset(){
        this.health = 20;
    }
    public void makeSound(){
        System.out.println("Die, human!");
    }
}
