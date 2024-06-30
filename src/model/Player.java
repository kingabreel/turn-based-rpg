package model;

import model.types.PlayerType;

import java.util.ArrayList;

public class Player extends Character{
    private final PlayerType type;
    private int xp;

    public Player(String name, PlayerType type) {
        super(name, 1, type.getLife(), true, type.getMagicDefense(), type.getPhysicalDefense(), 5, new ArrayList<>());
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

    public void checkLevelUp() {
        int xpNewLevel = getLevel() * 25;

        if (getXp() >= xpNewLevel) {
            setLevel(getLevel() + 1);
            setLife(getLife() + getLevel() + 3);
            setMagicDefense(getMagicDefense() + getLevel());
            setPhysicalDefense(getPhysicalDefense() + getLevel());
            getType().getAbilities().forEach(skill -> {
                int damage = skill.getBaseDamage();
                int heal = skill.getHealAmount();
                int protection = skill.getProtection();

                if (damage != 0) skill.setBaseDamage(damage + getLevel());
                if (heal != 0) skill.setHealAmount(heal + getLevel());
                if (protection != 0) skill.setProtection(protection + getLevel() - 1);
            });
            System.out.println("======================");
            System.out.println("Você subiu de nível!\n" + "Nível atual: " + getLevel());
            System.out.println("======================");
        }
    }
}
