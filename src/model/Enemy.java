package model;

import model.abilities.Effect;
import model.types.EnemyType;

import java.util.List;

public class Enemy extends Character{
    private final EnemyType enemyType;
    public Enemy(String name, int level, int life, boolean alive, int magicDefense, int physicalDefense, int baseDamage, List<Effect> effects, EnemyType enemyType) {
        super(name, level, life, alive, magicDefense, physicalDefense, baseDamage, effects);
        this.enemyType = enemyType;
    }

    public EnemyType getEnemyType() {
        return enemyType;
    }
}
