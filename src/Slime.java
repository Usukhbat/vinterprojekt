public class Slime extends Characters{
    public Slime(String name, int health){
        super(name, health);
    }
    // reset och makeSound metoden är annorlunda (polymorfi) för varje fiende.
    public void reset() {
        this.health = 15;
    }
    public void makeSound(){
        System.out.println("Squelch! Squish! Glop! Glare!");
    }
}
