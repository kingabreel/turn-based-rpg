package model;

import model.abilities.Effect;
import model.types.EnemyType;

import java.util.List;

public class Enemy extends Character{
    private final EnemyType enemyType;
    private int xpReward;

    public Enemy(String name, int level, int life, boolean alive, int magicDefense, int physicalDefense, int baseDamage, List<Effect> effects, EnemyType enemyType) {
        super(name, level, life, alive, magicDefense, physicalDefense, baseDamage, effects);
        this.enemyType = enemyType;
        this.xpReward = 10;
    }

    public EnemyType getEnemyType() {
        return enemyType;
    }

    public int getXpReward() {
        return xpReward;
    }

    public void setXpReward(int xpReward) {
        this.xpReward = xpReward;
    }

    @Override
    public String toString() {
        return "Nome: " + getName() +
                "Tipo: " + getEnemyType() +
                "Hp: " + getLife() +
                "Dano Base: " + getBaseDamage() +
                "Recompensa: " + getXpReward();
    }
}
