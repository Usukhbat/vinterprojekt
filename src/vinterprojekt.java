public class vinterprojekt{
    static Characters hero = new Characters("ben");
    static Characters villain = new Characters("Loki");
    static melee goodSword = new melee("Excalibur");
    static melee evilSword = new melee("Dan");
    public static void main(String[] args){
        System.out.println("begin!");
        while (hero.health>0 && villain.health>0){
            villain.dealDamage(goodSword.getDamage(), hero.getName());
            hero.dealDamage(evilSword.getDamage(), villain.getName());
            System.out.println(hero.getName()+": "+hero.getHealth());
            System.out.println(villain.getName()+": "+villain.getHealth());
        }
        if (villain.health <= 0){
            System.out.println("gj, "+hero.getName());
        }
        else{
            System.out.println("fail, " + hero.getName());
        }
    }
}

