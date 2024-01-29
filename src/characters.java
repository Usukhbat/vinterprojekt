public class characters {
    final String name;
    int health;
    characters(String name, int health){
        this.name = name;
        this.health = health;
    }
    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;
    }
    public void dealDamage(int damage){
        int hurt = damage+(int)(10*Math.random());
        this.health = (this.health-hurt);
    }
}
