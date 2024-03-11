public class Goblin extends Characters{
    public Goblin(String name, int health){
        super(name, health);
    }
    // reset och makeSound metoden är annorlunda (polymorfi) för varje fiende.
    public void reset(){
        this.health = 25;
    }
    public void makeSound(){
        System.out.println("Die, human!");
    }
}
