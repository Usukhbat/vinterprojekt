import java.util.Scanner;
import java.util.Random;
public class vinterprojekt{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Who will our valiant hero be remembered as?");
        String nameHero = scan.nextLine();
        System.out.println("Who will our great hero defeat?");
        String nameVillain = scan.nextLine();
        characters hero = new characters(nameHero, 50);
        characters villain = new characters(nameVillain, 50);
        weapons goodSword = new weapons("goodSword", 3);
        weapons evilSword = new weapons("evilSword", 3);
        System.out.println("May the most important battle in all of history begin!");
        while (hero.health>0 && villain.health>0){
            System.out.println(hero.getName()+": "+hero.getHealth());
            System.out.println(villain.getName()+": "+villain.getHealth());
            System.out.println(hero.getName()+" swings his blade!");
            villain.dealDamage(goodSword.damage);
            System.out.println("It dealt great damage!");
            System.out.println(hero.getName()+": "+hero.getHealth());
            System.out.println(villain.getName()+": "+villain.getHealth());
            System.out.println(villain.getName()+" lunges with his sword!");
            hero.dealDamage(evilSword.damage);
            System.out.println("It hurt.");
        }
        if (villain.health <= 0){
            System.out.println("You have exterminated the the great terror plaguing these lands. Your name has spread far and wide."+hero.getName());
        }
        if (hero.health <= 0){
            System.out.println("You failed to vanquish the evil. "+villain.getName()+"'s reign of terror has begun. May your soul bring with, the shame, the dishonour, into your grave.");
        }
    }
}
