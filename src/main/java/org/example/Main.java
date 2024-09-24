package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static State novice;
    public static void main(String[] args) {
        Character character= new Character("Nuutti",10,10,1);
        novice = new NoviceState(character);
        character.train();

    }
}