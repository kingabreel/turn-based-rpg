package controller;

public interface Action {
    int attack(boolean player, int attackIndex);

    int defense(boolean player, int defenseIndex);

    int heal(boolean player, int healIndex);

    boolean run();
}
