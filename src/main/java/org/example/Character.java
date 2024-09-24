package org.example;
import java.util.Scanner;

public class Character {
    private String name;
    private int level, exp, hp;
    private State state;

    public Character(String name, int level, int exp, int hp) {
        this.name = name;
        this.level = level;
        this.exp = exp;
        this.hp = hp;
    }

    public void setState(State state){
        this.state = state;
    }
    public void train(){
        System.out.println("you are training");
    }
    public void attack(){
        System.out.println("you are attacking");
    }
    public void meditate(){
        System.out.println("you are meditating");
    }

}
