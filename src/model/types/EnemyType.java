package model.types;

import model.abilities.Effect;
import model.abilities.Skill;

import java.util.Arrays;
import java.util.List;

public enum EnemyType {
    GOBLIN(Arrays.asList(
            new Skill("Strike", 5, 0.05, false, 0, 0, null),
            new Skill("Dodge", 0, 0.0, false, 0, 10, null)
    )),
    ORC(Arrays.asList(
            new Skill("Swing", 7, 0.1, false, 0, 0, null),
            new Skill("Rage", 2, 0.0, false, 0, 0, null)
    )),
    TROLL(Arrays.asList(
            new Skill("Attack", 8, 0.2, false, 0, 0, Effect.BLEED),
            new Skill("Regenerate", 0, 0.0, true, 12, 0, null)
    )),
    VAMPIRE( Arrays.asList(
            new Skill("Blood Suck", 3, 0.15, true, 5, 2, Effect.BLEED),
            new Skill("Bat", 7, 0.1, true, 0, 0, null)
    )),
    WEREWOLF(Arrays.asList(
            new Skill("Claw", 12, 0.2, false, 0, 0, Effect.BLEED),
            new Skill("Howl", 0, 0.0, false, 0, 10, null)
    )),
    SKELETON(Arrays.asList(
            new Skill("Bone Throw", 8, 0.1, false, 0, 0, Effect.STUN),
            new Skill("Break", 0, 0.0, false, 4, 5, null)
    )),
    ZOMBIE(Arrays.asList(
            new Skill("Bite", 6, 0.05, false, 3, 2, Effect.POISON),
            new Skill("Infect", 0, 0.0, false, 0, 5, Effect.SLEEP)
    )),
    GHOST(Arrays.asList(
            new Skill("Scream", 13, 0.1, true, 0, 0, null),
            new Skill("Possess", 0, 0.0, true, 0, 10, Effect.SLEEP)
    )),
    DRAGON(Arrays.asList(
            new Skill("Fire Breath", 15, 0.25, true, 0, 0, Effect.FIRE),
            new Skill("Tail Swipe", 23, 0.1, false, 0, 0, Effect.STUN)
    )),
    DEMON(Arrays.asList(
            new Skill("Hellfire", 14, 0.2, true, 0, 0, Effect.FIRE),
            new Skill("Dark Pact", 0, 0.0, true, 10, 15, Effect.EVIL)
    ));

    private final List<Skill> abilities;

    EnemyType(List<Skill> abilities) {
        this.abilities = abilities;
    }


    public List<Skill> getAbilities() {
        return abilities;
    }
}
