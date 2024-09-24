package org.example;
import java.util.Scanner;

public class Character {
    private String name;
    private int level, exp, hp;
    private int startingHp;
    private State state;
    Scanner scanner = new Scanner(System.in);

    public Character(String name, int level, int exp, int hp) {
        this.name = name;
        this.level = level;
        this.exp = exp;
        this.hp = hp;
        startingHp = hp;
        state = new DefaultState(this);
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){return state;}

    public void operate(){
        state.action();
    }

    public int neededXp(){
        String currentState = this.getState().getClass().getSimpleName();
        if(currentState.equals("NoviceState")){
            return 10;
        } else if(currentState.equals("IntermediateState")){
            return 25;
        } else if(currentState.equals("ExpertState")){
            return 50;
        } else
            return 0;
    }

    public void train(){
        System.out.println("you are training");
        System.out.println("                                                        O--,---,--O");
        System.out.println("                                          ._O_.     O--=-O-=--O     \\ O /");
        System.out.println("    _._                      ,_O_,     O--<-+->--O      '-'          - -");
        System.out.println("   / O \\        ,-O-,     O--(---)--O       X            v            -");
        System.out.println("   \\| |/     O--=---=--O      >'>          / \\          / )          / \\");
        System.out.println("O--+=-=+--O      2\"2          - -         -   -        ~  z         =   =");
        exp++;
        System.out.println("exp: " + exp + " /" + neededXp() + " xp");

    }

    public void attack(){
        System.out.println("you are attacking");
        System.out.println("   ( •_•)                  (•_• )");
        System.out.println("    ( づ  )                ୧( ୧ )");
        System.out.println("    /︶\\                   /︶\\");
        exp++;
        hp--;
        if (hp <= 0 ){
            System.out.println("fuck u ");
            gameOver();
        }
        System.out.println("hp: " + hp + " /" + startingHp + " hp");
        System.out.println("exp: " + exp + " /" + neededXp() + " xp");
    }

    public void meditate(){
        System.out.println("you are meditating");
        System.out.println("     \\|/");
        System.out.println("     (o o)");
        System.out.println("  ---(  -  )---");
        System.out.println("     / | \\");
        System.out.println("    O  |  O");
        System.out.println("       |");
        System.out.println("      / \\");
        System.out.println("     O   O");
        hp++;
        System.out.println("hp: " + hp);
    }

    public void gameOver(){
        System.out.println("You Died! Game over.");
        System.out.println("   ( •_•)                  (×_×)");
        System.out.println("    ( づ  )                ( ̩_ ̩ )");
        System.out.println("    /︶\\                   /︶\\");
        System.out.println("    /  \\                 /   \\");
        System.out.println("RIP " + name);
        this.setState(new DefaultState(this));
        this.operate();
    }

    public int getExp(){return exp;}

    public int getHp(){return hp;}

    public int getLevel(){return level;}

    public int readUserChoice(String[] options) {
        for (int i = 1; i <= options.length; i++) {
            System.out.println(" _________________________ ");
            System.out.println("|                         |");
            System.out.printf("| %2d. %-20s |\n", i, options[i-1]);
            System.out.println("|_________________________|");
        }
        // read user input
        return scanner.nextInt();
    }
}
