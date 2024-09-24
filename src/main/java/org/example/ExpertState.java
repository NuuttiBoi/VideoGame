package org.example;

import java.util.Scanner;

public class ExpertState extends State {
    private String[] options = {"Train","Meditate","Fight","Exit"};
    private boolean running = true;
    Scanner scanner = new Scanner(System.in);

    public ExpertState(Character character) {
        super(character);
    }

    @Override
    void action() {
        System.out.println(" ________________ ");
        System.out.println("| Expert Level!  |");
        System.out.println(" ---------------- ");

        switch (this.getCharacter().readUserChoice(options)) {
            case 1:
                while (running) {
                    System.out.println("You are now training.");
                    System.out.println("  _______ ");
                    System.out.println(" | Train |");
                    System.out.println("  ------- ");

                    if (this.getCharacter().getExp() >= 50) {
                        System.out.println("Congratulations! You have reached the next level...");
                        System.out.println(" ______________ ");
                        System.out.println("| Master Level! |");
                        System.out.println(" -------------- ");

                        this.getCharacter().setState(new MasterState(this.getCharacter()));
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
                while (running) {
                    System.out.println("You are now meditating.");
                    System.out.println("  ____________ ");
                    System.out.println(" | Meditating |");
                    System.out.println("  ------------ ");

                    this.getCharacter().meditate();

                    System.out.println("Keep meditating?");
                    if (scanner.nextLine().equalsIgnoreCase("no")) {
                        running = false;
                    }
                }
                this.getCharacter().operate();
                break;

            case 3:
                while (running) {
                    System.out.println("You are now fighting.");
                    System.out.println("  _________ ");
                    System.out.println(" | Fighting |");
                    System.out.println("  --------- ");

                    this.getCharacter().attack();
                    if (this.getCharacter().getExp() >= 50) {
                        System.out.println("Congratulations! You have reached the next level...");
                        System.out.println(" ______________ ");
                        System.out.println("| Master Level! |");
                        System.out.println(" -------------- ");

                        this.getCharacter().setState(new MasterState(this.getCharacter()));
                        this.getCharacter().operate();
                    }

                    System.out.println("Keep fighting? (Y/N)");
                    if (scanner.nextLine().equalsIgnoreCase("n")) {
                        running = false;
                    }
                }
                this.getCharacter().operate();
                break;

            case 4:
                System.out.println("You are exiting back to the main menu.");
                System.out.println(" ________ ");
                System.out.println("| Exiting |");
                System.out.println(" -------- ");

                this.getCharacter().setState(new DefaultState(this.getCharacter()));
                this.getCharacter().operate();
                break;
        }
    }

}
