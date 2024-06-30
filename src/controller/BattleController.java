package controller;

import model.Enemy;
import model.Player;
import model.types.EnemyType;
import model.types.PlayerType;

import java.util.Random;


public class BattleController implements Action{

    private Player player;
    private Enemy enemy;

    public BattleController(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    @Override
    public int attack(boolean player, int attackIndex) {
        if (player){
            return (this.player.getType() == PlayerType.MAGE || this.player.getType() == PlayerType.DRUID) ?
                    this.player.getType().getAbilities().get(attackIndex).getBaseDamage() + this.player.getBaseDamage() - enemy.getMagicDefense() :
                    this.player.getType().getAbilities().get(attackIndex).getBaseDamage() + this.player.getBaseDamage() - enemy.getPhysicalDefense();
        } else {
            return (enemy.getEnemyType() == EnemyType.GHOST || enemy.getEnemyType() == EnemyType.DEMON ||
                    enemy.getEnemyType() == EnemyType.DRAGON) ? enemy.getEnemyType().getAbilities().get(attackIndex).getBaseDamage() +
                    enemy.getBaseDamage() - this.player.getMagicDefense() :
                    enemy.getEnemyType().getAbilities().get(attackIndex).getBaseDamage() + enemy.getBaseDamage() - this.player.getPhysicalDefense();
        }
    }

    @Override
    public int defense(boolean player, int defenseIndex) {
        if (player) {
            return this.player.getType().getAbilities().get(defenseIndex).getProtection();
        } else {
            return enemy.getEnemyType().getAbilities().get(defenseIndex).getProtection();
        }
    }

    @Override
    public int heal(boolean player, int healIndex) {
        if (player){
            return this.player.getType().getAbilities().get(healIndex).getHealAmount();
        } else {
            return enemy.getEnemyType().getAbilities().get(healIndex).getHealAmount();
        }
    }

    @Override
    public boolean run() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
