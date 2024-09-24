package org.example;

public class NoviceState extends State{
    public NoviceState(Character character) {
        super(character);
    }

    @Override
    void action() {
        System.out.println("You are training");
    }
}
