package org.example;

public abstract class State {
    private Character character;

    public State(Character character) {}

    abstract void action();
}
