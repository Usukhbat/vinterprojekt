public class Monsters extends Characters {
    public Monsters(String name, int health){
        super(name, health);
    }
    public void makeSound(){
        System.out.println("Die, human!");
    }
}
