import java.util.Scanner;
import java.util.Random;
public class vinterprojekt{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Who will our valiant hero be remembered as?");
        String nameHero = scan.nextLine();
        characters hero = new characters(nameHero);
        characters villain = new characters("Loki");
        melee goodSword = new melee("Excalibur");
        melee evilSword = new melee("Dan");
        System.out.println("May the most important battle in all of history begin!");
        while (hero.health>0 && villain.health>0){
            System.out.println("Menu\n1. Attack\n2. Check Inventory\n3. Check Stats");
            int choice = scan.nextInt();
            switch (choice){
                case 1:
                    System.out.println(hero.getName()+": "+hero.getHealth());
                    System.out.println(villain.getName()+": "+villain.getHealth());
                    System.out.println(hero.getName()+" swings his blade!");
                    villain.dealDamage(goodSword.physicalDamage);
                    System.out.println("It dealt great damage!");
                    System.out.println(hero.getName()+": "+hero.getHealth());
                    System.out.println(villain.getName()+": "+villain.getHealth());
                    System.out.println(villain.getName()+" lunges with his sword!");
                    hero.dealDamage(evilSword.physicalDamage);
                    System.out.println("It hurt.");
                case 2:
                    hero.checkInventory();
                case 3:
                    hero.checkStats();
            }
        }
        if (villain.health <= 0){
            System.out.println("You have exterminated the the great terror plaguing these lands. Your name has spread far and wide."+hero.getName());
        }
        if (hero.health <= 0){
            System.out.println("You failed to vanquish the evil. "+villain.getName()+"'s reign of terror has begun. May your soul bring with, the shame, the dishonour, into your grave.");
        }
    }
}
