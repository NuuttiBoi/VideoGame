package org.example;

import java.util.Scanner;

public class DefaultState extends State {
    private State state;
    private boolean running = true;
    private String[] options = {"Novice", "Intermediate", "Expert", "Master"};
    Scanner scanner = new Scanner(System.in);


    public DefaultState(Character character) {
        super(character);
    }

    @Override
    void action() {
        System.out.println("Please Select The Level:");
        switch (this.getCharacter().readUserChoice(options)){
            case 1:
                state = new NoviceState(this.getCharacter());
                this.getCharacter().setState(state);
                this.getCharacter().operate();
                break;
            case 2:
                if(this.getCharacter().getExp()>=10) {
                    state = new IntermediateState(this.getCharacter());
                    this.getCharacter().setState(state);
                    this.getCharacter().operate();
                } else{
                    System.out.println("You don't have enough experience points for this level yet! returning to level selection...");
                    this.action();
                }
                break;
            case 3:
                if(this.getCharacter().getExp()>=25) {
                    state = new ExpertState(this.getCharacter());
                    this.getCharacter().setState(state);
                    this.getCharacter().operate();
                } else{
                    System.out.println("You don't have enough experience points for this level yet! returning to level selection...");
                    this.action();
                }
                break;
            case 4:
                if(this.getCharacter().getExp()>=50) {
                    state = new MasterState(this.getCharacter());
                    this.getCharacter().setState(state);
                    this.getCharacter().operate();
                } else{
                    System.out.println("You don't have enough experience points for this level yet! returning to level selection...");
                    this.action();
                }
                break;
        }
}
}
