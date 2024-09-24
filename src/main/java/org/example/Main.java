package org.example;

public class Main {

    public static void main(String[] args) {

        int health_points = 10;
        int experience_points = 0;
        int level = 0;
        Character character = new Character("Bozo", level, experience_points, health_points);
        character.operate();
    }
}