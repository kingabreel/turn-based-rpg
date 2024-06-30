package model;

import model.abilities.Effect;

import java.util.List;

public class Character {
    private final String name;
    private int life;
    private boolean alive;
    private int level;
    private int magicDefense;
    private int physicalDefense;
    private int baseDamage;
    private int shield;
    private List<Effect> effects;

    public Character(String name, int level, int life, boolean alive, int magicDefense, int physicalDefense, int baseDamage, List<Effect> effects) {
        this.name = name;
        this.level =level;
        this.life = life;
        this.alive = alive;
        this.magicDefense = magicDefense;
        this.physicalDefense = physicalDefense;
        this.baseDamage = baseDamage;
        this.effects = effects;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMagicDefense() {
        return magicDefense;
    }

    public void setMagicDefense(int magicDefense) {
        this.magicDefense = magicDefense;
    }

    public int getPhysicalDefense() {
        return physicalDefense;
    }

    public void setPhysicalDefense(int physicalDefense) {
        this.physicalDefense = physicalDefense;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public List<Effect> getEffects() {
        return effects;
    }

    public void setEffects(List<Effect> effects) {
        this.effects = effects;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }
}
