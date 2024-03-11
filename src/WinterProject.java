import java.util.HashMap;
import java.util.List;
public class WinterProject{
    // använde hashmap för att kunna sortera klasserna mer effektivt.
    final List<Characters> enemyList = List.of(new Goblin("Goblin", 20), new Skeleton("Skeleton", 20), new Rat("Rat", 20), new Zombie("Zombie", 20), new Slime("Slime", 20));
    static HashMap<Integer, Characters> enemies = new HashMap<>();
            public WinterProject(){
                int index = 0;
                for(Characters c : enemyList){ //lägger elements i hashmappen enligt enemyList för varje index.
                    enemies.put(index, c);
                    index++;
                }
            }
    // använder det här för att köra programmet.
            public static void main(String[] args){
                mainGame mainGame = new mainGame(enemies);
            }
}