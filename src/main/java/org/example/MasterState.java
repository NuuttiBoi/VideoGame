package org.example;

public class MasterState extends State{
    private String[] options = {"Train","Exit"};
    public MasterState(Character character) {
        super(character);
    }

    @Override
    void action() {
        System.out.println("  _____                             _               _       _   _           _ ");
        System.out.println(" / ____|                           (_)             | |     | | (_)         | |");
        System.out.println("| |     __ _ _ __ ___  _   _ _ __    _ _ __ ___   __| | __ _| |_ _  ___ __ _| |");
        System.out.println("| |    / _` | '_ ` _ \\| | | | '_ \\  | | '_ ` _ \\ / _` |/ _` | __| |/ __/ _` | |");
        System.out.println("| |___| (_| | | | | | | |_| | | | | | | | | | | | (_| | (_| | |_| | (_| (_| | |");
        System.out.println(" \\_____\\__,_|_| |_| |_|\\__,_|_| |_| |_|_| |_| |_|\\__,_|\\__,_|\\__|_|\\___\\__,_|_|");
        System.out.println("________________________________________________________________________________");
        System.out.println("|                                                                              |");
        System.out.println("|       Congratulations! You have completed the game and reached the           |");
        System.out.println("|                            Master Level!                                     |");
        System.out.println("|______________________________________________________________________________|");
    }

}
