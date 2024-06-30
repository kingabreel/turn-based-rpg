package controller;

import model.Enemy;
import model.Player;
import model.abilities.Effect;
import model.abilities.Skill;
import model.types.EnemyType;
import model.types.PlayerType;

import java.util.List;
import java.util.Random;


public class BattleController {

    private Player player;
    private Enemy enemy;
    private boolean battleRunning;
    private boolean activePlayerShield = false;
    private boolean activeEnemyShield = false;
    private int playerShieldTurns = 0;
    private int enemyShieldTurn = 0;
    private int actionIndex = 0;


    public BattleController(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public int attack(int turn, int attackIndex) {
        actionIndex = attackIndex;
        if (turn == 1){
            return (this.player.getType() == PlayerType.MAGE || this.player.getType() == PlayerType.DRUID) ?
                    this.player.getType().getAbilities().get(attackIndex).getBaseDamage() + this.player.getBaseDamage() - (enemy.getMagicDefense() / 3) :
                    this.player.getType().getAbilities().get(attackIndex).getBaseDamage() + this.player.getBaseDamage() - (enemy.getPhysicalDefense() / 3);
        } else {
            return (enemy.getEnemyType() == EnemyType.GHOST || enemy.getEnemyType() == EnemyType.DEMON ||
                    enemy.getEnemyType() == EnemyType.DRAGON) ? enemy.getEnemyType().getAbilities().get(attackIndex).getBaseDamage() +
                    enemy.getBaseDamage() - this.player.getMagicDefense() :
                    enemy.getEnemyType().getAbilities().get(attackIndex).getBaseDamage() + enemy.getBaseDamage() - this.player.getPhysicalDefense();
        }
    }

    public int defense(int turn, int defenseIndex) {
        actionIndex = defenseIndex;
        if (turn == 1) {
            return this.player.getType().getAbilities().get(defenseIndex).getProtection();
        } else {
            return enemy.getEnemyType().getAbilities().get(defenseIndex).getProtection();
        }
    }

    public int heal(int turn, int healIndex) {
        actionIndex = healIndex;
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
            if (luckyDamage) {
                enemy.setLife(enemy.getLife() - ((damage - enemy.getShield()) + realDamage));
                System.out.println("Você causou " + (damage + realDamage) + " de dano com " + player.getType().getAbilities().get(actionIndex).getName());

            } else {
                enemy.setLife(enemy.getLife() - ((damage - enemy.getShield()) - realDamage));
                System.out.println("Você causou " + (damage - realDamage) + " de dano com " + player.getType().getAbilities().get(actionIndex).getName());
            }
            if (enemy.getShield() != 0) System.out.println("Escudo protegeu " + enemy.getShield() + " pontos de dado");
        } else {
            if (luckyDamage) {
                player.setLife(player.getLife() - ((damage - player.getShield()) + realDamage));
                System.out.println("O inimigo causou " + (damage + realDamage) + " de dano em você utilizando " + enemy.getEnemyType().getAbilities().get(actionIndex).getName());

            } else {
                player.setLife(player.getLife() - ((damage - player.getShield()) - realDamage));
                System.out.println("O inimigo causou " + (damage - realDamage) + " de dano em você utilizando " + enemy.getEnemyType().getAbilities().get(actionIndex).getName());
            }
            if (player.getShield() != 0) System.out.println("Escudo protegeu " + player.getShield() + " pontos de dano");
        }
    }

    public void calculateHeal(int heal, int turn){
        if (turn == 1) {
            player.setLife(player.getLife() + heal);
            System.out.println("Você usou " + player.getType().getAbilities().get(actionIndex).getName() + " e curou " + heal + "hp, vida atual: " + player.getLife());
        } else {
            enemy.setLife(enemy.getLife() + heal);
            System.out.println("Inimigo curou " + heal + "hp, usando " + enemy.getEnemyType().getAbilities().get(actionIndex).getName() + " vida atual: " + enemy.getLife());
        }
    }

    public void calculateProtection(int protection, int turn){
        if (turn == 1) {
            player.setShield(protection);
            addShieldTurn(turn);
            activePlayerShield = true;
            System.out.println("Você usou " + player.getType().getAbilities().get(actionIndex).getName() + ", e obteve um escudo de " + protection + " pontos de resistência criado");
        } else {
            enemy.setShield(protection);
            addShieldTurn(turn);
            activeEnemyShield = true;
            System.out.println("Inimigo criou um escudo de " + protection + " pontos de resistência com a habilidade " +  enemy.getEnemyType().getAbilities().get(actionIndex).getName());
        }
    }

    public void addEffect(int turn){
        Random random = new Random();
        boolean effectChance = random.nextInt(4) == 0;

        if (turn == 1 && player.getType().getAbilities().get(actionIndex).getEffect() != null){
            Skill skill = player.getType().getAbilities().get(actionIndex);

            if (effectChance) {
                enemy.getEffects().add(skill.getEffect());
                enemy.getRoundsPerEffect().add(skill.getEffect().getRounds());
                System.out.println(skill.getName() + " criou um efeito de " + skill.getEffect().name() + " no inimigo");
            }
        } else if (turn != 1 && enemy.getEnemyType().getAbilities().get(actionIndex).getEffect() != null){
            Skill skill = enemy.getEnemyType().getAbilities().get(actionIndex);

            if (effectChance) {
                player.getEffects().add(skill.getEffect());
                player.getRoundsPerEffect().add(skill.getEffect().getRounds());
                System.out.println(skill.getName() + ", do inimigo, criou um efeito de " + skill.getEffect().name() + " em você");
            }
        }
    }

    public void activateEffect(){
        if (!player.getEffects().isEmpty()){
            List<Effect> effects = player.getEffects();

            for (int i = 0; i < effects.size(); i++) {
                player.setLife(player.getLife() - effects.get(i).getDamage());
                player.getRoundsPerEffect().set(i, player.getRoundsPerEffect().get(i) - 1);

                if (!effects.get(i).equals(Effect.SLEEP) || effects.get(i).equals(Effect.STUN)) System.out.println("Efeito ativado: " + player.getEffects().get(i).name() + ", " + player.getEffects().get(i).getDamage() + "hp perdido");

                if (player.getRoundsPerEffect().get(i) == 0) {
                    player.getEffects().remove(player.getEffects().get(i));
                    player.getRoundsPerEffect().remove(player.getRoundsPerEffect().get(i));
                }
            }
        } else if (!enemy.getEffects().isEmpty()){
            List<Effect> effects = enemy.getEffects();

            for (int i = 0; i < effects.size(); i++) {
                enemy.setLife(enemy.getLife() - effects.get(i).getDamage());
                enemy.getRoundsPerEffect().set(i, enemy.getRoundsPerEffect().get(i) - 1);

                if (!effects.get(i).equals(Effect.SLEEP) || effects.get(i).equals(Effect.STUN)) System.out.println("Efeito ativado " + enemy.getEffects().get(i).name() + ", inimigo perdeu " + enemy.getEffects().get(i).getDamage() + "hp");
                if (enemy.getRoundsPerEffect().get(i) == 0) {
                    enemy.getEffects().remove(enemy.getEffects().get(i));
                    enemy.getRoundsPerEffect().remove(enemy.getRoundsPerEffect().get(i));
                }
            }

        }
    }
    private void addShieldTurn(int turn){
        if (turn == 1) playerShieldTurns += 1;
        else enemyShieldTurn += 1;
    }

    public int getPlayerShieldTurns() {
        return playerShieldTurns;
    }

    public void setPlayerShieldTurns(int playerShieldTurns) {
        this.playerShieldTurns = playerShieldTurns;
    }

    public int getEnemyShieldTurn() {
        return enemyShieldTurn;
    }

    public void setEnemyShieldTurn(int enemyShieldTurn) {
        this.enemyShieldTurn = enemyShieldTurn;
    }

    public void setActivePlayerShield(boolean activePlayerShield) {
        this.activePlayerShield = activePlayerShield;
    }

    public void setActiveEnemyShield(boolean activeEnemyShield) {
        this.activeEnemyShield = activeEnemyShield;
    }
}
