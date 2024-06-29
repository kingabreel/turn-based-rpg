package view.abilities;

public class ActiveEffect {
    private int rounds;
    private int damage;
    private int missAttackRate;


    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMissAttackRate() {
        return missAttackRate;
    }

    public void setMissAttackRate(int missAttackRate) {
        this.missAttackRate = missAttackRate;
    }
}
