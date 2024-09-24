package org.example;

import java.util.Scanner;

public class NoviceState extends State{
    private boolean running = true;
    private String[] options = {"Train","Exit"};
    Scanner scanner = new Scanner(System.in);
    public NoviceState(Character character) {
        super(character);
    }

    @Override
    void action() {
        System.out.println("You are in the Novice level.");
        System.out.println("Reach 10xp to reach the next level.");

        System.out.println(" _________ ");
        System.out.println("|  Novice |");
        System.out.println(" --------- ");

        switch (this.getCharacter().readUserChoice(options)) {
            case 1:
                while (running) {
                    System.out.println("You are now training.");
                    System.out.println(" ------- ");
                    System.out.println("| Train |");
                    System.out.println(" ------- ");
                    this.getCharacter().train();

                    if (this.getCharacter().getExp() >= 10) {
                        System.out.println("Congratulations! You have reached the next level...");
                        System.out.println(" ______________ ");
                        System.out.println("| Next Level!! |");
                        System.out.println(" -------------- ");

                        this.getCharacter().setState(new IntermediateState(this.getCharacter()));
                        this.getCharacter().operate();
                    }

                    System.out.println("Keep training? (Y/N)");
                    if (scanner.nextLine().equalsIgnoreCase("n")) {
                        running = false;
                    }
                }
                this.getCharacter().operate();
                break;

            case 2:
                System.out.println("You are exiting back to the main menu.");
                System.out.println(" ________ ");
                System.out.println("| Exit...|");
                System.out.println(" -------- ");

                this.getCharacter().setState(new DefaultState(this.getCharacter()));
                this.getCharacter().operate();
                break;
        }
    }
}
