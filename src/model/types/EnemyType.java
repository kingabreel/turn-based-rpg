package model.types;

import model.abilities.Skill;

import java.util.Arrays;
import java.util.List;

public enum EnemyType {
    GOBLIN(1, 30, 5, 10, 3, Arrays.asList(
            new Skill("Strike", 3, 0.05, false, 0, 0),
            new Skill("Dodge", 0, 0.0, false, 0, 10)
    )),
    ORC(2, 50, 10, 20, 7, Arrays.asList(
            new Skill("Swing", 7, 0.1, false, 0, 0),
            new Skill("Rage", 2, 0.0, false, 0, 0)
    )),
    TROLL(3, 70, 15, 25, 10, Arrays.asList(
            new Skill("Attack", 4, 0.2, false, 0, 0),
            new Skill("Regenerate", 0, 0.0, true, 5, 0)
    )),
    VAMPIRE(4, 60, 20, 15, 12, Arrays.asList(
            new Skill("Blood Suck", 5, 0.15, true, 5, 2),
            new Skill("Bat", 7, 0.1, true, 0, 0)
    )),
    WEREWOLF(5, 80, 10, 30, 15, Arrays.asList(
            new Skill("Claw", 12, 0.2, false, 0, 0),
            new Skill("Howl", 0, 0.0, false, 0, 10)
    )),
    SKELETON(2, 40, 5, 20, 8, Arrays.asList(
            new Skill("Bone Throw", 8, 0.1, false, 0, 0),
            new Skill("Break", 0, 0.0, false, 4, 5)
    )),
    ZOMBIE(3, 50, 10, 15, 6, Arrays.asList(
            new Skill("Bite", 6, 0.05, false, 3, 2),
            new Skill("Infect", 0, 0.0, false, 0, 5)
    )),
    GHOST(4, 30, 25, 5, 10, Arrays.asList(
            new Skill("Scream", 25, 0.1, true, 0, 0),
            new Skill("Possess", 0, 0.0, true, 0, 10)
    )),
    DRAGON(10, 200, 50, 40, 40, Arrays.asList(
            new Skill("Fire Breath", 40, 0.25, true, 0, 0),
            new Skill("Tail Swipe", 35, 0.1, false, 0, 0)
    )),
    DEMON(8, 150, 40, 30, 45, Arrays.asList(
            new Skill("Hellfire", 45, 0.2, true, 0, 0),
            new Skill("Dark Pact", 0, 0.0, true, 10, 15)
    ));

    private final int level;
    private final int life;
    private final int magicDefense;
    private final int physicalDefense;
    private final int baseDamage;
    private final List<Skill> abilities;

    EnemyType(int level, int life, int magicDefense, int physicalDefense, int baseDamage, List<Skill> abilities) {
        this.level = level;
        this.life = life;
        this.magicDefense = magicDefense;
        this.physicalDefense = physicalDefense;
        this.baseDamage = baseDamage;
        this.abilities = abilities;
    }

    public int getLevel() {
        return level;
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
