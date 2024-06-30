package controller;

import model.Enemy;
import model.Player;
import model.types.EnemyType;
import model.types.PlayerType;

import java.util.Random;


public class BattleController {

    private Player player;
    private Enemy enemy;
    private boolean battleRunning;

    public BattleController(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public int attack(int turn, int attackIndex) {
        if (turn == 1){
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

    public int defense(int turn, int defenseIndex) {
        if (turn == 1) {
            return this.player.getType().getAbilities().get(defenseIndex).getProtection();
        } else {
            return enemy.getEnemyType().getAbilities().get(defenseIndex).getProtection();
        }
    }

    public int heal(int turn, int healIndex) {
        if (turn == 1){
            return this.player.getType().getAbilities().get(healIndex).getHealAmount();
        } else {
            return enemy.getEnemyType().getAbilities().get(healIndex).getHealAmount();
        }
    }

    public boolean run() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public boolean isBattleRunning() {
        return battleRunning;
    }

    public void setBattleRunning(boolean battleRunning) {
        this.battleRunning = battleRunning;
    }

    public void calculateAttack(int damage, int turn){
        Random random = new Random();

        boolean luckyDamage = random.nextBoolean();
        int realDamage = random.nextInt(3);

        if (turn == 1){
            if (luckyDamage) enemy.setLife(enemy.getLife() - (damage + realDamage));
            else enemy.setLife(enemy.getLife() - (damage - realDamage));

            System.out.println("Você causou " + (damage + realDamage));
        } else {
            if (luckyDamage) player.setLife(player.getLife() - (damage + realDamage));
            else player.setLife(player.getLife() - (damage - realDamage));
            System.out.println("O inimigo causou " + (damage + realDamage) + " de dano em você");

        }
    }

    public void calculateHeal(int heal, int turn){
        if (turn == 1) {
            player.setLife(player.getLife() + heal);
            System.out.println("Você curou " + heal + "hp, vida atual: " + player.getLife());
        } else {
            enemy.setLife(enemy.getLife() + heal);
            System.out.println("Inimigo se curou com " + heal + "hp, vida atual: " + enemy.getLife());
        }
    }

    public void calculateProtection(int protection, int turn){
        if (turn == 1) {
            player.setLife(player.getLife() + protection);
            System.out.println("Escudo de " + protection + " de resistência criado");
        } else {
            enemy.setLife(enemy.getLife() + protection);
            System.out.println("Inimigo criou um escudo de " + protection + "de resistência");
        }
    }
}
