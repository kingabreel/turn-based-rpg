package controller;

public interface Action {
    int attack(boolean player);
    int defense(boolean player);
    int heal(boolean player);
    boolean run();
}
