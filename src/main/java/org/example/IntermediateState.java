package org.example;

import java.util.Scanner;

public class IntermediateState extends State{
    private String[] options = {"Train","Meditate","Exit"};
    private boolean running = true;
    Scanner scanner = new Scanner(System.in);

    public IntermediateState(Character character) {
        super(character);
    }

    @Override
    void action() {
        System.out.println("You are in the Intermediate level.");
        System.out.println("Reach 10xp to reach the next level.");
        switch (this.getCharacter().readUserChoice(options)){
            case 1:
                while (running){
                    System.out.println("You are now training.");
                    System.out.println("-------");
                    this.getCharacter().train();
                    if(this.getCharacter().getExp()>=25){
                        System.out.println("Congratulations! You have reached the next level...");
                        System.out.println("-------");
                        this.getCharacter().setState(new ExpertState(this.getCharacter()));
                        this.getCharacter().operate();
                    }
                    System.out.println("Keep training?");
                    if(scanner.nextLine().equalsIgnoreCase("no")){
                        running = false;
                    }
                }
                this.getCharacter().operate();
                break;
            case 2:
                while (running){
                    System.out.println("You are now meditating.");
                    System.out.println("-------");
                    this.getCharacter().meditate();
                    System.out.println("Keep meditating?");
                    if(scanner.nextLine().equalsIgnoreCase("no")){
                        running = false;
                    }
                }
                this.getCharacter().operate();
                break;
            case 3:
                System.out.println("You are exiting back to the main menu.");
                this.getCharacter().setState(new DefaultState(this.getCharacter()));
                this.getCharacter().operate();
                break;
        }

    }
}
