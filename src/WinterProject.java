import java.util.HashMap;
import java.util.List;
public class WinterProject{
    final List<Characters> enemieList = List.of(new Goblin("Goblin", 20), new Skeleton("Skeleton", 20), new Rat("Rat", 20), new Zombie("Zombie", 20), new Slime("Slime", 20));
    static HashMap<Integer, Characters> enemies = new HashMap<>();
            public WinterProject(){
                int index = 0;
                for(Characters c : enemieList){
                    enemies.put(index, c);
                    index++;
                }
            }
    public static void main(String[] args){
                mainGame mainGame = new mainGame(enemies);
            }
}