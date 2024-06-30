package model.types;

import model.abilities.Skill;

import java.util.Arrays;
import java.util.List;

public enum PlayerType {
    MAGE(56, 15, 3, 15, Arrays.asList(
            new Skill("Fireball", 10, 0.1, true, 0, 0),
            new Skill("Heal", 0, 0.0, true, 5, 2),
            new Skill("Magic Shield", 0, 0.0, true, 0, 5)
    )),
    WARRIOR( 140, 6, 9, 5, Arrays.asList(
            new Skill("Slash", 7, 0.2, false, 3, 0),
            new Skill("Charge", 13, 0.1, false, 0, 2),
            new Skill("Block", 0, 0.0, false, 0, 15)
    )),
    ARCHER(70, 0, 1, 2, Arrays.asList(
            new Skill("Arrow Shot", 13, 0.3, false, 0, 0),
            new Skill("Eagle Eye", 5, 1, false, 0, 0),
            new Skill("Trap", 12, 0.15, false, 0, 0)
    )),
    BARBARIAN(112, 0, 10, 2, Arrays.asList(
            new Skill("Berserk", 10, 0.25, false, 0, 0),
            new Skill("Smash", 12, 0.1, false, 0, 0),
            new Skill("Roar", 0, 0.0, false, 0, 6)
    )),
    DRUID(67, 20, 9, 2, Arrays.asList(
            new Skill("Heal", 0, 0.0, true, 10, 4),
            new Skill("Zombie attack", 13, 0.2, true, 0, 0),
            new Skill("Earthquake", 15, 0.1, true, 0, 0)
    ));

    private final int life;
    private final int magicDefense;
    private final int physicalDefense;
    private final int baseDamage;
    private final List<Skill> abilities;

    PlayerType(int life, int magicDefense, int physicalDefense, int baseDamage, List<Skill> abilities) {
        this.life = life;
        this.magicDefense = magicDefense;
        this.physicalDefense = physicalDefense;
        this.baseDamage = baseDamage;
        this.abilities = abilities;
    }

    public int getLife() {
        return life;
    }

    public int getMagicDefense() {
        return magicDefense;
    }

    public int getPhysicalDefense() {
        return physicalDefense;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public List<Skill> getAbilities() {
        return abilities;
    }
}
