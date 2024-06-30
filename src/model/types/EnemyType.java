package model.types;

import model.abilities.Skill;

import java.util.Arrays;
import java.util.List;

public enum EnemyType {
    GOBLIN(Arrays.asList(
            new Skill("Strike", 3, 0.05, false, 0, 0),
            new Skill("Dodge", 0, 0.0, false, 0, 10)
    )),
    ORC(Arrays.asList(
            new Skill("Swing", 7, 0.1, false, 0, 0),
            new Skill("Rage", 2, 0.0, false, 0, 0)
    )),
    TROLL(Arrays.asList(
            new Skill("Attack", 4, 0.2, false, 0, 0),
            new Skill("Regenerate", 0, 0.0, true, 5, 0)
    )),
    VAMPIRE( Arrays.asList(
            new Skill("Blood Suck", 5, 0.15, true, 5, 2),
            new Skill("Bat", 7, 0.1, true, 0, 0)
    )),
    WEREWOLF(Arrays.asList(
            new Skill("Claw", 12, 0.2, false, 0, 0),
            new Skill("Howl", 0, 0.0, false, 0, 10)
    )),
    SKELETON(Arrays.asList(
            new Skill("Bone Throw", 8, 0.1, false, 0, 0),
            new Skill("Break", 0, 0.0, false, 4, 5)
    )),
    ZOMBIE(Arrays.asList(
            new Skill("Bite", 6, 0.05, false, 3, 2),
            new Skill("Infect", 0, 0.0, false, 0, 5)
    )),
    GHOST(Arrays.asList(
            new Skill("Scream", 25, 0.1, true, 0, 0),
            new Skill("Possess", 0, 0.0, true, 0, 10)
    )),
    DRAGON(Arrays.asList(
            new Skill("Fire Breath", 40, 0.25, true, 0, 0),
            new Skill("Tail Swipe", 35, 0.1, false, 0, 0)
    )),
    DEMON(Arrays.asList(
            new Skill("Hellfire", 45, 0.2, true, 0, 0),
            new Skill("Dark Pact", 0, 0.0, true, 10, 15)
    ));

    private final List<Skill> abilities;

    EnemyType(List<Skill> abilities) {
        this.abilities = abilities;
    }


    public List<Skill> getAbilities() {
        return abilities;
    }
}
