package model.types;

import model.abilities.Skill;

import java.util.Arrays;
import java.util.List;

public enum PlayerType {
    MAGE(Arrays.asList(
            new Skill("Fireball", 10, 0.1, true, 0, 0),
            new Skill("HealTeam", 0, 0.0, true, 5, 2),
            new Skill("Magic Shield", 10, 0.0, true, 0, 5)
    )),
    WARRIOR(Arrays.asList(
            new Skill("Slash", 12, 0.2, false, 3, 0),
            new Skill("Charge", 13, 0.1, false, 0, 2),
            new Skill("Block", 20, 0.0, false, 0, 15)
    )),
    ARCHER(Arrays.asList(
            new Skill("Arrow Shot", 25, 0.3, false, 0, 0),
            new Skill("Eagle Eye", 15, 1, false, 0, 0),
            new Skill("Trap", 20, 0.15, false, 0, 0)
    )),
    BARBARIAN(Arrays.asList(
            new Skill("Berserk", 10, 0.25, false, 0, 0),
            new Skill("Smash", 12, 0.1, false, 0, 0),
            new Skill("Roar", 0, 0.0, false, 0, 4)
    )),
    DRUID(Arrays.asList(
            new Skill("Heal", 0, 0.0, true, 10, 4),
            new Skill("Zombie attack", 35, 0.2, true, 0, 0),
            new Skill("Earthquake", 45, 0.1, true, 0, 0)
    ));

    private final List<Skill> abilities;

    PlayerType(List<Skill> abilities) {
        this.abilities = abilities;
    }

    public List<Skill> getAbilities() {
        return abilities;
    }

}
