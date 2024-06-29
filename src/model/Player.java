package model;

import model.types.PlayerType;

import java.util.ArrayList;

public class Player extends Character{
    private final PlayerType type;
    private int xp;

    public Player(String name, PlayerType type) {
        super(name, 0, 10, true, 5, 5, 5, new ArrayList<>());
        this.type = type;
        this.xp = 0;
    }

    public PlayerType getType() {
        return type;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
}
