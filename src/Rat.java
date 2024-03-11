public class Rat extends Characters{
    public Rat(String name, int health){
        super(name, health);
    }
    // reset och makeSound metoden är annorlunda (polymorfi) för varje fiende.
    public void reset(){
        this.health = 10;
    }
    public void makeSound(){
        System.out.println("*Scritch, scritch, scurry... Squeak, squeak, nibble. Gnaw, gnaw, whiskers twitching.*");
    }
}
