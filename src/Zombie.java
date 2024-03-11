public class Zombie extends Characters{
    public Zombie(String name, int health){
        super(name, health);
    }
    // reset och makeSound metoden är annorlunda (polymorfi) för varje fiende.
    public void reset(){
        this.health = 30;
    }
    public void makeSound(){
        System.out.println("Grrrrr... uuuuhhh... raaaahhh...");
    }
}
