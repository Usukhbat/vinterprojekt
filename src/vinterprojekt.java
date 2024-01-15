import java.util.Scanner;
public class vinterprojekt {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("What will our valiant hero be named?");
        String nameHero = scan.nextLine();
        System.out.println("Who will our great hero defeat?");
        String nameVillain = scan.nextLine();
        characters hero = new characters(nameHero, 20);
        characters villain = new characters(nameVillain, 20);
        fight();
    }
    public static void fight(){
        System.out.println();
    }

}