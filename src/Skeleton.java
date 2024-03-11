public class Skeleton extends Characters{
    public Skeleton(String name, int health){
        super(name, health);
    }
    // reset och makeSound metoden är annorlunda (polymorfi) för varje fiende.
    public void reset(){
        this.health = 20;
    }
    public void makeSound(){
        System.out.println("Rattle! Clatter! Gnash! Grind!");
    }
}
